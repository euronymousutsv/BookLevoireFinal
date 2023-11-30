package com.utsav.booklevoire.viewModel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.utsav.booklevoire.AuthenticationRepository;
import com.utsav.booklevoire.Database_n_Repository.AppRepo;
import com.utsav.booklevoire.Database_n_Repository.User;

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

    private final AuthenticationRepository AuthenticationRepository = new AuthenticationRepository();
    private final MutableLiveData<Boolean> registrationResult=AuthenticationRepository.getRegistrationResult();
    public MutableLiveData<Boolean> getRegistrationResult() {
        return registrationResult;
    }

    public void registerUser(String email, String password) {
        AuthenticationRepository.registerUser(email, password);
    }

}