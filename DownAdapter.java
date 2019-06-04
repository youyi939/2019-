package com.example.youyi.recyclerview2;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.List;

public class DownAdapter extends RecyclerView.Adapter<DownAdapter.ViewHolder> {
    private List<String> list;
    private List<String> upData;
    private UpAdapter adapter;

    public DownAdapter (List<String> mlist,List<String> List,UpAdapter upAdapter) {
        list = mlist;
        upData = List;
        adapter = upAdapter;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.message,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        String name = list.get(position);
        holder.button.setText(name);
        holder.change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upData.add(list.get(position));
                adapter.notifyDataSetChanged();
                list.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        Button button;
        Button change;
        public ViewHolder(View view){
            super(view);
            change = view.findViewById(R.id.change);
            button = view.findViewById(R.id.btn);

        }

    }






}
