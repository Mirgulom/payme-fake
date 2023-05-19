package com.example.mobilebanking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ServiceAdapter extends ArrayAdapter<Service> {
    private LayoutInflater inflater;
    private int layout;
    private List<Service> services;

    public ServiceAdapter(Context context, int resource, List<Service> services) {
        super(context, resource, services);
        this.services = services;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        ImageView serviceView = (ImageView) view.findViewById(R.id.service);
        TextView nameView = (TextView) view.findViewById(R.id.name);

        Service service = services.get(position);

        serviceView.setImageResource(service.getServiceResource());
        nameView.setText(service.getName());

        return view;
    }

}
