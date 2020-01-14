package hba.examen.part1.GestionSupplement;

import hba.examen.part1.GestionCommand.Command;

public class Supplement {
    private String code;
    private String nom;
    private int quantity;
    private double prix;
    private Command command;

    public Supplement(String code, String nom, double prix) {
        this.code = code;
        this.nom = nom;
        this.prix = prix;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return nom + " " + prix;
    }
}
