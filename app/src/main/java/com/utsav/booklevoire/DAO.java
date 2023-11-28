package com.utsav.booklevoire;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUser(User... users);
    @Query("SELECT*From User WHERE uid= :id")
    User findByID(int id);

 @Query("SELECT*From User WHERE Email=:userEmail AND Password=:userPass")
    User findbyEmail(String userEmail,String userPass);
 @Query("SELECT*FROM Book")
    List<Book> getAll();


}
