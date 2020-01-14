package hba.examen.part1.GestionCommand;

import hba.examen.part1.DatabaseConnection.DataConnection;

import java.sql.PreparedStatement;

public class CommandDAOIMPL implements CommandDAO {
    private DataConnection dc;
    PreparedStatement pstm;

    public CommandDAOIMPL() {
        dc = DataConnection.getConnection();
    }

    @Override
    public void insert(Command command) {
        try{
            String query = "INSERT INTO command (date, total) VALUES(CURRENT_TIMESTAMP , ?)";
            pstm = dc.conn.prepareStatement(query);
            pstm.setDouble(1, command.getTotal());
            pstm.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
