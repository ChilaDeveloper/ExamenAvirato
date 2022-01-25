package com.example.examen.services.utils;

import com.example.examen.model.HttpDate;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

public class HttpService {

    private HttpsURLConnection httpConexion;

    public HttpDate post(String body, String urlDate){
        HttpDate httpDate = new HttpDate();

        try {

            URL url = new URL(urlDate);

            byte[] postData = body.getBytes(StandardCharsets.UTF_8);

            httpConexion = (HttpsURLConnection)url.openConnection();
            httpConexion.setDoOutput(true);
            httpConexion.setRequestMethod("POST");
            httpConexion.setRequestProperty("User-Agent", "Java client");
            httpConexion.setRequestProperty("Content-Type", "application/json");

            try (DataOutputStream wr = new DataOutputStream(httpConexion.getOutputStream())) {
                wr.write(postData);
            }

            String newBody="";

            BufferedReader br = null;

            if (httpConexion.getResponseCode() == 200) {
                br = new BufferedReader(new InputStreamReader(httpConexion.getInputStream()));
                String strCurrentLine;
                while ((strCurrentLine = br.readLine()) != null) {
                    newBody += strCurrentLine;
                }
            } else {
                br = new BufferedReader(new InputStreamReader(httpConexion.getErrorStream()));
                String strCurrentLine;
                while ((strCurrentLine = br.readLine()) != null) {
                    newBody += strCurrentLine;
                }
            }

            httpDate.setBody(newBody);
            httpDate.setStatusCode(httpConexion.getResponseCode());

        } catch (MalformedURLException e) {
            httpDate.setBody(e.toString());
            httpDate.setStatusCode(400);
            //URL incorrect
        } catch (Exception e) {
            httpDate.setBody(e.toString());
            httpDate.setStatusCode(400);
        } finally {
            httpConexion.disconnect();
            return httpDate;
        }

    }

    //implementation proces
    public Object get(String body, String urlDate){
        HttpDate httpDate = new HttpDate();

        try {

            URL url = new URL(urlDate);

            byte[] postData = body.getBytes(StandardCharsets.UTF_8);

            httpConexion = (HttpsURLConnection)url.openConnection();
//            httpConexion.setDoOutput(true);
            httpConexion.setRequestMethod("GET");
            httpConexion.setRequestProperty("User-Agent", "Java client");
            httpConexion.setRequestProperty("Content-Type", "application/json");
//
//            try (DataOutputStream wr = new DataOutputStream(httpConexion.getOutputStream())) {
//                wr.write(postData);
//            }

            String newBody="";

            BufferedReader br = null;

            if (httpConexion.getResponseCode() == 200) {
                br = new BufferedReader(new InputStreamReader(httpConexion.getInputStream()));
                String strCurrentLine;
                while ((strCurrentLine = br.readLine()) != null) {
                    newBody += strCurrentLine;
                }
            } else {
                br = new BufferedReader(new InputStreamReader(httpConexion.getErrorStream()));
                String strCurrentLine;
                while ((strCurrentLine = br.readLine()) != null) {
                    newBody += strCurrentLine;
                }
            }

            httpDate.setBody(newBody);
            httpDate.setStatusCode(httpConexion.getResponseCode());

        } catch (MalformedURLException e) {
            httpDate.setBody(e.toString());
            httpDate.setStatusCode(400);
            //URL incorrect
        } catch (Exception e) {
            httpDate.setBody(e.toString());
            httpDate.setStatusCode(400);
        } finally {
            httpConexion.disconnect();
            return httpDate;
        }
    }
}
