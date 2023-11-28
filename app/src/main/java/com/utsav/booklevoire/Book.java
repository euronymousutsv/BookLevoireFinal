package com.utsav.booklevoire;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Book {
    @PrimaryKey
    public int bID;
    @ColumnInfo(name="bookName")
    public String bookName;
    @ColumnInfo(name="bookAuthor")
    public String bookAuthor;
    @ColumnInfo(name="AverageRating")
    public  String AverageRating;
    @ColumnInfo(name="ImageURL")
    public  String ImageURL;

}
