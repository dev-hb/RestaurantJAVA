package hba.examen.part1.GestionCommand;

import hba.examen.part1.Calcul;
import hba.examen.part1.GestionPlat.PlatPrincipal;
import hba.examen.part1.GestionSupplement.Supplement;

import java.util.List;

public class Repas implements Calcul {

    private long id;
    private double total;
    private List<Supplement> supplements;
    private PlatPrincipal platPrincipal;

    public Repas(long id) {
        this.id = id;
        this.total = 0;
    }

    public double getTotal() {
        return total;
    }

    public List<Supplement> getSupplements() {
        return supplements;
    }

    public void setSupplements(List<Supplement> supplements) {
        this.supplements = supplements;
    }

    public PlatPrincipal getPlatPrincipal() {
        return platPrincipal;
    }

    public void setPlatPrincipal(PlatPrincipal platPrincipal) {
        this.platPrincipal = platPrincipal;
    }

    @Override
    public void calculerTotal() {
        this.supplements.forEach(supplement -> {
            this.total += supplement.getPrix();
        });
        this.total += platPrincipal.getTotal();
    }

    @Override
    public String toString() {
        return "Repas N°:" + id + " " + platPrincipal.getNom();
    }
}
