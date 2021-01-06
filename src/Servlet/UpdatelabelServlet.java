package Servlet;

import Dao.selectDao;
import Dao.updateDao;
import Domain.Label;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/updatelabelServlet")
public class UpdatelabelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("updatelabelServlet-post");

        HttpSession session=req.getSession();
        String email=(String) session.getAttribute("email");
        String label = req.getParameter("label");
        String id = req.getParameter("id");
        System.out.println("label:" + label);
        System.out.println("id:" + id);
        System.out.println("eamil:" + email);

        new updateDao().updatelabel(id,label);

        ArrayList<Label> allLabel = new selectDao().label(email);
        session.setAttribute("allLabel",allLabel);
        req.getRequestDispatcher("/mylabel.jsp").forward(req, resp);
    }
}
