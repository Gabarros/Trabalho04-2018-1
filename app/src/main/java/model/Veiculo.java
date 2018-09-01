package model;

import com.google.gson.annotations.SerializedName;

public class Veiculo {


    @SerializedName("tipo")
    private String tipo;
    @SerializedName("marca")
    private String marca;
    @SerializedName("modelo")
    private String modelo;
    @SerializedName("ano")
    private String ano;


    public Veiculo(String tipo, String marca, String modelo, String ano){


        this.setTipo(tipo);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setAno(ano);

    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
