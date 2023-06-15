package com.example.juegodsarest3.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.juegodsarest3.R;
import com.example.juegodsarest3.models.Insignia;
import com.example.juegodsarest3.models.TablaInsignia;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorInsignias extends RecyclerView.Adapter<com.example.juegodsarest3.activities.AdaptadorObjetosComprados.ViewHolder> {
        private List<TablaInsignia> values;


        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView txtHeader;
            public ImageView icon;
            public View layout;


            public ViewHolder(View v) {
                super(v);
                layout = v;
                txtHeader = (TextView) v.findViewById(R.id.objetoComprado);
                icon = (ImageView) v.findViewById(R.id.fotoObjeto);

            }
        }

        public void setData(List<Insignia> myDataset) {
            values = myDataset;
            notifyDataSetChanged();
        }

        public void add(int position, TablaInsignia item) {
            values.add(position, item);
            notifyItemInserted(position);
        }

        public void remove(int position) {
            values.remove(position);
            notifyItemRemoved(position);
        }

        public AdaptadorInsignias(){values = new ArrayList<>();}

        public AdaptadorInsignias(List<TablaInsignia> myDataset) {
            values = myDataset;
        }


        @Override
        public com.example.juegodsarest3.activities.AdaptadorObjetosComprados.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                                                            int viewType) {

            LayoutInflater inflater = LayoutInflater.from(
                    parent.getContext());
            View v =
                    inflater.inflate(R.layout.activity_objetoscomprados, parent, false);

            com.example.juegodsarest3.activities.AdaptadorInsignias.ViewHolder vh = new com.example.juegodsarest3.activities.AdaptadorInsignias().ViewHolder(v);
            return vh;
        }


        @Override
        public void onBindViewHolder(com.example.juegodsarest3.activities.AdaptadorObjetosComprados.ViewHolder holder, final int position) {

            TablaInsignia o = values.get(position);
            final String name = o.getNombreinsignia();
            holder.txtHeader.setText(name);

            holder.txtHeader.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    remove (holder.getAdapterPosition());
                }
            });




        }


        @Override
        public int getItemCount() {
            return values.size();
        }


    }

