package com.example.lerning_recycler_v_ew;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleItemAdaptar extends RecyclerView.Adapter<ExampleItemAdaptar.ExampleViewHolder> {
    private Context context;
    private ArrayList<ExampleItemAdaptar> arrayList;
    public ExampleItemAdaptar(Context context,ArrayList<ExampleItemAdaptar> adaptarArrayList){
        this.context=context;
        this.arrayList=adaptarArrayList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textViewCreator;
        public TextView textViewLike;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            textViewCreator=itemView.findViewById(R.id.creator);
            textViewLike=itemView.findViewById(R.id.like);

        }
    }
}
