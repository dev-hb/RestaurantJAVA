package hba.examen.part1.GestionIngredient;

import java.util.List;

public interface IngredientDAO {

    public Ingredient getOne(String code);
    public List<Ingredient> getAll();

}
