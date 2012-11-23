package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

import es2.atividade2.model.Cartao;
import es2.atividade2.model.Regra;

/**
 * 
 * @author 181000711
 * 
 */
public class CartaoDAO extends DAO<es2.atividade2.model.Cartao> {

	int ultimoId;

	public CartaoDAO() {
		super();
		INSERT = "INSERT INTO \"Cartao\"(matricula, acessando, regra_id) VALUES(?,?,?)";
		SELECT = "SELECT * FROM \"Cartao\"";
		SELECT_ID = "SELECT * FROM \"Cartao\" WHERE id_cartao = ?";
		UPDATE = "UPDATE \"Cartao\" SET matricula = ?, acessando = ?, regra_id = ? WHERE id_cartao = ?";
		DELETE = "DELETE FROM \"Cartao\"  WHERE id_cartao = ?";
	}

	@Override
	public boolean insert(Cartao u) {
		try {
			ResultSet rs;
			PS_INSERT.setString(1, u.getMatricula());
			PS_INSERT.setBoolean(2, u.isAcessando());
			PS_INSERT.setInt(3, u.getRegra().getId());
			PS_INSERT.executeUpdate();

			rs = PS_INSERT.getGeneratedKeys();
			while (rs.next()) {
				ultimoId = rs.getInt(1);
			}
			rs.close();

			PS_INSERT.clearParameters();
		} catch (SQLException e) {
			throw new RuntimeException("Erro no INSERT Cartao Erro! "
					+ e.getMessage());
		}
		return false;
	}

	@Override
	public boolean update(Cartao u) {
		try {
			PS_UPDATE.setString(1, u.getMatricula());
			PS_UPDATE.setBoolean(2, u.isAcessando());
			PS_UPDATE.setInt(3, u.getRegra().getId());
			PS_UPDATE.setInt(4, u.getId());
			PS_UPDATE.executeUpdate();
			PS_UPDATE.clearParameters();
		} catch (SQLException e) {
			throw new RuntimeException("Erro no UPDATE Cartao Erro! "
					+ e.getMessage());
		}
		return true;
	}

	@Override
	public Collection<Cartao> select() {
		Collection<Cartao> cartao = new HashSet<Cartao>();
		ResultSet rs;

		try {
			rs = PS_SELECT.executeQuery();
			while (rs.next()) {
				cartao.add(new Cartao(rs.getInt("id_cartao"), rs
						.getString("matricula"), (Regra) getObjetoRegra(rs
						.getInt("regra_id")), rs.getBoolean("acessando")));
			}
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException("Erro no SELECT Cartao Erro! "
					+ e.getMessage());
		}

		return cartao;
	}

	private Object getObjetoRegra(int id) {
		RegraDAO regraDAO = new RegraDAO();
		regraDAO.conectar();
		Regra n = regraDAO.select(id);
		regraDAO.desconectar();
		return n;
	}

	@Override
	public boolean delete(Cartao u) {
		try {
			PS_DELETE.setInt(1, u.getId());
			PS_DELETE.executeUpdate();
			PS_DELETE.clearParameters();
		} catch (SQLException e) {
			throw new RuntimeException("Erro no DELETE Cartao Erro! "
					+ e.getMessage());
		}
		return true;
	}

	@Override
	public Cartao select(int id) {
		Cartao cartao = null;
		ResultSet rs;

		try {
			PS_SELECT_ID.setInt(1, id);
			rs = PS_SELECT_ID.executeQuery();
			rs.next();
			cartao = new Cartao(rs.getInt("id_cartao"),
					rs.getString("matricula"),
					(Regra) getObjetoRegra(rs.getInt("regra_id")),
					rs.getBoolean("acessando"));

		} catch (SQLException e) {
			throw new RuntimeException("Erro no SELECT_ID Cartao Erro! "
					+ e.getMessage());
		}

		return cartao;
	}

	public int getUltimoId() {
		return ultimoId;
	}

}
