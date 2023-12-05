package com.utsav.booklevoire.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.utsav.booklevoire.R;
import com.utsav.booklevoire.databinding.FragmentDetailViewBinding;
import com.utsav.booklevoire.viewModel.DetailViewViewModel;

public class DetailView extends Fragment {
private FragmentDetailViewBinding binding;
    private DetailViewViewModel mViewModel;

    public static DetailView newInstance() {
        return new DetailView();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DetailViewViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_detail_view, container, false);
        binding=FragmentDetailViewBinding.inflate(inflater,container,false);
        View view =  binding.getRoot();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
Bundle bundle=getArguments();
if (bundle!=null){
    String bookName= bundle.getString("bookName","");
    String author = bundle.getString("author", "");
    float rating = bundle.getFloat("rating", 0.0f);
    String imageUrl = bundle.getString("imageUrl", "");

    binding.bookName.setText(bookName);
    binding.authortxt.setText(author);
    binding.ratingBar.setRating(rating);

    Picasso.get().load(imageUrl).into(binding.imageView2);
        }
    }
/*
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DetailViewViewModel.class);
        // TODO: Use the ViewModel
    }*/
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }


}