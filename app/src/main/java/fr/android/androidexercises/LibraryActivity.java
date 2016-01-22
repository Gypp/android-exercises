package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import timber.log.Timber;

public class LibraryActivity extends AppCompatActivity {

    public List<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        // Plant logger cf. Android Timber
        Timber.plant(new Timber.DebugTree());

        // TODO build Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // TODO create a service
        HenriPotierService henriPotierService = retrofit.create(HenriPotierService.class);

        // TODO listBooks()
        Call<List<Book>> call = henriPotierService.listBooks();



        // TODO enqueue call and display book title
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Response<List<Book>> response, Retrofit retrofit) {
                books = response.body();
                for(Book book : books){
                    // TODO log books
                    Timber.i(book.getTitle());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Timber.i("Fail");
            }
        });


        // TODO display book as a list
        ListView listView = (ListView) findViewById(R.id.bookListView);
    }

}
