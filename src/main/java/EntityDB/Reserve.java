package EntityDB;

/**
 * Created by Андрей on 11.05.2017.
 */
public class Reserve {

    private Integer roomID;
    private Integer roomSize;
    private String password;
    private String startDate;
    private String finishDate;

    public Reserve() {
        super();
    }

    public Reserve(Integer roomSize, String password, String startDate, String finishDate) {
        this.roomSize = roomSize;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }
}
