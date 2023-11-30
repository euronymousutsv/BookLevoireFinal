package com.utsav.booklevoire.viewModel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.utsav.booklevoire.AuthenticationRepository;
import com.utsav.booklevoire.Database_n_Repository.AppRepo;
import com.utsav.booklevoire.Database_n_Repository.Book;
import com.utsav.booklevoire.Database_n_Repository.User;

public class MainViewModel extends ViewModel {

private AppRepo appRepo;
public void createAppRepo(Context context){
    appRepo=new AppRepo(context);
}
public User findbyEmail(String email, String password){
    return appRepo.findbyEmail(email,password);
}
private MutableLiveData<String>userEmail;
public MutableLiveData<String>getUserEmail(){
    if(userEmail==null){
        userEmail=new MutableLiveData<String>();
    }
    return userEmail;
}


    // TODO: Implement the ViewModel
// Firebase Service implementation
   /* MutableLiveData<FirebaseUser> mutableLiveData;
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

    }*/

//Fire base implementation


}