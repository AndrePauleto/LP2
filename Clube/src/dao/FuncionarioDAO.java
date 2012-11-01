package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

import javax.management.RuntimeErrorException;

import es2.atividade2.model.Funcionario;

public class FuncionarioDAO extends DAO<es2.atividade2.model.Funcionario>{

    public FuncionarioDAO() {
        super();
        INSERT = "INSERT INTO \"Funcionario\"(nome ,morada, idade, login, senha) VALUES(?,?,?,?,?)";
        SELECT = "SELECT * FROM \"Funcionario\"";
        SELECT_ID = "SELECT * FROM \"Funcionario\" WHERE id_funcionario = ?";
        UPDATE = "UPDATE \"Funcionario\" SET nome = ?, morada = ?, idade = ?, login = ?, senha = ? WHERE id_funcionario = ?";
        DELETE = "DELETE FROM \"Funcionario\"  WHERE id_funcionario = ?";
    }    
    
    @Override
    public boolean insert(Funcionario u) {
        try {
            PS_INSERT.setString(1, u.getNome());
            PS_INSERT.setString(2, u.getMorada());
            PS_INSERT.setInt(3, u.getIdade());
            PS_INSERT.setString(4, u.getLogin());
            PS_INSERT.setString(5, u.getSenha());
            PS_INSERT.executeUpdate();
            PS_INSERT.clearParameters();
        } catch (SQLException e) {
            throw new RuntimeException("Erro no INSERT Funcionario Erro! "
                    + e.getMessage());
        }
        return true;
    }
    
    @Override
    public Collection<Funcionario> select(){
        Collection<Funcionario> funcionarios = new HashSet<Funcionario>();
        ResultSet rs;
    	
    	try{
    		rs = PS_SELECT.executeQuery();
    		while (rs.next()) {
    			funcionarios.add(new Funcionario(rs.getInt("id_funcionario"), rs.getString("nome"), rs.getString("morada"), rs.getInt("idade") , rs.getString("login"), rs.getString("senha")));
            }
    		rs.close();
    	}catch (SQLException e) {
            throw new RuntimeException("Erro no SELECT Funcionario Erro! "
                    + e.getMessage());
        }
    	
        return funcionarios;
    }
    
        
    @Override
    public boolean update(Funcionario u){
    	try{
    		PS_UPDATE.setString(1, u.getNome());
    		PS_UPDATE.setString(2, u.getMorada());
    		PS_UPDATE.setInt(3, u.getIdade());
    		PS_UPDATE.setString(4, u.getLogin());
    		PS_UPDATE.setString(5, u.getSenha());
    		PS_UPDATE.setInt(6, u.getId());
    		PS_UPDATE.executeUpdate();
    		PS_UPDATE.clearParameters();
        } catch (SQLException e) {
            throw new RuntimeException("Erro no UPDATE Funcionario Erro! "
                    + e.getMessage());
    	}
    	return true;
    }
    
    @Override
    public boolean delete(Funcionario u){
    	try{
    		PS_DELETE.setInt(1, u.getId());
    		PS_DELETE.executeUpdate();
    		PS_DELETE.clearParameters();
    	}catch (SQLException e) {
            throw new RuntimeException("Erro no DELETE Funcionario Erro! "
                    + e.getMessage());
    	}
    	return true;   	
    }

	@Override
	public Funcionario select(int id) {
		Funcionario funcionarios = null;
        ResultSet rs;

        try {
            PS_SELECT_ID.setInt(1, id);
            rs = PS_SELECT_ID.executeQuery();
            rs.next();
            funcionarios = new Funcionario(rs.getInt("id_funcionario"), rs.getString("nome"), rs.getString("morada"), rs.getInt("idade") , rs.getString("login"), rs.getString("senha"));
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro no SELECT_ID usuario Erro! "
                    + e.getMessage());
        }

        return funcionarios;
		
	}

    
}
