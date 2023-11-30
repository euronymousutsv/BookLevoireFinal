package com.utsav.booklevoire.RecyclerAdapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.utsav.booklevoire.Database_n_Repository.Book;
import com.utsav.booklevoire.databinding.RecyclerviewShowBookBinding;
//view holder for recycler adapter
public class ViewHolder extends RecyclerView.ViewHolder {
private RecyclerviewShowBookBinding binding;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
    }
public ViewHolder(RecyclerviewShowBookBinding binding){
        super(binding.getRoot());
        this.binding=binding;
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

}



}
