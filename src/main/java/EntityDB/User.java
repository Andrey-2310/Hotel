package EntityDB;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Андрей on 08.05.2017.
 */
public class User implements Serializable {

    public User() {
    }

    public User(String login, String password){
        setLogin(login);
        setPassword(encription(password));
    }
    public User(String login, String password, String email) {
        setLogin(login);
        setPassword(encription(password));
        setEmail(email);
    }

    private static final long serialVersionUID = 1L;
    private Integer userID;
    private String login;
    private String password;
    private String email;


    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "User{" +
                " login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email +
                '}';
    }

    public static String encription(String st) {
        return  DigestUtils.md5Hex(st);
    }

    public static boolean validateUser(User user) {
        if (user.getEmail().length() == 0 || user.getPassword().length() == 0 || user.getLogin().length() == 0)
            return false;
        if (user.getEmail() == null || user.getPassword() == null || user.getLogin() == null)
            return false;


        Pattern pattern;
        Matcher matcher;
        String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                        "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(user.getEmail());

        return matcher.matches();
    }
}
