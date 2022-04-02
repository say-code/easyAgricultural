package com.eaproject.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eaproject.Config;
import com.eaproject.util.Crawler;

import java.io.IOException;
import java.util.List;

public class LoadMessage_MARA {
    private String urlText = "http://zdscxx.moa.gov.cn:8080/nyb/getMessages";
    private int total = 0;
    private boolean status = false;
    private String date[] = new String[Config.MAXMESSAGE];
    private String link[] = new String[Config.MAXMESSAGE];
    private String title[] = new String[Config.MAXMESSAGE];


    public LoadMessage_MARA() throws IOException {
        Crawler crawler = new Crawler(urlText);
        JSONObject all = JSONObject.parseObject(crawler.getResult());
        JSONObject result = JSONObject.parseObject(all.getString("result"));
        total = result.getIntValue("total");
//        System.out.println(result.toString());
        String message = all.getString("message");
//        System.out.println(result.getJSONArray("table"));
        JSONArray table = JSONArray.parseArray(result.getString("table"));
        if(message.compareTo("success") == 0){
            System.out.println("LoadMessage_MARA发来贺电：中华人名共和国农业农村部网爬取成功！");
            this.status = true;
            if( total>10 )total = 10;
            for(int i = 0; i<10; i++){
                JSONObject document = JSONObject.parseObject(table.getString(i));
                date[i] = document.getString("date");
                link[i] = document.getString("link");
                title[i] = document.getString("title");
//                System.out.println(date[i]);
//                System.out.print(link[i]);
//                System.out.println(title[i]);
//                System.out.println("数据"+i+"获取成功");
            }
        }else {
            System.out.println("vLoadMessage_MARA致来谦词：我不对劲，请修理我");
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
