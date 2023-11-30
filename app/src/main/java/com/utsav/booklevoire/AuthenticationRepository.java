package com.utsav.booklevoire;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
//This is the repository for firebase authentication
public class AuthenticationRepository {

    private final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private final MutableLiveData<Boolean> registrationResult = new MutableLiveData<>();

    public MutableLiveData<Boolean> getRegistrationResult() {
        return registrationResult;
    }

    public void registerUser(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        registrationResult.setValue(true);
                    } else {
                        registrationResult.setValue(false);
                    }
                });
    }



}


