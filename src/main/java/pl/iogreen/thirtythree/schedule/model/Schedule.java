package pl.iogreen.thirtythree.schedule.model;


import java.util.Date;

public class Schedule {

    private final String room;
    private final String name;
    private final Date start;
    private final long id;

    public Schedule(long id, String room, String name, Date start) {
        this.id = id;
        this.room = room;
        this.name = name;
        this.start = start;
    }

    public long getId() {
        return id;
    }

    public String getRoom() {
        return room;
    }

    public String getName() {
        return name;
    }

    public Date getStart() {
        return start;
    }
}
