package com.eaproject.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "personalServlet", value = "/personalServlet")
public class personServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("userName",UserData.userName);
        session.setAttribute("passWord",UserData.passWord);
        session.setAttribute("phone",UserData.phone);
        session.setAttribute("nickName",UserData.nickName);
        session.setAttribute("contribute",UserData.contribute);
        session.setAttribute("fans",UserData.fans);
        response.sendRedirect("/personalCenter.jsp");
    }
}
