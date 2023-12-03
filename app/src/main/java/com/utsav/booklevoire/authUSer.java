package com.utsav.booklevoire;

import com.google.firebase.firestore.Exclude;

import java.io.Serializable;

public class authUSer implements Serializable {
    public String uid;
    public String name;
    @SuppressWarnings("WeakerAccess")
    public String email;
    @Exclude
    public boolean iAuthenticated;
    @Exclude
    boolean isNew,isCreated;
    public authUSer(){}

        authUSer(String uid,String name,String email){
            this.uid=uid;
            this.name=name;
            this.email=email;
        }

    }


