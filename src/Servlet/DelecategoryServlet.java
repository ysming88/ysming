package Servlet;

import Dao.deleteDao;
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

@WebServlet("/delecategoryServlet")
public class DelecategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("delecategoryServlet-post");

        String category = req.getParameter("decategory");
        System.out.println("category:" + category);

        new deleteDao().delecategory(category);

        HttpSession session=req.getSession();
        ArrayList<Category> allCategory = new selectDao().category();
        session.setAttribute("allCategory",allCategory);

        req.getRequestDispatcher("/categorymanage.jsp").forward(req, resp);
    }

}
