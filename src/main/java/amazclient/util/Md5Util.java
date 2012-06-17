package amazclient.util;

import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * User: Luo
 * Date: 12-6-17
 * Time: 下午9:48
 */
public class Md5Util {

    /**
     * Consume the stream and return its Base-64 encoded MD5 checksum.
     */
    public static String computeContentMD5Header(InputStream inputStream) {
        // Consume the stream to compute the MD5 as a side effect.
        DigestInputStream s;
        try {
            s = new DigestInputStream(inputStream, MessageDigest.getInstance("MD5"));
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
