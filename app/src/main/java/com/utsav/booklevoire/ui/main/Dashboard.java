package com.utsav.booklevoire.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.utsav.booklevoire.Database_n_Repository.Book;
import com.utsav.booklevoire.RecyclerAdapter.BookRecyclerViewAdapter;
import com.utsav.booklevoire.R;
import com.utsav.booklevoire.databinding.FragmentDashboardBinding;
import com.utsav.booklevoire.viewModel.DashboardViewModel;

import java.util.List;

public class Dashboard extends Fragment {
private FragmentDashboardBinding binding; //binding fragment

    private DashboardViewModel mViewModel;


    public static Dashboard newInstance() {
        return new Dashboard();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        mViewModel.createAppRepo(getContext());

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // return inflater.inflate(R.layout.fragment_dashboard, container, false);
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
//inflating the bindingobject

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//Displays data on recyclerview
        binding.showBookRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.showBookRecyclerView.setHasFixedSize(true);

        BookRecyclerViewAdapter bookRecyclerViewAdapter = new BookRecyclerViewAdapter();
        binding.showBookRecyclerView.setAdapter(bookRecyclerViewAdapter);

        List<Book> list =mViewModel.getallBook();
        bookRecyclerViewAdapter.submitList(list);
        //Logout with clickEvent
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_dashboard_to_mainFragment);
            }
        });







      /*  ImageView imageView=binding.image2;
        String url;
        url="https://res.cloudinary.com/scribe-publications/image/upload/v1680711966/newcovers/9781922585677_rev2.jpg";
        Picasso.get().load(url).into(imageView);*/


    }

/*
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);

    }*/
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }

}