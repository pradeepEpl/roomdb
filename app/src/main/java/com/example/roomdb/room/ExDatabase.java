package com.example.roomdb.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Purchase.class}, version = 1)
public abstract class ExDatabase extends RoomDatabase {

    public abstract PurchaseDao getPurchaseDao();
    public static ExDatabase database;

    public static ExDatabase getInstance(Context context) {
        if (database == null) {
            database = createDB(context);
        }
        return database;
    }

    private static ExDatabase createDB(Context context) {
        return Room.databaseBuilder(context, ExDatabase.class, "petrol_db").
                allowMainThreadQueries().build();
    }

    public void cleanUp() {
        database = null;
    }
}
