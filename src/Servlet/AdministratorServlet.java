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

@WebServlet("/administratorServlet")
public class AdministratorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("administratorServlet-get");

        //查找所有博客信息给管理员
        ArrayList<Blog> allblog=new selectDao().allBlog();
        HttpSession session=req.getSession();
        session.setAttribute("bloglist",allblog);

        req.getRequestDispatcher("/administrator.jsp").forward(req, resp);
    }
}
