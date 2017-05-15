package Main;

import EntityDB.Reserve;
import EntityDB.User;
import HibernateDescription.HibernateOperations.ReserveOperations;
import HibernateDescription.HibernateOperations.UserOperations;
import HibernateDescription.HibernateUtils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Vector;


/**
 * Created by Андрей on 07.05.2017.
 */
@WebServlet("/hotel")
public class MainServer extends HttpServlet {

    private static final Logger log = Logger.getLogger(MainServer.class);
    private User currentUser = null;

    public enum requestState {
        ENTER,
        REGISTRATION,
        REGISTRATE,
        STARTSIGNIN,
        SIGNIN,
        RESULTOFRESERVE,
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
        HttpSession httpSession=request.getSession(true);
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
                currentUser = new User(request.getParameter("login"),
                        request.getParameter("password"),
                        request.getParameter("email"));
                if (UserOperations.checkNewUser(session, currentUser)) {
                    UserOperations.addUser(session, currentUser);
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
                if (request.getParameter("password") != null)
                    currentUser = new User(request.getParameter("login"), request.getParameter("password"));
                if (UserOperations.checkUser(session, currentUser))
                    if (UserOperations.checkAdmin(currentUser)) {
                        Vector<Reserve> reserves = ReserveOperations.getAllReserves(session);
                        for (int i = 1; i <= reserves.size(); i++)
                            reserves.get(i - 1).setRoomID(i);
                        request.setAttribute("reserves", reserves);
                        request.getRequestDispatcher("/admin.jsp").forward(request, response);
                    } else
                        request.getRequestDispatcher("/reserve.jsp").forward(request, response);
                else
                    request.getRequestDispatcher("/signin.jsp").forward(request, response);
                break;
            }
            case RESULTOFRESERVE: {
                System.out.println(request.getParameter("from"));
                Reserve reserve = new Reserve((Integer.parseInt(request.getParameter("size"))),
                        currentUser.getLogin(), request.getParameter("from"),
                        request.getParameter("to"));
                if (ReserveOperations.reserveValidation(reserve, session)) {
                    ReserveOperations.addReserve(session, reserve);
                  /*  SendEmail.sendEmail(currentUser.getEmail(), "You've just booked a " + reserve.getRoomSize() +
                            " place room in our Hotel. Booking period: From " + reserve.getStartDate() +
                            " to " + reserve.getFinishDate() + ". We are looking forward to meet with you");*/
                    request.getRequestDispatcher("/resultOfReserve.jsp").forward(request, response);
                } else
                    request.getRequestDispatcher("/reserve.jsp").forward(request, response);
                break;
            }
            case DEFAULT:
                httpSession.invalidate();
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
        else if (request.getParameter("signinButton") != null || request.getParameter("continueButton") != null)
            return requestState.SIGNIN;
        if (request.getParameter("reserveButton") != null)
            return requestState.RESULTOFRESERVE;
        else if (request.getParameter("ExitButton") != null)
            return requestState.DEFAULT;

        return requestState.DEFAULT;
    }


}
