package com.utsav.booklevoire.viewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.utsav.booklevoire.AuthenticationRepository;
import com.utsav.booklevoire.Database_n_Repository.AppRepo;
import com.utsav.booklevoire.Database_n_Repository.User;
import com.utsav.booklevoire.UserClass;

public class SignupViewModel extends ViewModel {
    private AppRepo appRepo;
    public void createAppRepo(Context context){
        appRepo=new AppRepo(context);
    }
    public void insert (User user){
        appRepo.insert(user);
    }

   /* private AuthenticationRepository repository;
    private MutableLiveData<FirebaseUser> userData;
    private MutableLiveData<Boolean> loggedStatus;

    public MutableLiveData<FirebaseUser> getUserData() {
        return userData;
    }

    public MutableLiveData<Boolean> getLoggedStatus() {
        return loggedStatus;
    }

   public SignupViewModel(@NonNull Context context) {

        repository = new AuthenticationRepository(context);
        userData = repository.getFirebaseUserMutableLiveData();
        loggedStatus = repository.getUserLoggedMutableLiveData();
    }

    public void register(String email , String pass){
        repository.register(email, pass);
    // TODO: Implement the ViewModel


    // Firebase

}*/
//Firebase

    private AuthenticationRepository authRepository;
    private MutableLiveData<Boolean> registrationResult;

    public SignupViewModel() {
        authRepository=new AuthenticationRepository();
        registrationResult = authRepository.getRegistrationResult();

    }

    public MutableLiveData<Boolean> getRegistrationResult() {
        return registrationResult;
    }

    public void registerUser(UserClass user) {
        authRepository.registerUser(user);
    }


}