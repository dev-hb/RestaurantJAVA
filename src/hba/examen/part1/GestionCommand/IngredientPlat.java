package hba.examen.part1.GestionCommand;

import hba.examen.part1.GestionIngredient.Ingredient;
import hba.examen.part1.GestionPlat.PlatPrincipal;

public class IngredientPlat {
    private int quantite;
    private Ingredient ingredient;
    private PlatPrincipal platPrincipal;
    private String ingname;
    private Double ingprix;

    public IngredientPlat(int quantite, Ingredient ingredient, PlatPrincipal platPrincipal) {
        this.quantite = quantite;
        this.ingredient = ingredient;
        this.platPrincipal = platPrincipal;
        this.setIngname(ingredient.getNom());
        this.setIngprix(ingredient.getPrixUnitaire());
    }

    public String getIngname() {
        return ingname;
    }

    public void setIngname(String ingname) {
        this.ingname = ingname;
    }

    public Double getIngprix() {
        return ingprix;
    }

    public void setIngprix(Double ingprix) {
        this.ingprix = ingprix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
        this.setIngname(ingredient.getNom());
        this.setIngprix(ingredient.getPrixUnitaire());
    }

    public PlatPrincipal getPlatPrincipal() {
        return platPrincipal;
    }

    public void setPlatPrincipal(PlatPrincipal platPrincipal) {
        this.platPrincipal = platPrincipal;
    }

    @Override
    public String toString() {
        return ingredient.getNom() + ": "+ quantite + " " + ingredient.getUnite();
    }
}
