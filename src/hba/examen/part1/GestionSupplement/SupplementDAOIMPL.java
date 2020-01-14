package hba.examen.part1.GestionSupplement;

import hba.examen.part1.Data;
import hba.examen.part1.DatabaseConnection.DataConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SupplementDAOIMPL implements SupplementDAO {
    private DataConnection dc;
    PreparedStatement pstm;
    Map<String, Supplement> supplements;

    public SupplementDAOIMPL(){
        dc = DataConnection.getConnection();
        supplements = Data.getInstance().getDataSupplements();
    }

    @Override
    public Supplement getOne(String code) {
        return supplements.get(code);
    }

    @Override
    public List<Supplement> getAll() {
        List<Supplement> list = new ArrayList<>();
        supplements.forEach((k, supplement) -> {
            list.add(supplement);
        });
        return list;
    }

    @Override
    public void insert(List<Supplement> supplements) {
        supplements.forEach(supplement -> {
            try {
                String query = "INSERT INTO supplement (nom, qte, prix, id_cmd) VALUES(?,?,?,?)";
                pstm = dc.conn.prepareStatement(query);
                pstm.setString(1, supplement.getNom());
                pstm.setInt(2, supplement.getQuantity());
                pstm.setDouble(3, supplement.getPrix());
                pstm.setLong(4, supplement.getCommand().getId());
                pstm.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
