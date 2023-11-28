package com.utsav.booklevoire.viewModel;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.utsav.booklevoire.AppRepo;
import com.utsav.booklevoire.User;

public class SignupViewModel extends ViewModel {
    private AppRepo appRepo;
    public void createAppRepo(Context context){
        appRepo=new AppRepo(context);
    }
    public void insert (User user){
        appRepo.insert(user);
    }

    // TODO: Implement the ViewModel
}