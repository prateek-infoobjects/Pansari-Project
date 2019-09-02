package com.pansari.promoter.SalesItemsAccessDataModule;

import android.content.Context;

import com.pansari.promoter.salesmodule.SalesItems;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {SalesItems.class}, version = 2,exportSchema = false)
public abstract class DatabaseHolder extends RoomDatabase {
    private static DatabaseHolder INSTANCE;

    public abstract SalesItemsDao userDao();

    public static DatabaseHolder getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), DatabaseHolder.class, "user-database")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
