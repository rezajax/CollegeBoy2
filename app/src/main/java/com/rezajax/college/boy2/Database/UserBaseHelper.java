package com.rezajax.college.boy2.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.rezajax.college.boy2.Database.UserDbSchema.UserTable;

public class UserBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "user.db";

    public UserBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + UserTable.NAME + "(" +
                "_id integer primary key autoincrement, " +
                UserTable.Cols.APPID + ", " +
                UserTable.Cols.STUID + ", " +
                UserTable.Cols.PASS + ", " +
                UserTable.Cols.NAME + ", " +
                UserTable.Cols.FAMILY + ", " +
                //UserTable.Cols.COURCE + ", " +
                UserTable.Cols.EMAIL + ", " +
                UserTable.Cols.PHONE + ", " +
                UserTable.Cols.DATE + ", " +
                UserTable.Cols.CAT_NAME + ", " +
                UserTable.Cols.NUM_POST + ", " +
                UserTable.Cols.IS_STU +
                ")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
