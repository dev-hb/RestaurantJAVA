package hba.examen.part1.Views;

import hba.examen.part1.Common.PrefAlert;
import hba.examen.part1.GestionCommand.*;
import hba.examen.part1.GestionIngredient.Ingredient;
import hba.examen.part1.GestionIngredient.IngredientDAO;
import hba.examen.part1.GestionIngredient.IngredientDAOIMLP;
import hba.examen.part1.GestionPlat.PlatPrincipal;
import hba.examen.part1.GestionSupplement.Supplement;
import hba.examen.part1.GestionSupplement.SupplementDAO;
import hba.examen.part1.GestionSupplement.SupplementDAOIMPL;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PlatIHM extends Application {
    Pane root = new Pane();
    Scene scene = new Scene(root, 800, 600);

    Label title, subTitleIngredient, getSubTitleSupplements, lblTotal;
    Label lblAddIngredient, lblAddSupplement, lblCodeIng, lblQteIng, lblCodeSup, lblQteSup;
    Button btnAddIng, btnAddSup, btnSave;
    TextField txtCodeIng, txtQteIng, txtCodeSup, txtQteSup, txtTotal;

    TableView<IngredientPlat> tableIngredient;
    TableColumn<IngredientPlat, String> tblIngName;
    TableColumn<IngredientPlat, String> tblIngQte;
    TableColumn<IngredientPlat, Double> tblIngPrice;

    TableView<Supplement> tableSupplement;
    TableColumn<Supplement, String> tblSupName;
    TableColumn<Supplement, Integer> tblSupQte;
    TableColumn<Supplement, Double> tblSupPrice;

    ObservableList<IngredientPlat> listOfIngredients;
    ObservableList<Supplement> listOfSupplements;

    final Pane _blank = new Pane();
    Pane ingredientPane, supplementPane;
    HBox footer, section1, section2;
    VBox rootBox, ingAddBox, supAddBox, ingTableGroup, supTableGroup;
    GridPane ingredientGrid, supplementGrid;

    // init alert box
    PrefAlert alert = new PrefAlert();

    IngredientDAO ingredDAO=new IngredientDAOIMLP();
    SupplementDAO supplDao=new SupplementDAOIMPL();
    CommandDAO cmdDao = new CommandDAOIMPL();
    IngredientPlatDAOIMPL ingplatDao = new IngredientPlatDAOIMPL();

    PlatPrincipal principal = new PlatPrincipal("01", "Plat de Tajine");
    Command command = new Command(1);
    Repas repas = new Repas(1);

    public void init(){
        // init Labels
        title = new Label("Plat de TAJINE");
        subTitleIngredient = new Label("Ingrédients de votre plat");
        getSubTitleSupplements = new Label("Suppléments de votre plat");
        lblTotal = new Label("Total : ");
        lblAddIngredient = new Label("Ajouter un ingrédient");
        lblAddSupplement = new Label("Ajouter un supplément");
        lblCodeIng = new Label("Code : ");
        lblQteIng = new Label("Qte : ");
        lblCodeSup = new Label("Code : ");
        lblQteSup = new Label("Qte : ");
        // init Buttons
        btnAddIng = new Button("Ajouter");
        btnAddSup = new Button("Ajouter");
        btnSave = new Button("Enregistrer");
        // init Text fields
        txtCodeIng = new TextField();
        txtCodeSup = new TextField();
        txtQteIng = new TextField();
        txtQteSup = new TextField();
        txtTotal = new TextField("0");
        // init panes
        rootBox = new VBox();
        ingredientPane = new Pane();
        supplementPane = new Pane();
        ingredientGrid = new GridPane();
        supplementGrid = new GridPane();
        ingAddBox = new VBox();
        supAddBox = new VBox();
        footer = new HBox();
        section1 = new HBox();
        section2 = new HBox();
        ingTableGroup = new VBox();
        supTableGroup = new VBox();
        // init tables and columns
        tableIngredient = new TableView<>();
        tableSupplement = new TableView<>();
        tblIngName = new TableColumn<>("Ingrédient");
        tblIngQte = new TableColumn<>("Quantité");
        tblIngPrice = new TableColumn<>("Prix");
        tblSupName = new TableColumn<>("Supplément");
        tblSupQte = new TableColumn<>("Quantité");
        tblSupPrice = new TableColumn<>("Prix");
        listOfSupplements = FXCollections.observableArrayList();
        listOfIngredients = FXCollections.observableArrayList();
        // command
        repas.setPlatPrincipal(principal);
        principal.setCommand(command);
        List<Repas> repass = new ArrayList<>();
        repass.add(repas);
        command.setRepas(repass);
    }

    public void initTables(){
        // init columns
        tblIngName.setCellValueFactory(new PropertyValueFactory<>("ingname"));
        tblIngQte.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        tblIngPrice.setCellValueFactory(new PropertyValueFactory<>("ingprix"));
        tblSupName.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tblSupQte.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tblSupPrice.setCellValueFactory(new PropertyValueFactory<>("prix"));
        // init data
        tableIngredient.setItems(listOfIngredients);
        tableSupplement.setItems(listOfSupplements);
    }

    public void applyStyles(){
        _blank.setMinSize(10, 1);
        tableIngredient.setPrefHeight(220);
        tableSupplement.setPrefHeight(175);
        tableIngredient.setPrefWidth(490);
        tableSupplement.setPrefWidth(490);
        txtTotal.setDisable(true);
        title.getStyleClass().add("title");
        // sections
        section1.setSpacing(20);
        section2.setSpacing(20);
        section1.setPadding(new Insets(20));
        section2.setPadding(new Insets(20));
        // panes
        ingredientPane.getStyleClass().add("box");
        supplementPane.getStyleClass().add("box");
        // labels
        subTitleIngredient.getStyleClass().add("subtitle");
        getSubTitleSupplements.getStyleClass().add("subtitle");
        lblAddSupplement.getStyleClass().add("boxtitle");
        lblAddIngredient.getStyleClass().add("boxtitle");
        // buttons
        btnAddSup.getStyleClass().add("button");
        btnAddIng.getStyleClass().add("button");
        btnSave.getStyleClass().add("button");
        // footer elements
        btnSave.getStyleClass().add("pull-center");
        txtTotal.getStyleClass().add("pull-center");
        lblTotal.getStyleClass().add("pull-center");
        lblTotal.getStyleClass().add("subtitle");
    }

    public void draw(){
        // Add columns to table ingredients
        tableIngredient.getColumns().addAll(tblIngName, tblIngQte, tblIngPrice);
        // Add columns to table supplement
        tableSupplement.getColumns().addAll(tblSupName, tblSupQte, tblSupPrice);
        // Add elements to ingredients grid
        ingredientGrid.add(lblCodeIng, 0, 0);
        ingredientGrid.add(txtCodeIng, 1, 0);
        ingredientGrid.add(lblQteIng, 0, 1);
        ingredientGrid.add(txtQteIng, 1, 1);
        ingredientGrid.add(btnAddIng, 1,2);
        // Add elements to supplements grid
        supplementGrid.add(lblCodeSup, 0, 0);
        supplementGrid.add(txtCodeSup, 1, 0);
        supplementGrid.add(lblQteSup, 0, 1);
        supplementGrid.add(txtQteSup, 1, 1);
        supplementGrid.add(btnAddSup, 1,2);
        // Add elements to ingredients table group
        ingTableGroup.getChildren().addAll(subTitleIngredient, tableIngredient);
        // Add elements to supplements table group
        supTableGroup.getChildren().addAll(getSubTitleSupplements, tableSupplement);
        // add element to Ingredient Box
        ingAddBox.getChildren().addAll(lblAddIngredient, ingredientGrid);
        ingredientPane.getChildren().add(ingAddBox);
        // draw section 1
        section1.getChildren().addAll(ingredientPane, ingTableGroup);
        // add elements to supplement box
        supAddBox.getChildren().addAll(lblAddSupplement, supplementGrid);
        supplementPane.getChildren().add(supAddBox);
        // draw section 2
        section2.getChildren().addAll(supplementPane, supTableGroup);
        // add footer elements
        footer.setHgrow(_blank, Priority.ALWAYS);
        footer.getChildren().addAll(_blank, btnSave, lblTotal, txtTotal);
        // add elements to root
        rootBox.getChildren().addAll(title, section1, section2, footer);
        root.getChildren().add(rootBox);
    }

    public void actions(Stage window){
        btnAddIng.setOnAction(e -> {
            if(txtCodeIng.getText().equals("") || txtQteIng.getText().equals("")){
                alert.shout("Merci de remplir tous les champs");
            }else{
                IngredientPlat ingredientPlat = new IngredientPlat(Integer.parseInt(txtQteIng.getText()),
                        ingredDAO.getOne(txtCodeIng.getText()), principal);
                listOfIngredients.add(ingredientPlat);
                txtCodeIng.setText("");
                txtQteIng.setText("");
                recalculer();
            }
        });
        btnAddSup.setOnAction(e -> {
            if(txtCodeSup.getText().equals("") || txtQteSup.getText().equals("")){
                alert.shout("Merci de remplir tous les champs");
            }else{
                Supplement supplement = supplDao.getOne(txtCodeSup.getText());
                supplement.setQuantity(Integer.parseInt(txtQteSup.getText()));
                supplement.setCommand(command);
                listOfSupplements.add(supplement);
                txtCodeSup.setText("");
                txtQteSup.setText("");
                recalculer();
            }
        });

        btnSave.setOnAction(e -> {
            if(listOfIngredients.isEmpty()){
                alert.shout("Vous avez aucun ingrédient dans votre plat principal!");
            }else{
                cmdDao.insert(command);
                supplDao.insert(new ArrayList<>(tableSupplement.getItems()));
                ingplatDao.insert(new ArrayList<>(tableIngredient.getItems()));
                alert.shout("Command enregistré avec succès");
            }
        });

        tableIngredient.setOnKeyPressed(key -> {
            if(alert.confirm("Êtes vous sur de supprimer cette ligne?")){
                listOfIngredients.remove(tableIngredient.getSelectionModel().getSelectedItem());
                alert.shout("La ligne est supprimé");
            }
        });

        tableSupplement.setOnKeyPressed(key -> {
            if(alert.confirm("Êtes vous sur de supprimer cette ligne?")){
                listOfSupplements.remove(tableSupplement.getSelectionModel().getSelectedItem());
                alert.shout("La ligne est supprimé");
            }
        });
    }

    public void recalculer(){
        principal.setIngredientPlats(new ArrayList<>(tableIngredient.getItems()));
        repas.setSupplements(new ArrayList<>(tableSupplement.getItems()));
            principal.calculerTotal();
            repas.calculerTotal();
            command.calculerTotal();
        txtTotal.setText(Double.toString(command.getTotal()));
    }

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Restaurant en ligne - Ajouter un plat");
        window.setScene(scene);

        scene.getStylesheets().add("style.css");

        init();
        initTables();
        applyStyles();
        draw();
        actions(window);

        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
