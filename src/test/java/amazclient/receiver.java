package amazclient;

import java.io.*;
import java.util.*;

public class receiver extends Thread {
    PipedInputStream in = new PipedInputStream();

    public PipedInputStream getIn() {
        return in;
    }

    public void run() {
        byte[] buf = new byte[1024];
        try {
            int len = in.read(buf);
            System.out.println("the   following   is   from   sender:\n " + new String(buf, 0, len));
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
