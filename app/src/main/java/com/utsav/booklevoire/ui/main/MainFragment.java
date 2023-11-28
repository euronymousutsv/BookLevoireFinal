package com.utsav.booklevoire.ui.main;

import androidx.activity.result.ActivityResultLauncher;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.utsav.booklevoire.R;
import com.utsav.booklevoire.databinding.FragmentMainBinding;
import com.utsav.booklevoire.viewModel.MainViewModel;

public class MainFragment extends Fragment {
private FragmentMainBinding binding;


    private MainViewModel mViewModel;
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel

    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.signInBtn.setOnClickListener(new View.OnClickListener() {


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
}