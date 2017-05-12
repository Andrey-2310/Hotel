package Main;

import HibernateUtil.UserHibernateUtil;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Андрей on 07.05.2017.
 */
@WebServlet("/hotel")
public class MainServer extends HttpServlet {


    public MainServer() {
    }

    static int i = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        if (checkParameter(request)) {
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("/enter.jsp").forward(request, response);
          //  request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        Session session = UserHibernateUtil.getSessionFactory().openSession();
        // request.setAttribute("admin", UserHibernateUtil.getUsers(session).get(0).toString()); //UserHibernateUtil.getUsers(session);
        System.out.println("Request " + i++);

    }

    private boolean checkParameter(HttpServletRequest request) {
        return request.getParameter("regButton") != null;
    }


}
