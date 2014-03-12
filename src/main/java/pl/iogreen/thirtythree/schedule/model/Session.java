package pl.iogreen.thirtythree.schedule.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Session implements Parcelable {

    private final String name;
    private final String description;
    private final Date start;
    private final long id;

    public Session(long id, String name, String description, Date start) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start = start;
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

    public long getId() {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel in, int flags) {
        in.writeLong(id);
        in.writeString(name);
        in.writeString(description);
        in.writeLong(start.getTime());
    }

    public static final Creator<Session> CREATOR = new Creator<Session>() {
        @Override
        public Session createFromParcel(Parcel out) {
            Speaker speaker = null;
            long id = out.readLong();
            String name = out.readString();
            String description = out.readString();
            Date start = new Date(out.readLong());
            System.out.println(name + " " + description + " " + (speaker != null ? speaker.getName() : "null") + " " + start);
            return new Session(id, name, description, start);
        }

        @Override
        public Session[] newArray(int size) {
            return new Session[size];
        }
    };
}
