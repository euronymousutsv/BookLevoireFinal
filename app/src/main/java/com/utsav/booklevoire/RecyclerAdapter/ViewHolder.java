package com.utsav.booklevoire.RecyclerAdapter;



import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.google.protobuf.FloatValue;
import com.squareup.picasso.Picasso;
import com.utsav.booklevoire.Database_n_Repository.Book;
import com.utsav.booklevoire.R;
import com.utsav.booklevoire.databinding.RecyclerviewShowBookBinding;
import com.utsav.booklevoire.viewModel.DetailViewViewModel;

//view holder for recycler adapter
public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
private RecyclerviewShowBookBinding binding;
private DetailViewViewModel detailViewViewModel;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
    }
public ViewHolder(RecyclerviewShowBookBinding binding, DetailViewViewModel viewModel){
        super(binding.getRoot());
        this.binding=binding;
        this.detailViewViewModel=viewModel;
        binding.getRoot().setOnClickListener(this);
}
//This method will load data into recycle view adapter
public void update(Book book){
binding.bookNamerec.setText(book.bookName);
binding.AuthorRec.setText(book.bookAuthor);
binding.ratingBarRecycle.setRating(Float.valueOf(book.AverageRating));

   //third party api Picasso to compress and display image through url.Need internet permission
    //Internet permission has been provided from android manifest file
    ImageView imageView=binding.imageBook;
    String url;
    url=book.ImageURL;
    Picasso.get().load(url).into(imageView);

    binding.getRoot().setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int x = getAdapterPosition();


            Bundle bundle=new Bundle();
            bundle.putString("bookName",book.bookName);
            bundle.putString("author",book.bookAuthor);
            bundle.putFloat("rating", Float.valueOf(book.AverageRating));
            bundle.putString("imageUrl",book.ImageURL);
            bundle.putInt("bookID", book.bID);
            Navigation.findNavController(v).navigate(R.id.action_dashboard_to_detailView, bundle);

        }
    });

}


    @Override
    public void onClick(View v) {

    }
}
