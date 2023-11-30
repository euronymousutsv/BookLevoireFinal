package com.utsav.booklevoire.Database_n_Repository;

import androidx.room.Database;
import androidx.room.RoomDatabase;

//Creattion of Database
@Database(entities = {User.class , Book.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DAO getDAO();

}
