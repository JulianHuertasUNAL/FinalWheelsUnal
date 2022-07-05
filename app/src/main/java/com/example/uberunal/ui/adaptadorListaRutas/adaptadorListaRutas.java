package com.example.uberunal.ui.adaptadorListaRutas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uberunal.R;
import com.example.uberunal.ui.listaRutas.listaRutas;

import java.util.ArrayList;

public class adaptadorListaRutas extends RecyclerView.Adapter<adaptadorListaRutas.ViewHolder> implements View.OnClickListener{

    ArrayList<listaRutas> model;
    LayoutInflater inflater;

    //Listener
    private View.OnClickListener listener;

    public adaptadorListaRutas(Context context, ArrayList<listaRutas> model){
        this.inflater = LayoutInflater.from(context);
        this.model = model;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_aplicar_rutas,parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }
    public void serOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String dia = model.get(position).getDia();
        String conductor = model.get(position).getConductor();
        String hora = model.get(position).getHora();
        String tarifa = model.get(position).getTarifa();
        int modelo = model.get(position).getIdImagenModeloCarro();
        holder.dia.setText(dia);
        holder.conductor.setText(conductor);
        holder.hora.setText(hora);
        holder.tarifa.setText(tarifa);
        holder.modelo.setImageResource(modelo);

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public void onClick(View view) {
        if(listener != null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView dia,conductor,hora,tarifa;
        ImageView modelo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dia = itemView.findViewById(R.id.dia_aplicar_ruta);
            conductor = itemView.findViewById(R.id.conductor_aplicar_ruta);
            hora = itemView.findViewById(R.id.hora_salida_aplicar_ruta);
            tarifa = itemView.findViewById(R.id.tarifa_aplicar_ruta);
            modelo = itemView.findViewById(R.id.imagen_modelo_carro);
        }
    }
}
