package Servlet;

import Dao.deleteDao;
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

@WebServlet("/deleteblogServlet")
public class DeleteblogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("deleteblogServlet-get");

        String id = req.getParameter("id");
        System.out.println("id:"+id);
        String writer = req.getParameter("writer");
        System.out.println("writer:"+writer);

        if("1".equals(writer)){
            new deleteDao().delBlog(id);

            ArrayList<Blog> allblog=new selectDao().allBlog();
            HttpSession session=req.getSession();
            session.setAttribute("bloglist",allblog);

            System.out.println("-----------------------------");
            req.getRequestDispatcher("/administrator.jsp").forward(req, resp);
        }
        else {
            new deleteDao().delBlog(id);
            ArrayList<Blog> myblog=new selectDao().findBlog(writer);//查找该用户的所有博客
            HttpSession session=req.getSession();
            session.setAttribute("bloglist",myblog);

            req.setAttribute("email",writer);
            System.out.println("-----------------------------");
            req.getRequestDispatcher("/myblog.jsp").forward(req, resp);
        }

    }
}
