package hba.examen.part1.GestionPlat;

import hba.examen.part1.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlatPrincipalDAOIMPL implements PlatPrincipalDAO {
    Map<String, PlatPrincipal> plats;

    public PlatPrincipalDAOIMPL() {
        plats = Data.getInstance().getDataPlats();
    }

    @Override
    public PlatPrincipal getOne(String code) {
        return plats.get(code);
    }

    @Override
    public List<PlatPrincipal> getAll() {
        List<PlatPrincipal> list = new ArrayList<>();
        plats.forEach((k, plat) -> {
            list.add(plat);
        });
        return list;
    }
}
