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

@WebServlet("/timesearchServlet")
public class TimesearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("timesearchServlet-post");

        String time = req.getParameter("time");
        String email = req.getParameter("emailt");
        System.out.println("time:" + time);
        System.out.println("email:" + email);

        ArrayList<Blog> searchblog=new selectDao().findTime(email,time);
        for(Blog id:searchblog)
        {
            System.out.println("id:"+id.getId());
        }
        HttpSession session=req.getSession();
        session.setAttribute("bloglist",searchblog);

        req.setAttribute("email", email);
        req.getRequestDispatcher("/myblog.jsp").forward(req, resp);
    }
}
