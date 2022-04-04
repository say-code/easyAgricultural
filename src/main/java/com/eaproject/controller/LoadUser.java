package com.eaproject.controller;

import com.eaproject.Config;

import java.sql.*;

public class LoadUser {
    public static int userNumber = 0;
//    static UserData userData[] = new UserData[Config.MAXUSER];
    public String userName[] = new String[Config.MAXUSER];
    public String passWord[] = new String[Config.MAXUSER];
    public String nickName[] = new String[Config.MAXUSER];
    public String phone[] = new String[Config.MAXUSER];
    public int fans[] = new int[Config.MAXUSER];
    public int contribute[] = new int[Config.MAXUSER];
    public LoadUser() {
        userNumber = 0;
        String url = "jdbc:mysql://127.0.0.1:"+Config.PORT+"/easyagricultural?useUnicode=true&characterEncoding=utf8&useSSL=false";
        Statement state = null;
        Connection conn = null;
        try{
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection(url,Config.DATABASENAME,Config.DATABASEPASSWD);
            System.out.println("LoadUser发来贺电：数据库连接成功！");
            //3.定义sql语句
            String sql = "select * from users;";
            //4.从连接对象中获取一个执行人
            state = conn.createStatement();
            //5.执行sql语句
            ResultSet rs  = state.executeQuery(sql);
            System.out.println("LoadUser发来贺电：数据已连接！");
            while (rs.next() != false){
                userName[userNumber] = rs.getString("userName");
                passWord[userNumber] = rs.getString("passWord");
                phone[userNumber] = rs.getString("phone");
                nickName[userNumber] = rs.getString("nickname");
                fans[userNumber] = rs.getInt("fans" );
                contribute[userNumber] = rs.getInt("contribute");
                userNumber++;
            }
            System.out.println("LoadUser发来贺电：数据加载成功！");

        }catch (ClassNotFoundException e ){
            e.printStackTrace();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //6.关闭资源
            try{
                if(state != null){
                    state.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

}
