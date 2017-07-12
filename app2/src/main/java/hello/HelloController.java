package hello;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.text.ParseException;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot from app2!";
    }

    @RequestMapping("/connect")
    public String connect() {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();

        HttpGet httpget = new HttpGet("http://172.18.0.2:8080/");

        HttpResponse response;
        try {
            response = httpclient.execute(httpget);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        HttpEntity entity = response.getEntity();

        String out = null;

        if (entity != null) {
            try {
                out = EntityUtils.toString(response.getEntity());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return out;

    }

}
