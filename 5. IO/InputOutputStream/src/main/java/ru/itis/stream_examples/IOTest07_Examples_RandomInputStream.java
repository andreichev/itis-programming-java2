package ru.itis.stream_examples;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class IOTest07_Examples_RandomInputStream {

    public static void main(String[] args) {
        try (RandomInputStream in = new RandomInputStream()) {
            System.out.println(in.read());
            System.out.println(in.read());
            System.out.println(in.read());
        } catch (IOException ex) {
            ex.printStackTrace();//Don't do this in real program
        }
    }

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
}
