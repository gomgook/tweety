package com.stewhouse.tweety;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Gomguk on 16. 7. 13..
 */
public class TSQLiteOpenHelper extends SQLiteOpenHelper {

    private static TSQLiteOpenHelper mInstance = null;

    // If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "NDB.db";

    private static final String QUERY_CREATE_TABLE = "create table users ( id integer primary key autoincrement, twitter_userID integer not null, register_date timestamp not null )";

    public static TSQLiteOpenHelper getInstance(Context context) {
        if (mInstance == null) {
            return new TSQLiteOpenHelper(context);
        }

        return mInstance;
    }

    private TSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QUERY_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // This database is only a cache for online data, so its upgrade policy is to simply to discard the data and start over.
        db.execSQL(QUERY_CREATE_TABLE);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    // Queries.
    public void insertUserID(SQLiteDatabase db, String userID) {
        String query = "insert into users ( twitter_userID, register_date ) values ( '" + userID + "', current_timestamp )";

        if (isInsertedUserID(db, userID)) {
            return;
        }

        db.execSQL(query);
    }

    public boolean isInsertedUserID(SQLiteDatabase db, String userID) {
        String query = "select count(*) from users where twitter_userID = " + userID;
        int count = -1;
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {
            count = Integer.parseInt(cursor.getString(0));
        }
        cursor.close();

        if (count == 1) {
            return true;
        }
        return false;
    }
}