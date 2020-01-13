package hba.examen.part1.GestionSupplement;

import hba.examen.part1.Data;
import hba.examen.part1.GestionIngredient.Ingredient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SupplementDAOIMPL implements SupplementDAO {
    Map<String, Supplement> supplements;

    public SupplementDAOIMPL(){
        supplements = Data.getInstance().getDataSupplements();
    }

    @Override
    public Supplement getOne(String code) {
        return supplements.get(code);
    }

    @Override
    public List<Supplement> getAll() {
        List<Supplement> list = new ArrayList<>();
        supplements.forEach((k, supplement) -> {
            list.add(supplement);
        });
        return list;
    }
}
