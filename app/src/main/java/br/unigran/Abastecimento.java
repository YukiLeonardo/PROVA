package br.unigran;

import java.util.Date;

public class Abastecimento {

    private Integer id;
    private String km;
    private String qntAbs;
    private String data;
    private String valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getQntAbs() {
        return qntAbs;
    }

    public void setQntAbs(String qntAbs) {
        this.qntAbs = qntAbs;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return km;

    }
}
