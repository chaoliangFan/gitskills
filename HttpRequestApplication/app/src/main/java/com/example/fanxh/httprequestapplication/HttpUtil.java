package com.example.fanxh.httprequestapplication;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by fanxh on 2017/10/11.
 */

public class HttpUtil {
    public static String sendHttpRequest(String address) {
        HttpURLConnection httpURLConnection = null;
        InputStream in = null;
        StringBuilder respone = null;
        try {
            URL url = new URL(address);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            in = httpURLConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            respone = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                respone.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return respone.toString();
    }
}
