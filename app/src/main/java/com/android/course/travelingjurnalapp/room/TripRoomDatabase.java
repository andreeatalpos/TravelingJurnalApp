package com.android.course.travelingjurnalapp.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.android.course.travelingjurnalapp.model.Trip;

@Database(entities = {Trip.class}, version = 1)
public abstract class TripRoomDatabase extends RoomDatabase {

    public abstract TripDao tripDao();

    private static volatile TripRoomDatabase INSTANCE;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(4);

    static TripRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TripRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TripRoomDatabase.class, "trips_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
