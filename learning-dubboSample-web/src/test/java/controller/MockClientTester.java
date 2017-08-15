package controller;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Zhang Junwei on 2017/8/15.
 */
public class MockClientTester {

    int count = 1000;

    private OkHttpClient httpClient;

    public MockClientTester() {
        httpClient = new okhttp3.OkHttpClient.Builder()
                .connectTimeout(6L, TimeUnit.SECONDS)
                .readTimeout(6L, TimeUnit.SECONDS)
                .build();

    }

    public String post(String url) throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("userName", "jack").add("password", "123").build();

        Request request = new Request.Builder().url(url).post(formBody).build();
        Response response = httpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        }
        return "";
    }

    public void stop() {
        httpClient = null;
    }

    public static void main(String[] args) {
        //一万个客户端
        final long client = 100L;
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < client; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    MockClientTester client = new MockClientTester();
                    try {
                        for (int j = 0; j < client.count; j++) {
                            String post = client.post("http://localhost:8080/dubboSample/user/login");
                            System.out.println(Thread.currentThread().getName() + ":" + post);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    client.stop();
                    client = null;
                    System.out.println("###########################client stop");
                }
            });
        }
    }

}
