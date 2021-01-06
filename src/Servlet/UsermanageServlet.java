package Servlet;

import Dao.selectDao;
import Domain.Blog;
import Domain.register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/usermanageServlet")
public class UsermanageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("get");

        ArrayList<register> alluser=new selectDao().allUser();
        HttpSession session=req.getSession();
        session.setAttribute("userlist",alluser);

        req.getRequestDispatcher("/usermanage.jsp").forward(req, resp);
    }
}
