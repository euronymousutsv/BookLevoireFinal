package com.utsav.booklevoire;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUser(User... users);
    @Query("SELECT*From User WHERE uid= :id")
    User findByID(int id);
    @Query("SELECT*From Book")
    List<Book> getallBook();
@Query("SELECT*FROM USER WHERE EMAIL=:email AND Password =:password Limit 1")
User findByemail(String email, String password);


}
