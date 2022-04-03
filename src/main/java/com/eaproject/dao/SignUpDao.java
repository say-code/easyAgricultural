package com.eaproject.dao;

import java.sql.*;

public class SignUpDao {
    public SignUpDao(String userName, String passWord,String nickName,String phone,int fans,int contributes){
        String url = "jdbc:mysql://127.0.0.1:3306/easyagricultural?useUnicode=true&characterEncoding=utf8&useSSL=false";
        Statement state = null;
        Connection conn = null;
        try{
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection(url,"root","2002525wyh1+1=2");
            //3.定义sql语句
            String sql = "insert into users(userName,passWord,nickname,phone,fans,contribute)values('"
                    +userName+"','"+passWord+"','"+phone+"','"+nickName+"','"+fans+"','"+contributes+"');";
            //4.从连接对象中获取一个执行人
            state = conn.createStatement();
            //5.执行sql语句
            state.executeUpdate(sql);
            System.out.println("SignUpDao发来贺电：数据录入成功！");

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
