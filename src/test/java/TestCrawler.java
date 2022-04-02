import com.alibaba.fastjson.JSONObject;
import com.eaproject.util.Crawler;

import java.io.IOException;

public class TestCrawler {
    public static void main(String[] args) {
        String url ="https://dxx.jsutstudy.work/api/getStatistics?current=1&pageSize=20&";

        try {
            Crawler crawler = new Crawler(url);
//            System.out.println(crawler.getResult());
            JSONObject object = JSONObject.parseObject(crawler.getResult());
            System.out.println(object.getString("code"));
            JSONObject data = JSONObject.parseObject(object.getString("data"));
            String update_time = data.getString("update_time");
//            String finish = total.getString("finish");
            System.out.println(update_time);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
