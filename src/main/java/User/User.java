package User;

import java.io.Serializable;

/**
 * Created by Андрей on 08.05.2017.
 */
public class User implements Serializable {

    public User() {}

    public User(Integer userID, String login, String password, String email, Integer numberOfRoom, Integer startDate, Integer finishDate) {
        this.userID = userID;
        this.login = login;
        this.password = password;
        this.email = email;
        this.numberOfRoom = numberOfRoom;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    private static final long serialVersionUID = 1L;
    private Integer userID;
    private String login;
    private String password;
    private String email;
    private Integer numberOfRoom;
    private Integer startDate;
    private Integer finishDate;



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

    public Integer getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(Integer numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public Integer getStartDate() {
        return startDate;
    }

    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }

    public Integer getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Integer finishDate) {
        this.finishDate = finishDate;
    }
}
