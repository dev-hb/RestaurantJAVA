package hba.examen.part1.GestionPlat;

import hba.examen.part1.Calcul;
import hba.examen.part1.GestionCommand.IngredientPlat;

import java.util.List;

public class PlatPrincipal implements Calcul {
    private String code;
    private String nom;
    private double total;
    private List<IngredientPlat> ingredientPlats;

    public PlatPrincipal(String code, String nom) {
        this.code = code;
        this.nom = nom;
        this.total = 0;
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

    public double getTotal() {
        return total;
    }

    public List<IngredientPlat> getIngredientPlats() {
        return ingredientPlats;
    }

    public void setIngredientPlats(List<IngredientPlat> ingredientPlats) {
        this.ingredientPlats = ingredientPlats;
    }

    @Override
    public String toString() {
        return "PlatPrincipal{" +
                "code='" + code + '\'' +
                ", nom='" + nom + '\'' +
                ", total=" + total +
                '}';
    }

    @Override
    public void calculerTotal() {
        this.ingredientPlats.forEach(ingredientPlat -> {
            this.total += ingredientPlat.getIngredient().getPrixUnitaire() * ingredientPlat.getQuantite();
        });
    }
}
