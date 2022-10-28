package com.example.ex8;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RViewHolder> {

    private Context context;
    private List<Task> taskList;

    public RVAdapter(Context context, List<Task> taskList) {
        this.context = context;
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public RVAdapter.RViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_items, parent, false);

        return new RVAdapter.RViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter.RViewHolder holder, int position) {


            Task task = taskList.get(position);

            holder.nameTv.setText(task.getName());
            holder.ageTv.setText(task.getAge());

    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }


    public class RViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView nameTv, ageTv;

        public RViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.nameTV);
            ageTv = itemView.findViewById(R.id.ageTV);

        }

        @Override
        public void onClick(View view) {
            Task task = taskList.get(getAdapterPosition());

            Intent intent = new Intent(context, MainActivity3.class);
            intent.putExtra("task", task);

            context.startActivity(intent);
        }
    }



}
