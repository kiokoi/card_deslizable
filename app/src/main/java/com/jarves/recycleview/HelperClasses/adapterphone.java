package com.jarves.recycleview.HelperClasses;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.annotation.NonNull;
import com.ramirez.soto.dev.card_deslisable.R;

import java.util.ArrayList;

import static com.ramirez.soto.dev.card_deslisable.R.layout.elemento_card;
import static java.lang.Integer.parseInt;

public class adapterphone extends RecyclerView.Adapter<adapterphone.PhoneViewHold> {
    String cant;

    ArrayList<com.jarves.recycleview.HelperClasses.phonehelper> phoneLaocations;
    final private ListItemClickListener mOnClickListener;

    public adapterphone(ArrayList<com.jarves.recycleview.HelperClasses.phonehelper> phoneLaocations, ListItemClickListener listener) {
        this.phoneLaocations = phoneLaocations;
        mOnClickListener = listener;
    }


    @NonNull

    @Override
    public PhoneViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_card, parent,false);
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_card, false);
        return new PhoneViewHold(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PhoneViewHold holder, int position) {


        com.jarves.recycleview.HelperClasses.phonehelper phonehelper = phoneLaocations.get(position);
        holder.image.setImageResource(phonehelper.getImage());
        holder.title.setText(phonehelper.getTitle());
        holder.cantidad.setText(phonehelper.getCantidad());
        holder.relativeLayout.setBackground(phonehelper.getgradient());

        //eventos
        holder.setOnClickListeners();
       // holder.boton_mas.setOnClickListener(this);
        //holder.boton_menos.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return phoneLaocations.size();

    }

    public interface ListItemClickListener {
        void onphoneListClick(int clickedItemIndex);
    }

    public class PhoneViewHold extends RecyclerView.ViewHolder implements View.OnClickListener {


        ImageView image;
        TextView title;
        TextView cantidad;
        RelativeLayout relativeLayout;
        //Botones
        Button boton_mas;
        Button boton_menos;



        public PhoneViewHold(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            //hooks

            image = itemView.findViewById(R.id.phone_image);
            title = itemView.findViewById(R.id.phone_title);
            cantidad = itemView.findViewById(R.id.cantidad);
            relativeLayout = itemView.findViewById(R.id.background_color);
            boton_mas = itemView.findViewById(R.id.phone_boton1);
            boton_menos = itemView.findViewById(R.id.phone_boton2);

        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onphoneListClick(clickedPosition);
            switch (v.getId()){
                case R.id.phone_boton1:
                    String c = (String) cantidad.getText();
                    int pcantidad = parseInt(c);
                    pcantidad = pcantidad + 1;
                    System.out.println("****"+c+"****MAS*****1******"+pcantidad);
                    cantidad.setText(String.valueOf(pcantidad));
                    break;
                case R.id.phone_boton2:
                    String a = (String) cantidad.getText();
                    int mcantidad = parseInt(a);
                    mcantidad = mcantidad - 1;
                    System.out.println("****"+a+"*****MENOS**********"+mcantidad);
                    cantidad.setText(String.valueOf(mcantidad));
                    //notifyDataSetChanged();
                    break;
            }
        }
        void setOnClickListeners(){
            boton_mas.setOnClickListener(this);
            boton_menos.setOnClickListener(this);
        }

    }

}
