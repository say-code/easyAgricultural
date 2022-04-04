package com.eaproject.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    public String userName;
    public String passWord;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        userName = (String) req.getParameter("userName");
        passWord = (String) req.getParameter("passWord");
        System.out.println("username:"+userName);
        System.out.println("password:"+passWord);
        LoadUser loadUser = new LoadUser();
        boolean ifExist = false;
        for(int count = 0; count < loadUser.userNumber; count++){
            if (userName.compareTo(loadUser.userName[count]) == 0){
                if(passWord.compareTo(loadUser.passWord[count]) == 0)
                    ifExist = true;
                    UserData.userName = loadUser.userName[count];
                    UserData.passWord = loadUser.passWord[count];
                    UserData.nickName = loadUser.nickName[count];
                    UserData.phone = loadUser.phone[count];
                    UserData.fans = loadUser.fans[count];
                    UserData.contribute = loadUser.contribute[count];
            }
        }
        if( ifExist == true ){
            System.out.println("LoginServlet发来贺电：登录成功！");
            System.out.println("欢迎"+UserData.nickName+"进入系统");
//            HttpSession session = req.getSession();
//            session.setAttribute("userName",userName);
//            sess
            resp.sendRedirect("/home.html");

        }else{
            resp.setContentType("text/html");
            resp.setHeader("content-type","text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            out.println("<html><body><script type=\"text/javascript\">");
            out.println("alert(\"用户名或密码输入错误！\");window.location.href=\"/\"</script>");
//            out.println("<a href=\"/\">点击此处返回登录</a>");
            out.println("</body></html>");
            System.out.println("LoginServlet表示：用户名或密码输入错误！");
//            resp.sendRedirect("/");
        }
    }
}
