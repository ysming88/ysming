package Servlet;

import Dao.insertDao;
import Dao.selectDao;
import Domain.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/addcategoryServlet")
public class AddcategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("addcategoryServlet-post");

        String category = req.getParameter("category");
        System.out.println("category:"+category);

        if(new selectDao().findcategory(category )){
            resp.setContentType("text/html;charset=gb2312");//防止弹窗无法发中文
            resp.getWriter().print("<script language='javascript'>alert('分类专栏已存在');window.location.href='/java_web_war_exploded/categorymanage.jsp';</script>");
        }
        else {
            new insertDao().addcategory(category);

            HttpSession session=req.getSession();
            ArrayList<Category> allCategory = new selectDao().category();
            session.setAttribute("allCategory",allCategory);

            req.getRequestDispatcher("/categorymanage.jsp").forward(req, resp);
        }

    }
}
