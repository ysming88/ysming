package Servlet;

import Dao.insertDao;
import Dao.selectDao;
import Dao.updateDao;
import Domain.register;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class InformationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );

        System.out.println("post1");
        String name = req.getParameter("name");
        String sex =req.getParameter("sex");
        String year =req.getParameter("year");
        String month =req.getParameter("month");
        String day =req.getParameter("day");
        String birthday=(year+month+day);
        String job =req.getParameter("job");
        String phone=req.getParameter("phone");
        String email = req.getParameter("email");

//        System.out.println("name:" + name);
//        System.out.println("sex1:" + sex);
//        System.out.println("birthday:" + birthday);
//        System.out.println("job1:" + job);
//        System.out.println("phone:" + phone);
//        System.out.println("email:" + email);

        //如果该用户已经设置过个人信息
        if(new selectDao().information(email)){
            System.out.println("yes");
            new updateDao().updateInformation(email,name,sex,birthday,job,phone);
        }
        else{
            new insertDao().information(name,sex,birthday,job,phone,email);
        }
        req.setAttribute("name",name);
        req.setAttribute("sex",sex);
        req.setAttribute("year", year);
        req.setAttribute("month", month);
        req.setAttribute("day", day);
        req.setAttribute("job",job);
        req.setAttribute("phone",phone);
        req.setAttribute("email",email);

        ArrayList<register> user=new selectDao().findRegister(email);
        for(register id:user)
        {
            System.out.println(id.getEmail()+id.getUsername()+id.getPassworld()+id.getHead());
            req.setAttribute("email", email);
            req.setAttribute("username", id.getUsername());
            req.setAttribute("password", id.getPassworld());
            req.setAttribute("head", id.getHead());
        }

        req.setAttribute("return1", "修改成功！");
        req.getRequestDispatcher("/perCenter.jsp").forward(req, resp);

    }

}
