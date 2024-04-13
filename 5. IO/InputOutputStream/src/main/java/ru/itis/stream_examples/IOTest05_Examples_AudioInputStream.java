package ru.itis.stream_examples;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class IOTest05_Examples_AudioInputStream {

    protected static class RandomInputStream extends InputStream {
        protected boolean closed;
        protected Random generator;

        public RandomInputStream() {
            closed = false;
            generator = new Random();
        }

        @Override
        public int read() throws IOException {
            if (closed) {
                throw new IOException("Stream is closed.");
            }
            return Math.abs(generator.nextInt() % 256); // Only one positive byte should be returned!
        }

        @Override
        public void close() {
            closed = true;
        }

        // Some other methods could be implemented

    }

    public static void main(String[] args) {
        AudioInputStream stream = null;
        try {
            // AudioFormat format = new AudioFormat( 12000, 24, 1, true, true);
            // stream = new AudioInputStream(new RandomInputStream(), format, 10000);
            stream = AudioSystem.getAudioInputStream(Utils.getTestAudioUrl());
            AudioFormat format = stream.getFormat();
            if (format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
                format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, format
                        .getSampleRate(), format.getSampleSizeInBits() * 2, format
                        .getChannels(), format.getFrameSize() * 2, format.getFrameRate(),
                        true); // big endian
                stream = AudioSystem.getAudioInputStream(format, stream);
            }

            SourceDataLine.Info info = new DataLine.Info(SourceDataLine.class, stream
                    .getFormat(), ((int) stream.getFrameLength() * format.getFrameSize()));
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(stream.getFormat());
            line.start();

            int numRead = 0;
            byte[] buf = new byte[line.getBufferSize()];
            while ((numRead = stream.read(buf, 0, buf.length)) >= 0) {
                int offset = 0;
                while (offset < numRead) {
                    offset += line.write(buf, offset, numRead - offset);
                }
            }
            line.drain();
            line.stop();
        } catch (IOException ex) {
            ex.printStackTrace();//Don't do this in real program
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();//Don't do this in real program
        } catch (UnsupportedAudioFileException ex) {
            ex.printStackTrace();//Don't do this in real program
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();//Don't do this in real program
                }
            }
        }
    }
}
