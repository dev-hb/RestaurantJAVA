package hba.examen.part1.Views;

import hba.examen.part1.GestionCommand.IngredientPlat;
import hba.examen.part1.GestionIngredient.IngredientDAOIMLP;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainIHM extends Application {
    Pane root = new Pane();;
    Scene scene = new Scene(root, 800, 600);

    Button btnTajineViande, btnTajinePoulet, btnTajinePoisson, btnFriturePoisson,
            btnPizza, btnCouscous;
    GridPane grid;

    public void init(){
        // init central
        grid = new GridPane();
        // init buttons
        btnTajineViande = new Button("Tajine de viande & Pruneaux");
        btnTajinePoulet = new Button("Tajine de poulet & Légumes");
        btnTajinePoisson = new Button("Tajine de poisson");
        btnPizza = new Button("Pizza");
        btnCouscous = new Button("Couscous");
        btnFriturePoisson = new Button("Friture de poisson");
    }

    public void draw(){
        // add buttons to grid
        grid.add(btnTajineViande, 0, 0);
        grid.add(btnTajinePoulet, 1, 0);
        grid.add(btnTajinePoisson, 0, 1);
        grid.add(btnFriturePoisson, 1, 1);
        grid.add(btnPizza, 0, 2);
        grid.add(btnCouscous, 1, 2);
        grid.setHgap(5);
        grid.setVgap(5);
        // add styles to buttons
        grid.getChildren().forEach(btn -> {
            btn.getStyleClass().add("main_buttons");
            btn.prefWidth(100);
        });
        // add grid to root pane
        root.getChildren().add(grid);
    }

    public void actions(Stage window){
        grid.getChildren().forEach(btn -> {
            btn.setOnMouseClicked(e -> {
                PlatIHM platIHM = new PlatIHM();
                try {
                    platIHM.start(window);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        });
    }

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Restaurant en ligne");
        window.setScene(scene);

        scene.getStylesheets().add("style.css");

        init();
        draw();
        actions(window);

        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
