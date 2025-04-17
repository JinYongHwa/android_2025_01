package kr.ac.mjc.itc2007261051;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import kr.ac.mjc.itc2007261051.dto.BookDto;
import kr.ac.mjc.itc2007261051.dto.ResponseDto;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements BookAdapter.OnBookClickListener {

    EditText keywordEt;
    Button searchBtn;
    ProgressBar loadingPb;
    RecyclerView booklistRv;

    ArrayList<Book> mBookList=new ArrayList();

    BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loadingPb=findViewById(R.id.loading_pb);
        keywordEt=findViewById(R.id.keyword_et);
        searchBtn=findViewById(R.id.search_btn);
        booklistRv=findViewById(R.id.booklist_rv);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword=keywordEt.getText().toString();
                search(keyword);
            }
        });
        /*
        for(int i=0;i<100000;i++){
            Book book=new Book();
            book.setTitle("안드로이드 정석"+i);
            book.setAuthor("진용화"+i);
            book.setPublisher("명지출판사"+i);
            mBookList.add(book);
        }
        */

        bookAdapter=new BookAdapter(mBookList);
        bookAdapter.setOnBookClickListener(this);
        booklistRv.setAdapter(bookAdapter);
        booklistRv.setLayoutManager(new LinearLayoutManager(this));

    }
    //도서관 책검색 api호출
    public void search(String keyword){
        startLoading();
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                .get()
        .url("https://lib.mjc.ac.kr/pyxis-api/1/collections/1/search?all=k|a|"+keyword+"&abc=&rq=")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String json=response.body().string();
                // json -> ResponseDto 클래스 형태로 변환
                ResponseDto responseDto=new Gson().fromJson(json, ResponseDto.class);
                ArrayList<BookDto> bookList=responseDto.getData().getList();
                mBookList.clear();
                for(BookDto bookDto:bookList){
                    Book book=new Book();
                    book.setId(bookDto.getId());
                    book.setTitle(bookDto.getTitleStatement());
                    book.setAuthor(bookDto.getAuthor());
                    book.setPublisher(bookDto.getPublication());
                    book.setThumbUrl(bookDto.getThumbnailUrl());
                    mBookList.add(book);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        endLoding();
                        bookAdapter.notifyDataSetChanged();
                    }
                });



            }
        });
    }

    public void startLoading(){
        loadingPb.setVisibility(VISIBLE);
    }
    public void endLoding(){
        loadingPb.setVisibility(GONE);
    }

    @Override
    public void onBookClick(Book book) {
        Log.d("book",book.getTitle());
        Intent intent=new Intent(this,BookActivity.class);
        intent.putExtra("book",book);
        startActivity(intent);
    }
}