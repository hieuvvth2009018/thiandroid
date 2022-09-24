package com.example.thiandroied;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class EmployeeAdapter extends BaseAdapter {
    private Activity activity;
    private List<com.example.thiandroied.Employee> employees;
    private SQLiteHelper sqLiteHelper;

    public EmployeeAdapter(Activity activity, List<com.example.thiandroied.Employee> employees, SQLiteHelper sqLiteHelper) {
        this.activity = activity;
        this.employees = employees;
        this.sqLiteHelper = sqLiteHelper;
    }

    @Override
    public int getCount() {
        return employees.size();
    }

    @Override
    public Object getItem(int position) {
        return employees.get(position);
    }

    @Override
    public long getItemId(int position) {
        return employees.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(R.layout.row, parent, false);
        com.example.thiandroied.Employee employee = employees.get(position);
        TextView tvItemName = convertView.findViewById(R.id.tvItemName);
        TextView tvItemDesignation = convertView.findViewById(R.id.tvItemDesignation);
        TextView tvItemSalary = convertView.findViewById(R.id.tvItemSalary);
        tvItemName.setText(employee.getName());
        tvItemDesignation.setText(employee.getDesignation());
        tvItemSalary.setText(String.valueOf(employee.getSalary()));
        return convertView;
    }
}
