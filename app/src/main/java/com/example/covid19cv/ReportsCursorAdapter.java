package com.example.covid19cv;




import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//Adapter con el que se muestran los reportes en la actividad description

public class ReportsCursorAdapter extends RecyclerView.Adapter<ReportsCursorAdapter.ViewHolder> {
    Context context;
    Cursor cursor;
    private ArrayList<DataBaseMuni> municipiosdb;

    // Constructor que recoge el contexto y el cursor con la consulta a la base de datos

    public ReportsCursorAdapter(Context c, Cursor cur, int i){
        context = c;
        cursor = cur;
        init();
    }

    // Función que inicializa el ArrayList con los reportes que contiene el cursor
    public void init(){
        municipiosdb = new ArrayList<DataBaseMuni>();
        while (cursor.moveToNext()) {
            String id = cursor.getString(0);
            String mun = cursor.getString(1);
            String fi = cursor.getString(2);
            String fe = cursor.getString(3);

            DataBaseMuni mun_aux = new DataBaseMuni(id, mun, fi, fe);

            municipiosdb.add(mun_aux);
        }
    }


    @Override
    public int getItemCount() {
        return municipiosdb.size();
    }
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView_municipio;
        private final TextView textView_sintomas;

        private final TextView textView_fecha;


        public ViewHolder(View view) {
            super(view);
            //inicializacion de los TextViews
            textView_municipio = (TextView) view.findViewById(R.id.Munview);
            textView_sintomas = (TextView) view.findViewById(R.id.Sympsview);
            textView_fecha= (TextView) view.findViewById(R.id.Dateview);
        }

        //Funciones para obtener los TextViews
        public TextView getTextView_municipiodb() { return textView_municipio; }
        public TextView getTextView_sintomas() { return textView_sintomas; }
        public TextView getTextView_fecha() { return textView_fecha; }

    }
    // Create new views (invoked by the layout manager)
    @Override
    public ReportsCursorAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_report, viewGroup, false);
        return new ReportsCursorAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ReportsCursorAdapter.ViewHolder holder, int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.getTextView_municipiodb().setText(String.valueOf(municipiosdb.get(position).municipality));
        holder.getTextView_sintomas().setText(String.valueOf(municipiosdb.get(position).symptoms));
        holder.getTextView_fecha().setText(String.valueOf(municipiosdb.get(position).startDate));
    }
}


