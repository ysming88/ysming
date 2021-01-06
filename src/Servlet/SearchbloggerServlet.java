package Servlet;

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

@WebServlet("/searchbloggerServlet")
public class SearchbloggerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("searchbloggerServlet-post");

        String keyword = req.getParameter("keyword");
        String email = req.getParameter("email");
        System.out.println("keyword:" + keyword);
        System.out.println("email:" + email);

        ArrayList<register> searchblogger=new selectDao().findBlogger(keyword);
        HttpSession session=req.getSession();
        session.setAttribute("bloggerlist",searchblogger);

        ArrayList<register> bloggerbloglist=new ArrayList<>();
        session.setAttribute("bloggerbloglist",bloggerbloglist);

        for (register blogger:searchblogger){
            System.out.println("username:"+blogger.getUsername());
        }

        req.getRequestDispatcher("/searchblogger.jsp").forward(req, resp);
    }
}
