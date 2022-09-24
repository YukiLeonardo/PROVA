package br.unigran;

import java.util.Date;

public class Abastecimento {
    private String km;
    private String qntAbs;
    private Date data;
    private String valor;

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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
        return "Abastecimento{" +
                "km='" + km + '\'' +
                ", qntAbs='" + qntAbs + '\'' +
                ", data=" + data +
                ", valor='" + valor + '\'' +
                '}';
    }
}
