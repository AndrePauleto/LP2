package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

import es2.atividade2.model.DiasDaSemana;

public class DiasDaSemanaDAO extends DAO<es2.atividade2.model.DiasDaSemana> {

	public DiasDaSemanaDAO() {
		super();
		INSERT = "INSERT INTO \"DiasDaSemana\"(monday ,tuesday, wednesday, thursday, friday, saturday, sunday) VALUES(?,?,?,?,?,?,?)";
		SELECT = "SELECT * FROM \"DiasDaSemana\"";
		SELECT_ID = "SELECT * FROM \"DiasDaSemana\" WHERE \"id_diasDaSemana\" = ?";
		UPDATE = "UPDATE \"DiasDaSemana\" SET monday = ?, tuesday = ?, wednesday = ?, thursday = ?, friday = ?, saturday = ?, sunday = ? WHERE \"id_diasDaSemana\" = ?";
		DELETE = "DELETE FROM \"DiasDaSemana\"  WHERE \"id_diasDaSemana\" = ?";
	}

	@Override
	public boolean insert(DiasDaSemana u) {
		try {
			PS_INSERT.setBoolean(1, u.isMonday());
			PS_INSERT.setBoolean(2, u.isTuesday());
			PS_INSERT.setBoolean(3, u.isWednesday());
			PS_INSERT.setBoolean(4, u.isThursday());
			PS_INSERT.setBoolean(5, u.isFriday());
			PS_INSERT.setBoolean(6, u.isSaturday());
			PS_INSERT.setBoolean(7, u.isSunday());
			PS_INSERT.executeUpdate();
			PS_INSERT.clearParameters();
		} catch (SQLException e) {
			throw new RuntimeException("Erro no INSERT DiasDaSemana Erro!"
					+ e.getMessage());
		}
		return true;
	}

	@Override
	public boolean update(DiasDaSemana u) {
		try{
			PS_UPDATE.setBoolean(1, u.isMonday());
			PS_UPDATE.setBoolean(2, u.isTuesday());
			PS_UPDATE.setBoolean(3, u.isWednesday());
			PS_UPDATE.setBoolean(4, u.isThursday());
			PS_UPDATE.setBoolean(5, u.isFriday());
			PS_UPDATE.setBoolean(6, u.isSaturday());
			PS_UPDATE.setBoolean(7, u.isSunday());
			PS_UPDATE.setInt(8, u.getId());    		
    		PS_UPDATE.executeUpdate();
    		PS_UPDATE.clearParameters();
        } catch (SQLException e) {
            throw new RuntimeException("Erro no UPDATE DiasDaSemana Erro! "
                    + e.getMessage());
    	}
    	return true;
	}

	@Override
	public Collection<DiasDaSemana> select() {
        Collection<DiasDaSemana> diasDaSemana = new HashSet<DiasDaSemana>();
        ResultSet rs;
    	
    	try{
    		rs = PS_SELECT.executeQuery();
    		while (rs.next()) {
    			diasDaSemana.add(new DiasDaSemana(rs.getInt("id_diasDaSemana"),rs.getBoolean("monday"), rs.getBoolean("tuesday"), rs.getBoolean("wednesday"), rs.getBoolean("thursday"), rs.getBoolean("friday"), rs.getBoolean("saturday"), rs.getBoolean("sunday")));
            }
    		rs.close();
    	}catch (SQLException e) {
            throw new RuntimeException("Erro no SELECT DiasDaSemana Erro! "
                    + e.getMessage());
        }
    	
        return diasDaSemana;
	}

	@Override
	public boolean delete(DiasDaSemana u) {
    	try{
    		PS_DELETE.setInt(1, u.getId());
    		PS_DELETE.executeUpdate();
    		PS_DELETE.clearParameters();
    	}catch (SQLException e) {
            throw new RuntimeException("Erro no DELETE DiasDaSemana Erro! "
                    + e.getMessage());
    	}
    	return true;  
	}

	@Override
	public DiasDaSemana select(int id) {
		DiasDaSemana diasDaSemana = null;
        ResultSet rs;

        try {
            PS_SELECT_ID.setInt(1, id);
            rs = PS_SELECT_ID.executeQuery();
            rs.next();
            diasDaSemana = new DiasDaSemana(rs.getInt("id_diasDaSemana"), rs.getBoolean("monday"), rs.getBoolean("tuesday"), rs.getBoolean("wednesday"), rs.getBoolean("thursday"), rs.getBoolean("friday"), rs.getBoolean("saturday"), rs.getBoolean("sunday"));
                        
        } catch (SQLException e) {
            throw new RuntimeException("Erro no SELECT_ID DiasDaSemana Erro! "
                    + e.getMessage());
        }

        return diasDaSemana;
	}

}
