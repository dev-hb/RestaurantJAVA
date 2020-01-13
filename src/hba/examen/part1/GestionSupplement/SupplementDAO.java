package hba.examen.part1.GestionSupplement;

import java.util.List;

public interface SupplementDAO {

    public Supplement getOne(String code);
    public List<Supplement> getAll();

}
