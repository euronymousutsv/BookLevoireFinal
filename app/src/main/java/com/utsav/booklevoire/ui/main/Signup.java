package com.utsav.booklevoire.ui.main;

import androidx.lifecycle.Observer;
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

import com.google.firebase.auth.FirebaseUser;
import com.utsav.booklevoire.R;
import com.utsav.booklevoire.User;
import com.utsav.booklevoire.databinding.FragmentSignupBinding;
import com.utsav.booklevoire.viewModel.MainViewModel;
import com.utsav.booklevoire.viewModel.SignupViewModel;

import java.util.Random;

public class Signup extends Fragment {
FragmentSignupBinding binding;
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
               String email=binding.signupEmail.getText().toString();
               String Name= binding.signupName.getText().toString();
               String password=binding.signupPassword.getText().toString();

               //Firebase
                Random rand=new Random();
                int rand_int= rand.nextInt(1000);



                User user=new User();
                user.Email=email;
                user.Name= Name;
                user.Password=password;
                user.uid=rand_int;


                mViewModel.insert(user);
                Toast.makeText(getContext(),"SignUp Successfull",Toast.LENGTH_SHORT).show();
            }
        });
        binding.signInTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_signup_to_mainFragment);
            }
        });


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