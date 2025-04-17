package kr.ac.mjc.itc2007261051;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    ArrayList<Book> mBookList=new ArrayList();

    OnBookClickListener onBookClickListener;

    public BookAdapter(ArrayList<Book> bookList){
        this.mBookList=bookList;
    }

    public void setOnBookClickListener(OnBookClickListener l){
        this.onBookClickListener=l;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("BookAdapter","onCreateViewHolder");
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_book,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("BookAdapter","onBindViewHolder : "+position);
        Book book=mBookList.get(position);
        holder.onBind(book);
    }
    

    @Override
    public int getItemCount() {
        Log.d("BookAdapter","getItemCount :"+mBookList.size());
        return mBookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView thumbIv;
        TextView titleTv;
        TextView authorTv;
        TextView pubTv;
        Book book;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbIv=itemView.findViewById(R.id.thumb_iv);
            titleTv=itemView.findViewById(R.id.title_tv);
            authorTv=itemView.findViewById(R.id.author_tv);
            pubTv=itemView.findViewById(R.id.pub_tv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBookClickListener.onBookClick(book);
                }
            });
        }
        public void onBind(Book book){
            this.book=book;
            titleTv.setText(book.getTitle());
            authorTv.setText(book.getAuthor());
            pubTv.setText(book.getPublisher());
            Glide.with(thumbIv.getContext())
                    .load(book.getThumbUrl())
                    .into(thumbIv);
        }



    }

    interface OnBookClickListener{
        void onBookClick(Book book);
    }
}
