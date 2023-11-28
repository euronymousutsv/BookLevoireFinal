package com.utsav.booklevoire;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.utsav.booklevoire.databinding.RecyclerviewShowBookBinding;

public class ViewHolder extends RecyclerView.ViewHolder {
private RecyclerviewShowBookBinding binding;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
    }
public ViewHolder(RecyclerviewShowBookBinding binding){
        super(binding.getRoot());
        this.binding=binding;
}

public void update(Book book){
binding.bookNamerec.setText(book.bookName);
binding.AuthorRec.setText(book.bookAuthor);
binding.ratingBarRecycle.setRating(Float.valueOf(book.AverageRating));
    ImageView imageView=binding.imageBook;
    String url;
    url=book.ImageURL;
    Picasso.get().load(url).into(imageView);

}



}
