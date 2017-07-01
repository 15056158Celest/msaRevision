package sg.edu.rp.c346.msarevision;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by 15056158 on 1/7/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static int DB_VER = 1;
    private static final String DB_NAME = "event.db";
    private static final String DB_TABLE = "Event";
    private static final String COL_ID = "id";
    private static final String COL_DATE = "date";
    private static final String COL_TITLE = "title";
    private static final String COL_FEE = "fee";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " +  DB_TABLE + " " +
                "(" + COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_DATE + " TEXT, " +
                COL_TITLE + "TEXT, " +
                COL_FEE + "FLOAT)";

        Log.d("SQL DML - create", sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE " + DB_TABLE;
        Log.d("SQL DML - upgrade", sql);
    }

    //Adding
    public long insertEvent(String date, String title, String fee) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_DATE,date);
        values.put(COL_TITLE,title);
        values.put(COL_FEE,fee);
        long result = db.insert(DB_TABLE, null, values);
        db.close();
        Log.d("SQL Insert",""+ result); //id returned, shouldn’t be -1
        return result;
    }

    public ArrayList<Event> getAllEvent() {
        ArrayList<Event> events = new ArrayList<Event>();

        String selectQuery = "SELECT " + COL_ID + ","
                + COL_DATE + ", "
                + COL_TITLE + ", "
                + COL_FEE + " FROM " + DB_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String date = cursor.getString(1);
                String title = cursor.getString(2);
                float fee = cursor.getFloat(3);
                //songs.add("ID:" + id + ", " + content);
                Event event = new Event(date, title, fee);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return events;
    }

    public ArrayList<String> getAllEventContentSQL () {
        ArrayList<String> al = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT ID, date, title, fee from " + DB_TABLE;

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String date = cursor.getString(1);
                String title = cursor.getString(2);
                float fee = cursor.getFloat(3);
                String data = id + ", " + date + ", " + title + ", " + fee;
                al.add(data);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return al;

    }

}
