package hba.examen.part1.GestionPlat;

import java.util.List;

public interface PlatPrincipalDAO {

    public PlatPrincipal getOne(String code);
    public List<PlatPrincipal> getAll();

}
