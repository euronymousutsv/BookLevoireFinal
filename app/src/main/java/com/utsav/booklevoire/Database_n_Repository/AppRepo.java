package com.utsav.booklevoire.Database_n_Repository;

import android.content.Context;

import androidx.room.Room;

import java.util.List;
//Repository to connect to database
public class AppRepo {
    private AppDatabase db;
    private DAO mainDao;
    public AppRepo(Context context){
        db= Room.databaseBuilder(context,
                AppDatabase.class, "database1").allowMainThreadQueries().build();
        mainDao = db.getDAO();

    }
    //Methods for inserting user into database
public void insert(User user){
        mainDao.insertUser(user);

}
//Methods for listing all the book in DB

 public List<Book> getallBook(){
        return mainDao.getallBook();
    }
    //Method for finding user by email
public User findbyEmail(String email,String password){
    return mainDao.findByemail(email, password);
}}
