package com.example.lerning_recycler_v_ew;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
public class ExampleItemAdaptar extends RecyclerView.Adapter<ExampleItemAdaptar.ExampleViewHolder> {
    private Context context;
    private ArrayList<ExampleItem> arrayList;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
        void OnItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        onItemClickListener=listener;
    }
    public ExampleItemAdaptar(Context context, ArrayList<ExampleItem> adaptarArrayList) {
        this.context = context;
        this.arrayList = adaptarArrayList;
    }
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.example_item, parent, false);
        return new ExampleViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem curentitem=arrayList.get(position);
        String imageUr=curentitem.getImageurl();
        String Creator=curentitem.getCreator();
        int likecount=curentitem.getLikec();
        holder.textViewLike.setText("Likes:"+likecount+"");
        holder.textViewCreator.setText(Creator);
        Picasso.get().load(imageUr).fit().centerInside().into(holder.imageView);
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textViewCreator;
        public TextView textViewLike;
        public Button btn;
        public ExampleViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textViewCreator = itemView.findViewById(R.id.creator);
            textViewLike = itemView.findViewById(R.id.like);
            btn=itemView.findViewById(R.id.btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener!=null){
                        int positon=getAdapterPosition();
                        if (positon!=RecyclerView.NO_POSITION){
                            onItemClickListener.OnItemClick(positon);

                        }
                    }

                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
}
