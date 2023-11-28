package com.utsav.booklevoire;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class , Book.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DAO getDAO();

}
