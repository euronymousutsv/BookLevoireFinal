package com.utsav.booklevoire.Database_n_Repository;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//creating user entities
@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name="Name")
    public String Name;
    @ColumnInfo(name="Email")
    public String Email;
    @ColumnInfo(name="Password")
    public  String Password;


}
