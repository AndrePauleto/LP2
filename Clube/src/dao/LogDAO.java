package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashSet;

import es2.atividade2.model.Cartao;
import es2.atividade2.model.Log;
import es2.atividade2.model.Socio;

public class LogDAO extends DAO<es2.atividade2.model.Log>{

	public LogDAO() {
		super();
        INSERT = "INSERT INTO \"Log\"(data, hora, socio_id) VALUES(?,?, ?)";
        SELECT = "SELECT * FROM \"Log\"";
        SELECT_ID = "SELECT * FROM \"Log\" WHERE id_log = ?";
        UPDATE = "";
        DELETE = "";
	}
	
	@Override
	public boolean insert(Log u) {
		try {						
			PS_INSERT.setString(1, u.getData());
			PS_INSERT.setString(2, u.getHora());
			PS_INSERT.setInt(3, u.getSocio().getId());
			PS_INSERT.executeUpdate();
			PS_INSERT.clearParameters();			
		} catch (SQLException e) {
            throw new RuntimeException("Erro no INSERT Log Erro! "
                    + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean update(Log u) {		
		// TODO ver exceção para avisar que não foi implementado
		return false;
	}

	@Override
	public Collection<Log> select() {
        Collection<Log> log = new HashSet<Log>();
        ResultSet rs;
    	
    	try{
    		rs = PS_SELECT.executeQuery();
    		while (rs.next()) {      			
    			log.add(new Log(getObjetoRegra(rs.getInt("socio_id"))));
            }
    		rs.close();
    	}catch (SQLException e) {
            throw new RuntimeException("Erro no SELECT Cartao Erro! "
                    + e.getMessage());
        }
    	
        return log;
	}

	private Socio getObjetoRegra(int id) {
		SocioDAO socioDAO = new SocioDAO();
		socioDAO.conectar();
		Socio n = socioDAO.select(id);
		socioDAO.desconectar();		
		return n;
	}

	@Override
	public boolean delete(Log u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Log select(int id) {
		Log log = null;
        ResultSet rs;

        try {
            PS_SELECT_ID.setInt(1, id);
            rs = PS_SELECT_ID.executeQuery();
            rs.next();
            log = new Log(getObjetoRegra(rs.getInt("socio_id")));
                        
        } catch (SQLException e) {
            throw new RuntimeException("Erro no SELECT_ID Cartao Erro! "
                    + e.getMessage());
        }

        return log;
	}

}
