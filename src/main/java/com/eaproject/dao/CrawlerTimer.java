package com.eaproject.dao;

import com.eaproject.Config;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CrawlerTimer {
    public CrawlerTimer() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    LoadMessageDao_MARA loadMessageDao_mara = new LoadMessageDao_MARA();
                    LoadMessageDao_NZDB loadMessageDao_nzdb = new LoadMessageDao_NZDB();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                System.out.println("数据库爬取已执行");
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable,0, Config.CRAWLERTIME, TimeUnit.HOURS);
    }
}
