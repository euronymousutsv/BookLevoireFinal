package com.utsav.booklevoire.viewModel;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.utsav.booklevoire.AppRepo;
import com.utsav.booklevoire.Book;
import com.utsav.booklevoire.User;

import java.util.List;

public class DashboardViewModel extends ViewModel {
    private AppRepo appRepo;
    public void createAppRepo(Context context){
        appRepo=new AppRepo(context);
    }
    public List<Book> getallBook(){return appRepo.getallBook();}
}