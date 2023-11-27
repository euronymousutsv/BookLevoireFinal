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
import com.utsav.booklevoire.databinding.FragmentSignupBinding;
import com.utsav.booklevoire.viewModel.SignupViewModel;

public class Signup extends Fragment {
FragmentSignupBinding binding;
    private SignupViewModel mViewModel;

    public static Signup newInstance() {
        return new Signup();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_signup, container, false);
        binding=FragmentSignupBinding.inflate(inflater,container,false);
        View view=binding.getRoot();
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SignupViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
}