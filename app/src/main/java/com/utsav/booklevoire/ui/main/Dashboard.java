package com.utsav.booklevoire.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.utsav.booklevoire.R;
import com.utsav.booklevoire.databinding.FragmentDashboardBinding;
import com.utsav.booklevoire.viewModel.DashboardViewModel;

import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.Executor;

public class Dashboard extends Fragment {
FragmentDashboardBinding binding;

    private DashboardViewModel mViewModel;

    public static Dashboard newInstance() {
        return new Dashboard();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // return inflater.inflate(R.layout.fragment_dashboard, container, false);
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;





    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView=binding.image2;
        String url;
        url="https://res.cloudinary.com/scribe-publications/image/upload/v1680711966/newcovers/9781922585677_rev2.jpg";
        Picasso.get().load(url).into(imageView);


    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        // TODO: Use the ViewModel
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }

}