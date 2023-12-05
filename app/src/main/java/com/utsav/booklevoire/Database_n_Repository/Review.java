package com.utsav.booklevoire.Database_n_Repository;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Review",
        foreignKeys = {@ForeignKey(
                entity = User.class,
                parentColumns = "uid",
                childColumns = "uid",
                onDelete = ForeignKey.CASCADE),
                @ForeignKey(
                        entity = Book.class,
                        parentColumns = "bID",
                        childColumns = "bID",
                        onDelete = ForeignKey.CASCADE

                )
}

)
public class Review {
    @PrimaryKey(autoGenerate = true)
    int reviewId;
    int uid;
    int bID;
    int Rating;
    String comment;

}
