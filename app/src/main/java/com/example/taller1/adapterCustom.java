package com.example.taller1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.taller1.modelo.Saludos;

import java.util.List;

public class adapterCustom extends ArrayAdapter<Saludos> implements SpinnerAdapter {

public adapterCustom(@NonNull Context context , @NonNull List objects)
        {
        super(context, R.layout.simple_spinner_dropdown_item , objects);
        }

@NonNull
@Override
public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
        {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.simple_spinner_dropdown_item , null , false);

                TextView textView = convertView.findViewById(android.R.id.text2);
                Saludos saludo = getItem(position);
                if (saludo != null) {
                        textView.setText(saludo.getName()); // Assuming getName() returns the name
                }

        return convertView;
        }}
