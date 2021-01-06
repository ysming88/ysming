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

@WebServlet("/mycollectServlet")
public class MycollectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("get");

        String email = req.getParameter("email");
        System.out.println("email:" + email);

        ArrayList<String> idlist=new selectDao().findcollect(email);
        ArrayList<Blog> bloglist=new ArrayList<>();
        for(String i:idlist){
            System.out.println(i);
            bloglist.add(new selectDao().idfindblog(i));
        }
//        for (Blog blog:bloglist)
//        {
//            System.out.println(blog);
//        }
        HttpSession session=req.getSession();
        session.setAttribute("bloglist",bloglist);
        req.setAttribute("email", email);
        req.getRequestDispatcher("/mycollect.jsp").forward(req, resp);
    }
}
