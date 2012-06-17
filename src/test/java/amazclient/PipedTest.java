package amazclient;

import amazclient.util.Md5Util;
import junit.framework.TestCase;

import java.io.*;

public class PipedTest extends TestCase{
/*    public static void main(String[] args) {
        sender s = new sender();
        receiver r = new receiver();
        PipedOutputStream out = s.getOut();
        PipedInputStream in = r.getIn();
        try {
            in.connect(out);
            s.start();
            r.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public void test1() throws IOException {
        final PipedOutputStream out = new PipedOutputStream();
        final PipedInputStream in = new PipedInputStream(out);

        new Writer(out, "000000").start();
        String md5Str = Md5Util.computeContentMD5Header(in);
        System.out.println(md5Str);
        final PipedOutputStream out2 = new PipedOutputStream();
        final PipedInputStream in2 = new PipedInputStream(out2);
        new Writer(out2, "000000").start();
        String md5Str2 = Md5Util.computeContentMD5Header(in2);
        System.out.println(md5Str2);
    }

    class Writer extends Thread{
        PipedOutputStream out;
        String str;
        public Writer(PipedOutputStream out, String str){
            this.out = out;
            this.str = str;
        }

        @Override
        public void run() {
            try {
                out.write(str.getBytes());
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
