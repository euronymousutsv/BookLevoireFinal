package com.utsav.booklevoire;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    public int uid;
    @ColumnInfo(name="Name")
    public String Name;
    @ColumnInfo(name="Email")
    public String Email;
    @ColumnInfo(name="Password")
    public  String Password;


}
