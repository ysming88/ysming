package Servlet;

import Dao.selectDao;
import Dao.updateDao;
import Domain.Information;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/updateregisterServlet")
public class UpdateregisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("updateregisterServlet-post");

        String username = req.getParameter("username");
        String email =req.getParameter("email");
        String password =req.getParameter("password");
        String head =req.getParameter("head");
        System.out.println("username:" + username);
        System.out.println("email:" + email);
        System.out.println("password:" +password);
        System.out.println("head:" +head);

        String flag =req.getParameter("flag");
        System.out.println("flag:" +flag);

        if("1".equals(flag)){
            new updateDao().updateRegister(email,username,password);
            req.setAttribute("succeed", "修改成功！");

            req.setAttribute("email",email);
            req.setAttribute("username",username);
            req.setAttribute("password", password);

            req.getRequestDispatcher("/updateuser.jsp").forward(req, resp);
        }

        else {
            if(new updateDao().updateRegister(email,username,password)){
                System.out.println("修改成功");
            }
            else {
                System.out.println("修改失败");
            }
            req.setAttribute("email",email);
            req.setAttribute("username",username);
            req.setAttribute("password", password);
            System.out.println("head2:" +head);
            req.setAttribute("head", head);

            ArrayList<Information> information=new selectDao().findInformation(email);
            for (Information id:information)
            {
                System.out.println(id.getName()+id.getSex()+id.getBirthday()+id.getJob()+id.getPhone()+id.getEmail());
                req.setAttribute("name", id.getName());
                req.setAttribute("sex", id.getSex());

                req.setAttribute("birthday", id.getBirthday());
                String year=id.getBirthday().substring(0,4);
                String month=id.getBirthday().substring(4,6);
                String day=id.getBirthday().substring(6,8);
                req.setAttribute("year", year);
                req.setAttribute("month", month);
                req.setAttribute("day", day);

                req.setAttribute("job", id.getJob());
                req.setAttribute("phone", id.getPhone());
            }
            req.setAttribute("succeed", "修改成功！");
            req.getRequestDispatcher("/perCenter.jsp").forward(req, resp);
        }

    }
}
