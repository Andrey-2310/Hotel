package EntityDB;

/**
 * Created by Андрей on 11.05.2017.
 */
public class Record {
    private Integer roomID;
    private Integer userID;
    private Integer startDate;
    private Integer finishDate;

    public Record() {
        super();
    }

    public Record(Integer roomID, Integer userID, Integer startDate, Integer finishDate) {
        this.roomID = roomID;
        this.userID = userID;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public Integer getRoomID() {
        return roomID;
    }

    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
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
