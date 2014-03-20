package pl.iogreen.thirtythree.schedule.cp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import pl.iogreen.thirtythree.schedule.db.ScheduleDBHelper;

public class ThirtyThreeProvider extends ContentProvider {

    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    private static final int SCHEDULES = 1;
    private static final String THIRTY_THREE_ROOT = "thirtythree";

    static {
        sURIMatcher.addURI(THIRTY_THREE_ROOT, "schedule", SCHEDULES);
    }

    private ScheduleDBHelper dbHelper;

    @Override
    public boolean onCreate() {
        dbHelper = new ScheduleDBHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        final SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(ScheduleDBHelper.DATABASE_NAME);

        switch (sURIMatcher.match(uri)) {
            case SCHEDULES:

            default:

        }

        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return 0;
    }
}
