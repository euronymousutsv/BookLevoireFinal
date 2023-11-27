package com.utsav.booklevoire.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.utsav.booklevoire.R;
import com.utsav.booklevoire.viewModel.DetailViewViewModel;

public class DetailView extends Fragment {

    private DetailViewViewModel mViewModel;

    public static DetailView newInstance() {
        return new DetailView();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_view, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DetailViewViewModel.class);
        // TODO: Use the ViewModel
    }

}