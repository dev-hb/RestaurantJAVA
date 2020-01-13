package hba.examen.part1.GestionCommand;

import hba.examen.part1.GestionIngredient.Ingredient;
import hba.examen.part1.GestionPlat.PlatPrincipal;

public class IngredientPlat {
    private int quantite;
    private Ingredient ingredient;
    private PlatPrincipal platPrincipal;

    public IngredientPlat(int quantite, Ingredient ingredient, PlatPrincipal platPrincipal) {
        this.quantite = quantite;
        this.ingredient = ingredient;
        this.platPrincipal = platPrincipal;
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
