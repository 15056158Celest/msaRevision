package sg.edu.rp.c346.msarevision;

/**
 * Created by 15056158 on 1/7/2017.
 */

public class Event {
    private String date;
    private String title;
    private float fee;

    public  Event(String date, String title, float fee){
        this.date = date;
        this.title = title;
        this.fee = fee;


    }

    public String getDate(){
        return date;
    }

    public float getFee(){
        return fee;
    }

    public String getTitle(){
        return title;
    }
}

