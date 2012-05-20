package amazclient;

import junit.framework.TestCase;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Luo
 * Date: 12-5-20
 * Time: 下午5:15
 */
public class HttpClientTest extends TestCase{

    public void test1() throws IOException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("http://www.baidu.com/");
        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            long len = entity.getContentLength();
            if (len != -1 && len < 10240) {
                System.out.println(EntityUtils.toString(entity));
            } else {
                System.out.println("rsp is too long");
            }
        }
    }
}
