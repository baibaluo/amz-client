package amazclient;

import java.io.*;

class TestPiped {
    public static void main(String[] args) {
        sender s = new sender();
        receiver r = new receiver();
        PipedOutputStream out = s.getOut();
        PipedInputStream in = r.getIn();
        try {
            in.connect(out);
            s.start();
            r.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 