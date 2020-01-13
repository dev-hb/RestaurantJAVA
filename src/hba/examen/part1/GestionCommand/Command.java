package hba.examen.part1.GestionCommand;

import hba.examen.part1.Calcul;

import java.util.List;

public class Command implements Calcul {

    private long id;
    private double total;
    private List<Repas> repas;

    public Command(long id) {
        this.id = id;
        this.total = 0;
    }

    public List<Repas> getRepas() {
        return repas;
    }

    public void setRepas(List<Repas> repas) {
        this.repas = repas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public void calculerTotal() {
        this.repas.forEach(repas1 -> {
            this.total += repas1.getTotal();
        });
    }
}
