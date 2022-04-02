package com.eaproject.dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eaproject.Config;
import com.eaproject.util.Crawler;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoadMessage_NZDB {
    private String urlText = "http://www.nzdb.com.cn/content_page.jspx?typeId=2&orderBy=4&channelOption=1&channelId=40,11,15,12,41,13,14,86";
    private int total = 0;
    private boolean status = false;
    private String date[] = new String[Config.MAXMESSAGE];
    private String link[] = new String[Config.MAXMESSAGE];
    private String title[] = new String[Config.MAXMESSAGE];

    public LoadMessage_NZDB() throws IOException {
        Crawler crawler = new Crawler(urlText);
        JSONObject all = JSONObject.parseObject(crawler.getResult());
//        JSONObject result = JSONObject.parseObject(all.getString("result"));
//        total = result.getIntValue("total");
//        System.out.println(result.toString());
        String message = all.getString("ret");
//        System.out.println(result.getJSONArray("data"));
        JSONArray data = JSONArray.parseArray(all.getString("data"));

        Date time = new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sysTime = format.format(time);

        if(message.compareTo("1") == 0){
            System.out.println("LoadMessage_NZDB发来贺电：中国农资导报网爬取成功！");
            this.status = true;
            for(int i = 0; i<10; i++){
                JSONObject document = JSONObject.parseObject(data.getString(i));
                date[i] = sysTime;
                link[i] = "http://www.nzdb.com.cn/"+document.getString("url");
                title[i] = document.getString("title");
//                System.out.println("数据"+i+"获取成功");
            }
            total = 10;
        }else {
            System.out.println("vLoadMessage_NZDB致来谦词：我不对劲，请修理我");
        }
    }


    public String[] getDate() {
        return date;
    }

    public String[] getLink() {
        return link;
    }

    public String[] getTitle() {
        return title;
    }

    public int getTotal() {
        return total;
    }

    public boolean isStatus() {
        return status;
    }
}
