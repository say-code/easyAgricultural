package com.eaproject.controller;

import com.eaproject.dao.SignUpDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignUpServlet", value = "/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = (String) request.getParameter("userName");
        String passWord = (String) request.getParameter("passWord");
        String phone = (String) request.getParameter("phone");
        String nickname = (String) request.getParameter("nickname");
        int fans = 0;
        int contribute = 0;
        if (userName.length()>15 || passWord.length()>15 || nickname.length()>12 || phone.length() != 11){
            response.setContentType("text/html");
            response.setHeader("content-type","text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<html><body><script type=\"text/javascript\">");
            out.println("alert(\"输入有误，请重新输入！\");window.location.href=\"/\"</script>");
//            out.println("<a href=\"/\">点击此处返回登录</a>");
            out.println("</body></html>");
            System.out.println("SignUpServlet表示：输入有误，请重新输入！");
//            resp.sendRedirect("/");
        }else{
            System.out.println(userName);
            SignUpDao signUpDao = new SignUpDao(userName,passWord,phone,nickname,0,0);

            System.out.println("SingUpServlet发来贺电：注册成功");
            response.sendRedirect("/home.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
