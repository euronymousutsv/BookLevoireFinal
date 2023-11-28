package com.utsav.booklevoire;

import android.app.Application;
import android.content.Context;

import androidx.room.Dao;
import androidx.room.Room;

public class AppRepo {
    private AppDatabase db;
    private DAO mainDao;
    public AppRepo(Context context){
        db= Room.databaseBuilder(context,
                AppDatabase.class, "database1").allowMainThreadQueries().build();
        mainDao = db.getDAO();

    }
public void insert(User user){
        mainDao.insertUser(user);

}
}
