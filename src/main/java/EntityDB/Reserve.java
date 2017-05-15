package EntityDB;

/**
 * Created by Андрей on 11.05.2017.
 */
public class Reserve {

    private Integer roomID;
    private Integer roomSize;
    private String userLogin;
    private String startDate;
    private String finishDate;

    public Reserve() {
        super();
    }


    public Reserve(Integer roomSize, String userLogin, String startDate, String finishDate) {
        this.roomSize = roomSize;
        this.userLogin = userLogin;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public Integer getRoomID() {
        return roomID;
    }

    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }


    public Integer getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Integer roomSize) {
        this.roomSize = roomSize;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {this.finishDate = finishDate;}


    public String getUserLogin() {return userLogin;}

    public void setUserLogin(String userLogin) {this.userLogin = userLogin;}


    @Override
    public String toString() {
        return "Reserve{" +
                "roomSize=" + roomSize +
                ", password='" + userLogin + '\'' +
                ", startDate='" + startDate + '\'' +
                ", finishDate='" + finishDate + '\'' +
                '}';
    }


}
