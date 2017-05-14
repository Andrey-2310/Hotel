package Main;

import EntityDB.User;
import HibernateUtil.HibernateUtil;
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

    public enum requestState {
        ENTER,
        REGISTRATION,
        REGISTRATE,
        STARTSIGNIN,
        SIGNIN,
        DEFAULT

    }

    public MainServer() {
    }


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
        Session session = HibernateUtil.getSessionFactory().openSession();
        switch (checkParameter(request)) {
            case REGISTRATION: {
                request.getRequestDispatcher("/register.jsp").forward(request, response);
                break;
            }
            case ENTER: {
                request.getRequestDispatcher("/enter.jsp").forward(request, response);
                break;
                //  request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            case REGISTRATE: {
                User user = new User(request.getParameter("login"),
                        request.getParameter("password"),
                        request.getParameter("email"));
                if (HibernateUtil.checkNewUser(session, user)) {
                    HibernateUtil.addUser(session, user);
                    request.getRequestDispatcher("/reserve.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/register.jsp").forward(request, response);
                }
                break;
            }
            case STARTSIGNIN: {
                request.getRequestDispatcher("/signin.jsp").forward(request, response);
                break;
            }
            case SIGNIN: {
                User user = new User(request.getParameter("login"), request.getParameter("password"));
                if (HibernateUtil.checkUser(session, user))
                    request.getRequestDispatcher("/reserve.jsp").forward(request, response);
                else
                    request.getRequestDispatcher("/signin.jsp").forward(request, response);
                break;
            }
            case DEFAULT:
                request.getRequestDispatcher("/enter.jsp").forward(request, response);
                break;
        }
        // request.setAttribute("admin", HibernateUtil.getUsers(session).get(0).toString()); //HibernateUtil.getUsers(session);

    }

    private requestState checkParameter(HttpServletRequest request) {
        if (request.getParameter("regButton") != null)
            return requestState.REGISTRATION;
        else if (request.getParameter("cancelEnterButton") != null)
            return requestState.ENTER;
        else if (request.getParameter("registrateButton") != null)
            return requestState.REGISTRATE;
        else if (request.getParameter("entButton") != null)
            return requestState.STARTSIGNIN;
        else if (request.getParameter("signinButton") != null)
            return requestState.SIGNIN;
        return requestState.DEFAULT;
    }


}
