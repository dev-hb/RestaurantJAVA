package hba.examen.part1.GestionCommand;

import hba.examen.part1.DatabaseConnection.DataConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class IngredientPlatDAOIMPL implements IngredientPlatDAO {
    private DataConnection dc;
    PreparedStatement pstm;

    public IngredientPlatDAOIMPL() {
        dc = DataConnection.getConnection();
    }

    @Override
    public void insert(List<IngredientPlat> ingredientPlatList) {
        ingredientPlatList.forEach(ingredientPlat -> {
            try {
                String query = "INSERT INTO ingredients (nom, prix, qte,id_cmd) VALUES(?,?,?,?)";
                pstm = dc.conn.prepareStatement(query);
                pstm.setString(1, ingredientPlat.getIngredient().getNom());
                pstm.setDouble(2, ingredientPlat.getIngredient().getPrixUnitaire());
                pstm.setInt(3, ingredientPlat.getQuantite());
                pstm.setLong(4, ingredientPlat.getPlatPrincipal().getCommand().getId());
                pstm.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
