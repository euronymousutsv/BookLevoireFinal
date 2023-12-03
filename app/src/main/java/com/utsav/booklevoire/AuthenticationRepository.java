package com.utsav.booklevoire;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

//This is the repository for firebase authentication
public class AuthenticationRepository {
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private MutableLiveData<Boolean> registrationResult = new MutableLiveData<>();
    private MutableLiveData<Boolean> signInResult = new MutableLiveData<>();
    private MutableLiveData<Boolean> signOutResult = new MutableLiveData<>();

    public MutableLiveData<Boolean> getSignInResult() {
        return signInResult;
    }

    public MutableLiveData<Boolean> getSignOutResult() {
        return signOutResult;
    }

    public MutableLiveData<Boolean> getRegistrationResult() {
        return registrationResult;
    }

    public void registerUser(UserClass user) {
        firebaseAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        registrationResult.setValue(true);
                    } else {
                        registrationResult.setValue(false);
                    }
                });
    }


    public void signInUser(UserClass user) {
        firebaseAuth.signInWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        signInResult.setValue(true);
                    } else {
                        signInResult.setValue(false);
                    }
                });
    }

    public void signOutUser() {
        firebaseAuth.signOut();
        signOutResult.setValue(true);
    }
}


