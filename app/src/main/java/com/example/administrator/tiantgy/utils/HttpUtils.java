package com.example.administrator.tiantgy.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Administrator on 2015/6/15.
 */
public class HttpUtils {

    /**post请求*/
    public static String post(String url,Map<String,String> map){
        HttpClient httpClient=new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        ArrayList<NameValuePair> params=new ArrayList<>();
        for (Map.Entry<String,String> entry:map.entrySet()){
            NameValuePair nameValuePair=new BasicNameValuePair(entry.getKey(),entry.getValue());
            params.add(nameValuePair);
        }
        try {
            UrlEncodedFormEntity encodedFormEntity=new UrlEncodedFormEntity(params,"utf-8");
            post.setEntity(encodedFormEntity);
            HttpResponse response=httpClient.execute(post);
            if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
                HttpEntity entity=response.getEntity();
                String reult = EntityUtils.toString(entity);
                return  reult;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

//    /**post请求*/
//    public static Bitmap postImage(String url,Map<String,String> map){
//        HttpClient httpClient=new DefaultHttpClient();
//        HttpPost post = new HttpPost(url);
//        ArrayList<NameValuePair> params=new ArrayList<>();
//        for (Map.Entry<String,String> entry:map.entrySet()){
//            NameValuePair nameValuePair=new BasicNameValuePair(entry.getKey(),entry.getValue());
//            params.add(nameValuePair);
//        }
//        try {
//            UrlEncodedFormEntity encodedFormEntity=new UrlEncodedFormEntity(params,"utf-8");
//            post.setEntity(encodedFormEntity);
//            HttpResponse response=httpClient.execute(post);
//            if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
//                HttpEntity entity=response.getEntity();
//                Bitmap bitmap = BitmapFactory.decodeStream(entity.getContent());                byte[] bytes = EntityUtils.toByteArray(entity);
//
//                return  bitmap;
//            }
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    /**
     * HttpClient
     *
     * HttpUrlconnection
     *
     * @param url
     * @return
     */
    public static Bitmap getBitmapFormUrl(String url) {
        Bitmap bitmap = null;
        HttpClient httpClient = new DefaultHttpClient();
        // 设置超时时间
        HttpConnectionParams.setConnectionTimeout(new BasicHttpParams(), 6 * 1000);
        HttpGet get = new HttpGet(url);
        try {
            HttpResponse response = httpClient.execute(get);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                bitmap = BitmapFactory.decodeStream(entity.getContent());
                return bitmap;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
