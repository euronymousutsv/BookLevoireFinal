package com.utsav.booklevoire.viewModel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.utsav.booklevoire.AppRepo;
import com.utsav.booklevoire.User;

public class MainViewModel extends ViewModel {

private AppRepo appRepo;
public void createAppRepo(Context context){
    appRepo=new AppRepo(context);
}
public void insert (User user){
    appRepo.insert(user);
}



    // TODO: Implement the ViewModel
// Firebase Service implementation
    MutableLiveData<FirebaseUser> mutableLiveData;
    public MainViewModel(){mutableLiveData=new MutableLiveData<>();}
    public void updateFirebaseUser(){
        mutableLiveData.setValue((FirebaseAuth.getInstance().getCurrentUser()));
    }
    public void signOut(){
        FirebaseAuth.getInstance().signOut();
    }

    public void setMutableLiveData(FirebaseUser user){
        mutableLiveData.setValue(user);
    }
    public MutableLiveData<FirebaseUser>getMutableLiveData(){
        return mutableLiveData;

    }



}