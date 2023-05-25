package com.example.mobilebanking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ListViewHolder> {

    public interface OnChoosedItemClickListener {
        void onServiceClick(Service service, int position);
    }

    private List<Service> serviceList;
    private final OnChoosedItemClickListener onClickListener;

    public ServiceAdapter(List<Service> serviceList,OnChoosedItemClickListener onClickListener) {
        this.serviceList = serviceList;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_service_item, parent,false);
        return new ListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Service service = serviceList.get(position);
        holder.serviceResource.setImageResource(service.getServiceResource());
        holder.name.setText(service.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onServiceClick(service, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder{
        ImageView serviceResource;
        TextView name;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            serviceResource = itemView.findViewById(R.id.service);
            name = itemView.findViewById(R.id.name);
        }
    }

}
