package kr.ac.mjc.itc2007261051;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kr.ac.mjc.itc2007261051.dto.BookLocationDto;

public class BookLocationAdapter extends RecyclerView.Adapter<BookLocationAdapter.ViewHolder> {

    List<BookLocationDto> bookLocationList;

    public BookLocationAdapter(List<BookLocationDto> locationList){
        this.bookLocationList=locationList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_location,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BookLocationDto locationDto=bookLocationList.get(position);
        holder.bind(locationDto);
    }

    @Override
    public int getItemCount() {
        return bookLocationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView locationTv;
        TextView noTv;
        TextView statusTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            locationTv=itemView.findViewById(R.id.location_tv);
            noTv=itemView.findViewById(R.id.no_tv);
            statusTv=itemView.findViewById(R.id.status_tv);
        }
        public void bind(BookLocationDto location){
            locationTv.setText(location.getLocation().getName());
            noTv.setText(location.getCallNo());
            String status=location.getCirculationState().getName();
            if(status.equals("대출가능")){
                int color=statusTv.getContext().getColor(R.color.green);
                statusTv.setTextColor(color);
            }
            else{
                int color=statusTv.getContext().getColor(R.color.red);
                statusTv.setTextColor(color);
            }

            statusTv.setText(location.getCirculationState().getName());
        }
    }
}
