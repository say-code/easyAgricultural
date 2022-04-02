package com.eaproject.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Crawler  {
    private String result =new String();
    //定义一个Url对象用于制定一个地址


    public Crawler(String urlText) throws IOException {
        URL url = null;
        //定义一个StringBuffer，用于储存结果
        StringBuilder tempResult = new StringBuilder();
        //创建一个HttpURLConnection连接对象
        HttpURLConnection conn = null;
        url = new URL(urlText);
        conn = (HttpURLConnection)url.openConnection();
        //指定请求的类型
        conn.setRequestMethod("GET");
        //开始请求
        conn.connect();
        //使用一个输入流接收数据
        InputStream is = conn.getInputStream();
        //!@#$^&*
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String readStr = null;
        //将数据一行一行的存入StringBuffer
        while((readStr = br.readLine()) != null) {
            tempResult.append(readStr);
            tempResult.append("\r\n");
        }
        //关闭流
        br.close();
        this.result = tempResult.toString();
    }

    public String getResult() {
        return result;
    }


}
