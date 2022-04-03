package com.eaproject.controller;

import com.eaproject.dao.GetMessageDao_MARA;
import com.eaproject.dao.GetMessageDao_NZDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

        GetMessageDao_NZDB getMessageDao_nzdb = new GetMessageDao_NZDB();
        message = getMessageDao_nzdb.getNZDBMessage();
        link = getMessageDao_nzdb.getNZDBLink();
        time = getMessageDao_nzdb.getNZDBTime();
        messageNum = getMessageDao_mara.getMessageNum();
        session = request.getSession();
        session.setAttribute("messageNZDB",message);
        session.setAttribute("linkNZDB",link);
        session.setAttribute("timeNZDB",time);
        session.setAttribute("messageNum",messageNum);

        response.sendRedirect("/MarketAnalysis.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
