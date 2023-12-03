package com.utsav.booklevoire.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.utsav.booklevoire.R;
import com.utsav.booklevoire.Database_n_Repository.User;
import com.utsav.booklevoire.UserClass;
import com.utsav.booklevoire.databinding.FragmentMainBinding;
import com.utsav.booklevoire.viewModel.MainViewModel;

public class MainFragment extends Fragment {

   private MainViewModel mViewModel;
private FragmentMainBinding binding;
public static MainFragment newInstance() {return new MainFragment();}

/*

//LiveData<FirebaseUser>firebaseUserLiveData ;
//private ActivityResultLauncher<Intent> signInLauncher = registerForActivityResult(
  //      new FirebaseAuthUIActivityResultContract(),(result -> {
   //         mViewModel.updateFirebaseUser();
     //   })
//);
//private void startSignIn(){
  //  Intent intent= AuthUI.getInstance().createSignInIntentBuilder().build();
    //signInLauncher.launch(intent);
//

  //  public static MainFragment newInstance() {
      //  return new MainFragment();
    //}
*/
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
//mViewModel.createAppRepo(getContext());
    }





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_main, container, false);
       binding=FragmentMainBinding.inflate(inflater,container,false);
       View view   =binding.getRoot();
       return view;



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextWatcher textWatcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        binding.signInEmail.addTextChangedListener(textWatcher);
        final Observer<String>nameObserver=new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newEmail) {
                binding.signInEmail.setText(newEmail);
            }
        };
       // mViewModel.getUserEmail().observe(getViewLifecycleOwner(),nameObserver);
        binding.signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //User Login Validation
                String email=binding.signInEmail.getText().toString();
                String password=binding.signInPassword.getText().toString();
               // User user=new User();
                //user=mViewModel.findbyEmail(email,password);
                UserClass user = new UserClass(email,password);
                mViewModel.signInUser(user);
                mViewModel.getSignInResult().observe(getViewLifecycleOwner(), isSuccess -> {
                    if (isSuccess) {
                        // Sign-in successful, handle navigation or UI updates
                        Toast.makeText(requireContext(), "Sign-in successful", Toast.LENGTH_SHORT).show();
                        Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_signup);
                    } else {
                        // Sign-in failed, show an error message
                        Toast.makeText(requireContext(), "Sign-in failed", Toast.LENGTH_SHORT).show();
                    }
                });


                //if(user!=null){
                //    int id=user.uid;

                //Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_dashboard);}
                //else{
                  //  Toast.makeText(getContext(),"Please Login With Valid Credential",Toast.LENGTH_LONG).show();
                //}
           // }
        }});




        //Navigate to signup page
        binding.signupTxtView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_signup);}

        });
    }

    /*
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.signInBtn.setOnClickListener(new View.OnClickListener() {
            User user=new User();

            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_dashboard);
            }
        });
        binding.signupTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_signup);
            }
        });

        //firebaseUserLiveData= mViewModel.getMutableLiveData();
        //firebaseUserLiveData.observe(getViewLifecycleOwner(),firebaseUser -> {
        // if(firebaseUser!=null){
        //   Toast.makeText(getActivity(),"Login Success", Toast.LENGTH_SHORT).show();
        //}
        //else startSignIn();
        //});
        //mViewModel.updateFirebaseUser();


    }*/
}