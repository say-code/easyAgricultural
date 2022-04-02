package com.eaproject.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LoadMessageDao_NZDB {
    public LoadMessageDao_NZDB() throws IOException {
        String url = "jdbc:mysql://127.0.0.1:3306/easyagricultural?useUnicode=true&characterEncoding=utf8&useSSL=false";
        Statement state = null;
        Connection conn = null;
        try{

        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url,"root","2002525wyh1+1=2");
        System.out.println("LoadMessageDao_NZDB发来贺电：数据库连接成功！");
        state = conn.createStatement();
        LoadMessage_NZDB loadMessage_nzdb = new LoadMessage_NZDB();
        int amountNZDB = loadMessage_nzdb.getTotal();
        String title[] = loadMessage_nzdb.getTitle();
        String link[] = loadMessage_nzdb.getLink();
        String date[] = loadMessage_nzdb.getDate();
        for(int i = 0; i<amountNZDB; i++){
            String source = "NZDB"+i;
            String sql = "select * from message where source = '"+source+"';";
            if (!state.executeQuery(sql).next()){
                sql = "insert into message(source,title,link,date)values ('"+source+"', '"+title[i]+"','"+link[i]+"','"+date[i]+"');";
                state.executeUpdate(sql);
//                System.out.println("数据插入成功!");
            }else {
                sql = "update message set title = '"+title[i]+"',link = '"+link[i]+"',date = '"+date[i]+"'where source = '"+source+"';";
                state.executeUpdate(sql);
//                System.out.println("数据更新成功!");
            }

        } System.out.println("LoadMessageDao_NZDB发来贺电：数据加载成功！");
    }catch (ClassNotFoundException e ){
        e.printStackTrace();
    }catch (
    SQLException throwables) {
        throwables.printStackTrace();
    }finally {
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
}
