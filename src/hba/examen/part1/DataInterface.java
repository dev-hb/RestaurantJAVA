package hba.examen.part1;

import hba.examen.part1.GestionClient.Client;
import hba.examen.part1.GestionIngredient.Ingredient;
import hba.examen.part1.GestionPlat.PlatPrincipal;
import hba.examen.part1.GestionSupplement.Supplement;

import java.util.Map;

interface DataInterface {
    public Map<String, Ingredient> getDataIngedients();
    public Map<String, Supplement> getDataSupplements();
    public Client getClient(String login, String pwd);
    public Map<String, PlatPrincipal> getDataPlats();
}
