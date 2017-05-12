package EntityDB;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.Serializable;

/**
 * Created by Андрей on 08.05.2017.
 */
public class User implements Serializable {

    public User() {}

    public User( String login, String password, String email) {
        setLogin(login);
        setPassword(password);
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
        this.password = encription(password);
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
                "userID=" + userID +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email +
                '}';
    }

    public String encription(String st) {
        String md5Hex = DigestUtils.md5Hex(st);

        return md5Hex;
    }
}
