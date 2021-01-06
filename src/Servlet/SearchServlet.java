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

@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("searchServlet-post");

        String keyword = req.getParameter("keyword");
        String email = req.getParameter("email");
        System.out.println("keyword:" + keyword);
        System.out.println("email:" + email);

        ArrayList<Blog> searchblog=new selectDao().findKeyword(keyword);

        for(Blog id:searchblog)
        {
            System.out.println("id:"+id.getId());
        }
        HttpSession session=req.getSession();
        session.setAttribute("bloglist",searchblog);

        req.setAttribute("email", email);
        req.setAttribute("page", "1");
        req.setAttribute("p", "1");
        req.getRequestDispatcher("/homePage.jsp").forward(req, resp);
    }
}
