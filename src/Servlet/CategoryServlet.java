package Servlet;

import Dao.selectDao;
import Domain.Blog;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/categoryServlet")
public class CategoryServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("categoryServlet-post");

        String category = req.getParameter("category");
        System.out.println("category:" + category);
        String email = req.getParameter("email");
        System.out.println("email:" + email);


        if("原创".equals(category)||"转发".equals(category))//查找该用户转发和原创的博客
        {
            String original=category;
            ArrayList<Blog> bloglist=new selectDao().findMyoriginal(email,original);//这里的category查找的是original字段
            HttpSession session=req.getSession();
            session.setAttribute("bloglist",bloglist);
        }
        else if("全部博客".equals(category)){
            ArrayList<Blog> myblog=new selectDao().findBlog(email);//查找该用户的所有博客
            HttpSession session=req.getSession();
            session.setAttribute("bloglist",myblog);
        }
        else {
            ArrayList<Blog> bloglist=new selectDao().findMycategory(email,category);//查找该用户所有该分类的博客
            HttpSession session=req.getSession();
            session.setAttribute("bloglist",bloglist);
        }
        req.setAttribute("bgc",category);
        req.setAttribute("email", email);
        req.getRequestDispatcher("/myblog.jsp").forward(req, resp);
    }
}
