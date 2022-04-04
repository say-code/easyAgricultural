package com.eaproject.dao;

import com.eaproject.Config;

import java.io.IOException;
import java.sql.*;

public class LoadMessageDao_MARA {
    public LoadMessageDao_MARA() throws IOException {
        String url = "jdbc:mysql://127.0.0.1:"+ Config.PORT+"/easyagricultural?useUnicode=true&characterEncoding=utf8&useSSL=false";
        Statement state = null;
        Connection conn = null;
        try{

        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url,Config.DATABASENAME,Config.DATABASEPASSWD);
        System.out.println("LoadMessageDao_MARA发来贺电：数据库连接成功！");
        state = conn.createStatement();
        LoadMessage_MARA loadMessage_mara = new LoadMessage_MARA();
        int amountMARA = loadMessage_mara.getTotal();
        String title[] = loadMessage_mara.getTitle();
        String link[] = loadMessage_mara.getLink();
        String date[] = loadMessage_mara.getDate();
        for(int i = 0; i<amountMARA; i++){
            String source = "MARA"+i;
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

            } System.out.println("LoadMessageDao_MARA发来贺电：数据加载成功！");
        }catch (ClassNotFoundException e ){
            e.printStackTrace();
        }catch (SQLException throwables) {
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
