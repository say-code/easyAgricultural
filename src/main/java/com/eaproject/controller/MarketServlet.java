package com.eaproject.controller;

import com.eaproject.dao.GetMessageDao_MARA;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "MarketServlet", value = "/MarketServlet")
public class MarketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GetMessageDao_MARA getMessageDao_mara = new GetMessageDao_MARA();
        List<String> message = getMessageDao_mara.getMaraMessage();
        List<String> link = getMessageDao_mara.getMaraLink();
        List<Date> time = getMessageDao_mara.getMaraTime();
        Integer messageNum = getMessageDao_mara.getMessageNum();
        HttpSession session = request.getSession();
        session.setAttribute("messageMARA",message);
        session.setAttribute("linkMARA",link);
        session.setAttribute("timeMARA",time);
        session.setAttribute("messageNum",messageNum);
        response.sendRedirect("/MarketAnalysis.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
