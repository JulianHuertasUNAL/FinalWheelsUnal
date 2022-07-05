package com.example.uberunal.ui.listaRutas;

public class listaRutas {
    private String dia;
    private String conductor;
    private String hora;
    private String tarifa;
    private int idImagenModeloCarro;

    public listaRutas(){}
    public listaRutas(String dia, String conductor, String hora, String tarifa, int idImagenModeloCarro) {
        this.dia = dia;
        this.conductor = conductor;
        this.hora = hora;
        this.tarifa = tarifa;
        this.idImagenModeloCarro = idImagenModeloCarro;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getConductor() {
        return "Conductor: "+conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getHora() {
        return "Salida: "+hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTarifa() {
        return "Tarifa: "+tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public int getIdImagenModeloCarro() {
        return idImagenModeloCarro;
    }

    public void setIdImagenModeloCarro(int idImagenModeloCarro) {
        this.idImagenModeloCarro = idImagenModeloCarro;
    }
}
