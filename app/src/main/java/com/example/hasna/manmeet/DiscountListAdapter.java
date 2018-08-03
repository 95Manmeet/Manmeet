package com.example.hasna.manmeet;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DiscountListAdapter extends ArrayAdapter<JSONObject> {

    String number;

    int vg;
    ArrayList<JSONObject> list;

    Context context;

    public DiscountListAdapter (@NonNull Context context, int vg, int number, ArrayList<JSONObject> list ) {
        super(context, vg, number, list);
        this.context= context;
        this.vg = vg;
        this.list = list;
    }


    public View getView(int position , View convertView , ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService (Context.LAYOUT_INFLATER_SERVICE);


        View  itemView  = inflater.inflate(vg,parent,false);
        TextView textName = (TextView)itemView.findViewById(R.id.txtName);
        TextView textNumber = (TextView)itemView.findViewById(R.id.txtValidFrom);
        TextView textAddress = (TextView)itemView.findViewById(R.id.txtValidTo);
        TextView textCompany = (TextView)itemView.findViewById(R.id.txtCompany);

        try {
            textCompany.setText(list.get(position).getString("company"));
            textName.setText(list.get(position).getString("name"));
            textAddress.setText(list.get(position).getString("Valid From"));
            textNumber.setText(list.get(position).getString("Valid To"));


            number = textNumber.getText().toString();


        }catch (JSONException e) {

            e.printStackTrace();

        }

        return itemView;
    }
}
