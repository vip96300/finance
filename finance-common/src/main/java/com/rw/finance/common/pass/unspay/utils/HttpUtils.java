package com.rw.finance.common.pass.unspay.utils;

import com.google.gson.Gson;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.*;

/**
 * @Author huanghongfei
 * @Description description
 * @Date Create in 11:30 2018/4/26
 */
public class HttpUtils {

    /**
     * json请求
     * @param url
     * @param params
     */
    public static String jsonRequest(String url,Map<String,String> params){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> formParams = new ArrayList<>();
        for(Map.Entry<String, String> map:params.entrySet()){
            formParams.add(new BasicNameValuePair(map.getKey(),map.getValue()));
        }
        HttpEntity entity;
        CloseableHttpResponse response;
        String json=null;
        try {
            System.err.println(new Gson().toJson(params));
            StringEntity stringEntity=new StringEntity(new Gson().toJson(params),"UTF-8");
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            entity = response.getEntity();
            json= EntityUtils.toString(entity, "UTF-8");
            httpClient.close();
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 表单请求
     * @param url
     * @param params
     * @throws IOException
     */
    public static String formRequest(String url,Map<String,String> params) throws IOException{
        String response=null;
        try{
            HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("Charset", "UTF-8");;
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            StringBuilder requestContent=new StringBuilder();
            Set<String> keys = params.keySet();
            for(String key : keys){
                requestContent.append(key);
                requestContent.append("=");
                requestContent.append(params.get(key));
                requestContent.append("&");
            }
            requestContent = requestContent.delete(requestContent.length()-1,requestContent.length());
            DataOutputStream ds = new DataOutputStream(connection.getOutputStream());
            ds.write(requestContent.toString().getBytes());
            ds.flush();
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
                String s = "";
                String temp;
                while((temp = reader.readLine()) != null){
                    s += temp;
                }
                response = s;
                reader.close();
            }catch(IOException e){
                e.printStackTrace();
            }
            ds.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return response;
    }
}
