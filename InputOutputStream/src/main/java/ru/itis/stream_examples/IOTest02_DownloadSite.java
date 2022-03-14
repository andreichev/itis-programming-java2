package ru.itis.stream_examples;

import java.io.IOException;
import java.io.InputStream;

public class IOTest02_DownloadSite {
    public static void main(String[] args) {
        InputStream in;
        in = null;
        try {
            in = Utils.getTestRemoteInputStream();
            int b;
            while ((b = in.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            // We should try to close stream due it was opened. But close could throw IoException too.
            if (in != null) { // What if we haven't even open stream?
                try {
                    in.close();
                } catch (IOException exClose) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }
}
