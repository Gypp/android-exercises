package fr.android.androidexercises;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Gwénaël on 22/01/2016.
 */
public class NewBookAdapter extends RecyclerView.Adapter<NewBookAdapter.ViewHolder> {
    private List<Book> books;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView nameTextView;
        public TextView priceTextView;
        public ViewHolder(View v) {
            super(v);
            nameTextView = (TextView) v.findViewById(R.id.nameTextView);
            priceTextView = (TextView) v.findViewById(R.id.priceTextView);
        }
    }

    public NewBookAdapter(Context context, List<Book> books){
        this.books = books;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_view_item_book, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = books.get(position);
        holder.nameTextView.setText(book.name);
        holder.priceTextView.setText(String.valueOf(book.price));
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

}
