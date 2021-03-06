package com.example.planeeandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class MyArrayDetailsAdapter extends ArrayAdapter<Tache> {
    private final Context context;

    public MyArrayDetailsAdapter(Context context, Tache[] Taches) {
        super(context, R.layout.cell_taches_details, Taches);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Gestion optimisée de la mémoire (réutilisation de cellules):
        View cellView = convertView;
        if (cellView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            cellView = inflater.inflate(R.layout.cell_layout, parent, false);
        }
        // Remplissage de la cellule:
        TextView TaskName = cellView.findViewById(R.id.Details_Task_Name);
        TextView TaskStore = cellView.findViewById(R.id.Details_Task_Store);
        TextView TaskURL = cellView.findViewById(R.id.Details_Task_Url);
        Tache tache = getItem(position);
        TaskName.setText(tache.getNom());
        TaskStore.setText(tache.getNomMagasin());
        TaskURL.setText(tache.getSiteMagasin());
        return cellView;
    }
}
