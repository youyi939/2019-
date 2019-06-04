package com.example.youyi.recyclerview2;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.List;

public class UpAdapter extends RecyclerView.Adapter<UpAdapter.ViewHolder>{
    private DownAdapter downAdapter;
    private List<String> list ;
    private List<String> downData;

    public void setDownAdapter(DownAdapter downAdapter) {
        this.downAdapter = downAdapter;
    }

    public UpAdapter(List<String> mlist, DownAdapter mdownAdapter, List<String> mdownData){
        list = mlist;
        downData = mdownData;
        downAdapter = mdownAdapter;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.message_up,viewGroup,false);
        ViewHolder holder = new ViewHolder(view );
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        final String name = list.get(position);
        viewHolder.button.setText(name);
        viewHolder.change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downData.add(list.get(position));
                downAdapter.notifyDataSetChanged();
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
            change = view.findViewById(R.id.change_up);
            button = view.findViewById(R.id.btn_up);
        }

    }
}
