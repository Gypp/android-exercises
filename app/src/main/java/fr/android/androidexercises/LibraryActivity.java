package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LibraryActivity extends AppCompatActivity {

    private static final Random RANDOM = new Random();
    private ListView bookListView;

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        List<Book> books = getBooks();

        // TODO findViewById() and setAdapter()
        /*bookListView = (ListView)findViewById(R.id.bookListView);
        BookAdapter bookAdapter = new BookAdapter(this, books);
        bookListView.setAdapter(bookAdapter);*/

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, getResources().getBoolean(R.bool.landscape)?2:1));
        recyclerView.setAdapter(new NewBookAdapter(this, books));
    }

    private List<Book> getBooks() {
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            books.add(new Book(String.format("Garry Potier Tome %d", i), RANDOM.nextInt(30)));
        }
        return books;
    }

}
