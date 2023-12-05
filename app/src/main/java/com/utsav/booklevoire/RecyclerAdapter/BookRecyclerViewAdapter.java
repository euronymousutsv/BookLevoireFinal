package com.utsav.booklevoire.RecyclerAdapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.utsav.booklevoire.Database_n_Repository.Book;
import com.utsav.booklevoire.databinding.RecyclerviewShowBookBinding;
import com.utsav.booklevoire.viewModel.DetailViewViewModel;

public class BookRecyclerViewAdapter extends ListAdapter<Book, ViewHolder> {
private RecyclerviewShowBookBinding binding;
private DetailViewViewModel detailViewViewModel;
    public BookRecyclerViewAdapter(DetailViewViewModel viewModel){super(diffCallback);
        this.detailViewViewModel=viewModel;}
    private static DiffUtil.ItemCallback<Book> diffCallback = new DiffUtil.ItemCallback<Book>() {
        @Override
        public boolean areItemsTheSame(@NonNull Book oldItem, @NonNull Book newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Book oldItem, @NonNull Book newItem) {
            return false;
        }
    };



    protected BookRecyclerViewAdapter(@NonNull DiffUtil.ItemCallback<Book> diffCallback) {
        super(diffCallback);
    }

    protected BookRecyclerViewAdapter(@NonNull AsyncDifferConfig<Book> config) {
        super(config);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        binding =RecyclerviewShowBookBinding.inflate(inflater,parent,false);
       return new ViewHolder(binding,detailViewViewModel);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
Book book = getItem(position);
holder.update(book);
    }

}
