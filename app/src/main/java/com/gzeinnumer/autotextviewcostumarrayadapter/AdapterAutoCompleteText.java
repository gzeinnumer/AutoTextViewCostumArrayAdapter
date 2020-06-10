package com.gzeinnumer.autotextviewcostumarrayadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AdapterAutoCompleteText extends ArrayAdapter<AdapterAutoCompleteText.ModelClass> {

    private List<ModelClass> list;
    private Context context;

    public AdapterAutoCompleteText(@NonNull Context context, @NonNull List<ModelClass> objects) {
        super(context, 0, objects);
        list = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.item_auto_textview, parent, false);

        ModelClass data = list.get(position);

        TextView name = listItem.findViewById(R.id.tv);
        name.setText(data.getName());

        return listItem;
    }

    public void setList(ArrayList<ModelClass> data) {
        this.list = data;
        notifyDataSetChanged();
    }

    public static class ModelClass {
        private int id;
        private String name;

        public ModelClass(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
