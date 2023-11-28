package com.utsav.booklevoire.viewModel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseUser;
import com.utsav.booklevoire.AppRepo;
import com.utsav.booklevoire.AuthenticationRepository;
import com.utsav.booklevoire.User;

public class SignupViewModel extends ViewModel {
    private AppRepo appRepo;
    public void createAppRepo(Context context){
        appRepo=new AppRepo(context);
    }
    public void insert (User user){
        appRepo.insert(user);
    }

   /* private AuthenticationRepository repository;
    private MutableLiveData<FirebaseUser> userData;
    private MutableLiveData<Boolean> loggedStatus;

    public MutableLiveData<FirebaseUser> getUserData() {
        return userData;
    }

    public MutableLiveData<Boolean> getLoggedStatus() {
        return loggedStatus;
    }

   public SignupViewModel(@NonNull Context context) {

        repository = new AuthenticationRepository(context);
        userData = repository.getFirebaseUserMutableLiveData();
        loggedStatus = repository.getUserLoggedMutableLiveData();
    }

    public void register(String email , String pass){
        repository.register(email, pass);
    // TODO: Implement the ViewModel
}*/}