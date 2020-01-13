package hba.examen.part1;

import hba.examen.part1.GestionClient.Client;
import hba.examen.part1.GestionCommand.Command;
import hba.examen.part1.GestionCommand.IngredientPlat;
import hba.examen.part1.GestionCommand.Repas;
import hba.examen.part1.GestionIngredient.IngredientDAO;
import hba.examen.part1.GestionIngredient.IngredientDAOIMLP;
import hba.examen.part1.GestionPlat.PlatPrincipal;
import hba.examen.part1.GestionPlat.PlatPrincipalDAO;
import hba.examen.part1.GestionPlat.PlatPrincipalDAOIMPL;
import hba.examen.part1.GestionSupplement.Supplement;
import hba.examen.part1.GestionSupplement.SupplementDAO;
import hba.examen.part1.GestionSupplement.SupplementDAOIMPL;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        IngredientDAO ingredDAO=new IngredientDAOIMLP();
        SupplementDAO supplDao=new SupplementDAOIMPL();
        PlatPrincipalDAO platDao=new PlatPrincipalDAOIMPL();
        Data data = Data.getInstance();
        Client client = data.getClient("baba", "baba");

        System.out.println("Bienvenue "+client.getNom());

        // Supplements Repas 1
        List<Supplement> supplements1 = new ArrayList<>();
        Supplement supplement1 = supplDao.getOne("01");
        Supplement supplement2 = supplDao.getOne("02");
        supplements1.add(supplement1);
        supplements1.add(supplement2);
        // Supplements Repas 2
        List<Supplement> supplements2 = new ArrayList<>();
        Supplement supplement21 = supplDao.getOne("03");
        Supplement supplement22 = supplDao.getOne("04");
        supplements2.add(supplement21);
        supplements2.add(supplement22);
        // Ingredients Repas 1
        List<IngredientPlat> ingredients1 = new ArrayList<>();
        IngredientPlat ingredient1 = new IngredientPlat(250, ingredDAO.getOne("01"), null);
        IngredientPlat ingredient2 = new IngredientPlat(1, ingredDAO.getOne("04"), null);
        ingredients1.add(ingredient1);
        ingredients1.add(ingredient2);
        // Ingredients Repas 2
        List<IngredientPlat> ingredients2 = new ArrayList<>();
        IngredientPlat ingredient21 = new IngredientPlat(250, ingredDAO.getOne("03"), null);
        IngredientPlat ingredient22 = new IngredientPlat(1, ingredDAO.getOne("05"), null);
        IngredientPlat ingredient23 = new IngredientPlat(1, ingredDAO.getOne("06"), null);
        IngredientPlat ingredient24 = new IngredientPlat(1, ingredDAO.getOne("07"), null);
        ingredients2.add(ingredient21);
        ingredients2.add(ingredient22);
        ingredients2.add(ingredient23);
        ingredients2.add(ingredient24);
        // Plat 1
        PlatPrincipal platPrincipal1 = new PlatPrincipal("01", "Tajine de viande & pruneau");
        platPrincipal1.setIngredientPlats(ingredients1);
        // Plat 2
        PlatPrincipal platPrincipal2 = new PlatPrincipal("02", "Tajine de poulet & légumes");
        platPrincipal2.setIngredientPlats(ingredients2);
        // Repas
        List<Repas> repas = new ArrayList<>();
        Repas repas1 = new Repas(1);
        Repas repas2 = new Repas(2);
        // affect au repas
        repas1.setPlatPrincipal(platPrincipal1);
        repas1.setSupplements(supplements1);

        repas2.setPlatPrincipal(platPrincipal2);
        repas2.setSupplements(supplements2);

        repas.add(repas1);
        repas.add(repas2);
        // Command
        List<Command> commands = new ArrayList<>();
        Command command1 = new Command(1);
        command1.setRepas(repas);
        commands.add( new Command(1) );
        // Affect command au client
        client.setCommands(commands);

        /// Calculer les totals
        platPrincipal1.calculerTotal();
        platPrincipal2.calculerTotal();
        repas1.calculerTotal();
        repas2.calculerTotal();
        command1.calculerTotal();


        /// Affichage de données
        System.out.println("--------------------------------------");
        System.out.println("----------------TICKET----------------");
        System.out.println("Nom: " + client);

        System.out.println("nombre de repas : " + command1.getRepas().size());
        command1.getRepas().forEach(repasCmd -> {
            System.out.println(repasCmd);
            System.out.println("Ingrédients :");
            repasCmd.getPlatPrincipal().getIngredientPlats().forEach(ingplat -> {
                System.out.println(ingplat);
            });
            System.out.println("Suppléments :");
            repasCmd.getSupplements().forEach(suppl -> {
                System.out.println(suppl);
            });
            System.out.println("******** Sous Total : " + repasCmd.getTotal());
        });
        System.out.println("------------------------ Total : " + command1.getTotal());
        System.out.println("--------------------------------------");
    }
}
