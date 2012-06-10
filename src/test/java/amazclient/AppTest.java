package amazclient;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.*;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    public void testMd5() throws FileNotFoundException {
        File file = new File("tmp_file.xml");
        if(!file.exists()) {
            throw new IllegalArgumentException("文件不存在");
        }
        FileInputStream inputStream = new FileInputStream(file);
        System.out.println("========>" + computeContentMD5Header(inputStream));
    }

    /**
     * Consume the stream and return its Base-64 encoded MD5 checksum.
     */
    public static String computeContentMD5Header(InputStream inputStream) {
        // Consume the stream to compute the MD5 as a side effect.
        DigestInputStream s;
        try {
            s = new DigestInputStream(inputStream,  MessageDigest.getInstance("MD5"));
            byte[] buffer = new byte[8192];
            while (s.read(buffer) > 0) ;
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(s.getMessageDigest().digest()), "UTF-8");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
