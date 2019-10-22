package servlet;

import controller.LoginController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class myServlet extends HttpServlet {
    private LoginController testNot;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// TODO Auto-generated method stub
       // super.doPost(req, resp);
        testNot=new LoginController();
        try {
            testNot.handleRequest(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// TODO Auto-generated method stub
        //super.doGet(req, resp);
        doPost(req,resp);

    }

}
