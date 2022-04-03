package com.eaproject.dao;

import com.eaproject.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetMessageDao_NZDB {
    private List<String> maraMessage = new ArrayList<String>();
    private List<String> maraLink = new ArrayList<String>();
    private List<Date> maraTime = new ArrayList<Date>();
    private int messageNum = Config.MAXMESSAGE;
    public GetMessageDao_NZDB() {
        String url = "jdbc:mysql://127.0.0.1:3306/easyagricultural?useUnicode=true&characterEncoding=utf8&useSSL=false";
        Statement state = null;
        Connection conn = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection(url, "root", "2002525wyh1+1=2");
            state = conn.createStatement();
            System.out.println("GetMessageDao_NZDB发来贺电：数据库连接成功！");
//            String sql = "select * from message where source"
            for(int i=0; i<messageNum; i++ ){
                String source = "NZDB" + i;
                String sql = "select * from message where source ='"+source+"';";
                ResultSet rs = state.executeQuery(sql);
                while (rs.next() != false){
                    this.maraMessage.add(rs.getString("title"));
                    this.maraLink.add(rs.getString("link"));
                    this.maraTime.add(rs.getDate("date"));
//                    System.out.println(maraLink.get(i));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //6.关闭资源
            try {
                if (state != null) {
                    state.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> getNZDBMessage() {
        return maraMessage;
    }

    public List<String> getNZDBLink() {
        return maraLink;
    }

    public List<Date> getNZDBTime() {
        return maraTime;
    }

    public int getMessageNum() {
        return messageNum;
    }
}
