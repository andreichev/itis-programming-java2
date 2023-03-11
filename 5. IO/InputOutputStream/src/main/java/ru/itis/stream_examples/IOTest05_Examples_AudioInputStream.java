package ru.itis.stream_examples;

import javax.sound.sampled.*;
import java.io.IOException;

public class IOTest05_Examples_AudioInputStream {

    public static void main(String[] args) {
        AudioInputStream stream = null;
        try {
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
