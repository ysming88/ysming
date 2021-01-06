package Servlet;

import Dao.insertDao;
import Dao.selectDao;
import Domain.Label;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/addlabelServlet")
public class AddlabelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("addlabelServlet-post");

        HttpSession session=req.getSession();
        String email=(String) session.getAttribute("email");
        String label = req.getParameter("label");
        System.out.println("label:"+label);
        System.out.println("email:"+email);

        if(new selectDao().findlabel(label,email)){
            resp.setContentType("text/html;charset=gb2312");//防止弹窗无法发中文
            resp.getWriter().print("<script language='javascript'>alert('标签已存在');window.location.href='/java_web_war_exploded/mylabel.jsp';</script>");
        }
        else {
            new insertDao().addlabel(label,email);

            ArrayList<Label> allLabel = new selectDao().label(email);
            session.setAttribute("allLabel",allLabel);
            req.getRequestDispatcher("/mylabel.jsp").forward(req, resp);
        }
    }

}
