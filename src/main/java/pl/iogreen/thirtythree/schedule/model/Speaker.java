package pl.iogreen.thirtythree.schedule.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import org.jetbrains.annotations.Nullable;

public class Speaker implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel in, int flags) {
        in.writeString(description);
        in.writeString(name);
        in.writeArray(sessions);
        in.writeParcelable(photo, flags);
    }

    public static final Creator<Speaker> CREATOR = new Creator<Speaker>() {

        @Nullable
        @Override
        public Speaker createFromParcel(Parcel out) {
            final String name = out.readString();
            final String description = out.readString();
            final Session[] sessions = (Session[]) out.readArray(Session.class.getClassLoader());
            final Bitmap photo = out.readParcelable(Bitmap.class.getClassLoader());
            System.out.println(name + " " + description + " " + (photo != null ? photo.getHeight() : 0) + " " + (sessions != null ? sessions.length : 0));
            return new Speaker(name, description, photo, sessions);
        }

        @Override
        public Speaker[] newArray(int size) {
            return new Speaker[size];
        }
    };
}
