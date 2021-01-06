package Servlet;

import Dao.deleteDao;
import Dao.selectDao;
import Domain.register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/deleteuserServlet")
public class DeleteuserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("get");

        String email = req.getParameter("email");
        System.out.println("email:"+email);

        new deleteDao().delRegister(email);
        new deleteDao().delInformation(email);

        ArrayList<register> alluser=new selectDao().allUser();
        HttpSession session=req.getSession();
        session.setAttribute("userlist",alluser);

        resp.setContentType("text/html;charset=gb2312");//防止弹窗无法发中文
        resp.getWriter().print("<script language='javascript'>alert('删除成功');window.location.href='/java_web_war_exploded/usermanage.jsp';</script>");
    }
}
