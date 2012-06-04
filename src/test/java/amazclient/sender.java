package amazclient;

import java.io.*;
import java.util.*;

public class sender extends Thread {
    PipedOutputStream out = new PipedOutputStream();

    public PipedOutputStream getOut() {
        return out;
    }

    public void run() {
        String str = "Hello,receiver   !   I`m   sender\n ";
        try {
            out.write(str.getBytes());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 