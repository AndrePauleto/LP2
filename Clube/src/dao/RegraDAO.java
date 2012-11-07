package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

import es2.atividade2.model.DiasDaSemana;
import es2.atividade2.model.Regra;

public class RegraDAO extends DAO<es2.atividade2.model.Regra>{
	
	int ultimoId;
	
	public RegraDAO() {
		super();
        INSERT = "INSERT INTO \"Regra\"(\"nomeCartao\", \"horaInicial\", \"horaFinal\", \"numeroAcessoDia\", valor, \"diasDaSemana_id\") VALUES(?,?,?,?,?,?)";
        SELECT = "SELECT * FROM \"Regra\"";
        SELECT_ID = "SELECT * FROM \"Regra\" WHERE id_regra = ?";
        UPDATE = "UPDATE \"Regra\" SET \"nomeCartao\" = ?, \"horaInicial\" = ?, \"horaFinal\" = ?, \"numeroAcessoDia\" = ?, valor = ?, \"diasDaSemana_id\" = ? WHERE id_regra = ?";
        DELETE = "DELETE FROM \"Regra\"  WHERE id_regra = ?";
	}

	@Override
	public boolean insert(Regra u) {
		try {
			ResultSet rs;
			PS_INSERT.setString(1, u.getNomeCartao());
			PS_INSERT.setString(2, u.getHoraInicial());
			PS_INSERT.setString(3, u.getHoraFinal());
			PS_INSERT.setString(4, u.getNumeroAcessoDia());
			PS_INSERT.setDouble(5, u.getValor());
			PS_INSERT.setInt(6, u.getDiasDaSemana().getId());
			PS_INSERT.executeUpdate();
			
			rs = PS_INSERT.getGeneratedKeys();
			while (rs.next()) {
					ultimoId = rs.getInt(1);
            } 
            rs.close();
			
			PS_INSERT.clearParameters();			
		} catch (SQLException e) {
            throw new RuntimeException("Erro no INSERT Regra Erro! "
                    + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean update(Regra u) {
		try{
			PS_UPDATE.setString(1, u.getNomeCartao());
			PS_UPDATE.setString(2, u.getHoraInicial());
			PS_UPDATE.setString(3, u.getHoraFinal());
			PS_UPDATE.setString(4, u.getNumeroAcessoDia());
			PS_UPDATE.setDouble(5, u.getValor());
			PS_UPDATE.setInt(6, u.getDiasDaSemana().getId());
			PS_UPDATE.setInt(7, u.getId());			   		
    		PS_UPDATE.executeUpdate();
    		PS_UPDATE.clearParameters();
        } catch (SQLException e) {
            throw new RuntimeException("Erro no UPDATE Regra Erro! "
                    + e.getMessage());
    	}
    	return true;
	}

	@Override
	public Collection<Regra> select() {
        Collection<Regra> regra = new HashSet<Regra>();
        ResultSet rs;
    	
    	try{
    		rs = PS_SELECT.executeQuery();
    		while (rs.next()) {   
    			
    			regra.add(new Regra(rs.getInt("id_regra"), rs.getString("nomeCartao"), rs.getString("horaInicial"), rs.getString("horaFinal"), getObjetoDiaDaSemana(rs.getInt("diasDaSemana_id")), rs.getString("numeroAcessoDia"), rs.getDouble("valor")));
            }
    		rs.close();
    	}catch (SQLException e) {
            throw new RuntimeException("Erro no SELECT Regra Erro! "
                    + e.getMessage());
        }
    	
        return regra;
	}

	private DiasDaSemana getObjetoDiaDaSemana(int id) {
		DiasDaSemanaDAO diasDaSemana = new DiasDaSemanaDAO();
		diasDaSemana.conectar();
		DiasDaSemana n = diasDaSemana.select(id);
		diasDaSemana.desconectar();		
		return n;
	}

	@Override
	public boolean delete(Regra u) {
    	try{
    		PS_DELETE.setInt(1, u.getId());
    		PS_DELETE.executeUpdate();
    		PS_DELETE.clearParameters();
    	}catch (SQLException e) {
            throw new RuntimeException("Erro no DELETE Regra Erro! "
                    + e.getMessage());
    	}
    	return true;  
	}

	@Override
	public Regra select(int id) {
		Regra regra = null;
        ResultSet rs;

        try {
            PS_SELECT_ID.setInt(1, id);
            rs = PS_SELECT_ID.executeQuery();
            rs.next();
            regra = new Regra(rs.getInt("id_regra"), rs.getString("nomeCartao"), rs.getString("horaInicial"), rs.getString("horaFinal"), getObjetoDiaDaSemana(rs.getInt("diasDaSemana_id")), rs.getString("numeroAcessoDia"), rs.getDouble("valor"));
                        
        } catch (SQLException e) {
            throw new RuntimeException("Erro no SELECT_ID Regra Erro! "
                    + e.getMessage());
        }

        return regra;
	}
	
	public int getUltimoId(){
		return ultimoId;
	}

}
