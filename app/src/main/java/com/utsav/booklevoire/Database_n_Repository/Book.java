package com.utsav.booklevoire.Database_n_Repository;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//creating book entity
@Entity
public class Book {
    @PrimaryKey(autoGenerate = true)
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
