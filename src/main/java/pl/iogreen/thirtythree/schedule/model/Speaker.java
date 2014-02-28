package pl.iogreen.thirtythree.schedule.model;

import android.graphics.Bitmap;

public class Speaker {

    private final String description;
    private final String name;
    private final Bitmap photo;
    private final Session[] sessions;

    public Speaker(String name, String description, Bitmap photo, Session[] sessions) {
        this.description = description;
        this.name = name;
        this.photo = photo;
        this.sessions = sessions;
    }

    public Speaker(String name) {
        this(name, "", null, new Session[]{});

    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public Session[] getSessions() {
        return sessions;
    }
}
