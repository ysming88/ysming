package Servlet;

import Dao.selectDao;
import Domain.Blog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/myblogServlet")
public class MyblogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("myblogServlet-get");


        String writer = req.getParameter("email");
        System.out.println("email:" + writer);

        req.setAttribute("bgc","全部博客");
        ArrayList<Blog> myblog=new selectDao().findBlog(writer);//查找该用户的所有博客

        HttpSession session=req.getSession();
        session.setAttribute("bloglist",myblog);
        req.setAttribute("email", writer);
        req.getRequestDispatcher("/myblog.jsp").forward(req, resp);
    }
}
