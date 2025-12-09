package it.prova.motociclettajdbc.model;

import java.util.Date;

public class Motocicletta {
   private Long id;
   private String marca;
   private String modello;
   private Integer cilindrata;
   private Date dataImmatricolazione;

    public Motocicletta(){}

    public Motocicletta(String marca, String modello, Integer cilindrata, Date dataImmatricolazione) {
        this.marca = marca;
        this.modello = modello;
        this.cilindrata = cilindrata;
        this.dataImmatricolazione = dataImmatricolazione;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public Integer getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(Integer cilindrata) {
        this.cilindrata = cilindrata;
    }

    public Date getDataImmatricolazione() {
        return dataImmatricolazione;
    }

    public void setDataImmatricolazione(Date dataImmatricolazione) {
        this.dataImmatricolazione = dataImmatricolazione;
    }

    @Override
    public String toString(){
        return "Motocicletta [id=" + this.id + ", marca=" + this.marca + ", modello=" + this.modello + ", data immatricolazione= "+ this.dataImmatricolazione + "]";
    }
}
