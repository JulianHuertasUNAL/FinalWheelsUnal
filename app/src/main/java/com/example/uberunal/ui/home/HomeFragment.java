package com.example.uberunal.ui.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uberunal.R;
import com.example.uberunal.databinding.FragmentHomeBinding;
import com.example.uberunal.ui.adaptadorListaRutas.adaptadorListaRutas;
import com.example.uberunal.ui.listaRutas.listaRutas;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private Spinner spinner1;
    adaptadorListaRutas adapterRutas;
    RecyclerView recyclerView;
    ArrayList<listaRutas> listaRutas;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        spinner1 = (Spinner)root.findViewById(R.id.spinner);
        String [] dias= {"Lunes","Martes","Miércoles","Jueves","Viernes","Sábado"};
        ArrayAdapter <String> adapter= new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,dias);
        spinner1.setAdapter(adapter);

        recyclerView = root.findViewById(R.id.recyclerViewAplicarRutas);
        listaRutas = new ArrayList<>();
        //cargar la lista
        cargarLista();
        //Mostrar datos
        mostrarData();
        return root;
    }
    public void cargarLista(){
        listaRutas.add(new listaRutas("Martes","Marcos","9:30","2.100",R.drawable.referencia_carro1));
        listaRutas.add(new listaRutas("Miercoles","Lucas","10:30","2.000",R.drawable.referencia_carro2));
        listaRutas.add(new listaRutas("Lunes","Jose","6:30","2.200",R.drawable.referencia_carro3));
        listaRutas.add(new listaRutas("Jueves","Antonio","1:30","2.300",R.drawable.referencia_carro4));
    }
    public void mostrarData(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterRutas = new adaptadorListaRutas(getContext(),listaRutas);
        recyclerView.setAdapter(adapterRutas);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}