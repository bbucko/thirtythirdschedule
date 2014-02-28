package pl.iogreen.thirtythree.schedule.model;


import java.util.Date;

public class Session {

    private final Speaker speaker;

    private final String name;
    private final String description;
    private final Date start;
    private final Date end;

    public Session(Speaker speaker, String name, String description, Date start, Date end) {
        this.speaker = speaker;
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
}
