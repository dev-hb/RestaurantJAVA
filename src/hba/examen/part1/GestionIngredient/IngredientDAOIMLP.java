package hba.examen.part1.GestionIngredient;

import hba.examen.part1.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IngredientDAOIMLP implements IngredientDAO {
    Map<String, Ingredient> ingedients;

    public IngredientDAOIMLP() {
        ingedients = Data.getInstance().getDataIngedients();
    }

    @Override
    public Ingredient getOne(String code) {
        return ingedients.get(code);
    }

    @Override
    public List<Ingredient> getAll() {
        List<Ingredient> list = new ArrayList<>();
        ingedients.forEach((k, ingredient) -> {
            list.add(ingredient);
        });
        return list;
    }
}
