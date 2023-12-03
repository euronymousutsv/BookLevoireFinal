package com.utsav.booklevoire.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.utsav.booklevoire.R;
import com.utsav.booklevoire.Database_n_Repository.User;
import com.utsav.booklevoire.UserClass;
import com.utsav.booklevoire.databinding.FragmentSignupBinding;
import com.utsav.booklevoire.viewModel.SignupViewModel;

import java.util.Random;

public class Signup extends Fragment {
private FragmentSignupBinding binding;
    private SignupViewModel mViewModel;

    public static Signup newInstance() {
        return new Signup();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel=new ViewModelProvider(this).get(SignupViewModel.class);
        mViewModel.createAppRepo(getContext());




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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //Signup Function

                String email=binding.signupEmail.getText().toString();
               String Name= binding.signupName.getText().toString();
               String password=binding.signupPassword.getText().toString();
                UserClass user=new UserClass(email,password);
                mViewModel.registerUser(user);
               mViewModel.getRegistrationResult().observe(getViewLifecycleOwner(), isSuccess -> {
                    if (isSuccess) {
                        // Registration successful, handle navigation or UI updates
                        Toast.makeText(requireContext(), "Registration successful", Toast.LENGTH_SHORT).show();
                    } else {
                        // Registration failed, show an error message
                        Toast.makeText(requireContext(), "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                });

            }

               //Firebase



        });
        binding.signInTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_signup_to_mainFragment);
            }
        });


    }
/*
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SignupViewModel.class);
        // TODO: Use the ViewModel
    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
}