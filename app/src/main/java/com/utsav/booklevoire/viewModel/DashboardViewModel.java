package com.utsav.booklevoire.viewModel;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.utsav.booklevoire.Database_n_Repository.AppRepo;
import com.utsav.booklevoire.Database_n_Repository.Book;

import java.util.List;

public class DashboardViewModel extends ViewModel {
    private AppRepo appRepo;
    public void createAppRepo(Context context){
        appRepo=new AppRepo(context);
    }
    public List<Book> getallBook(){return appRepo.getallBook();}
}