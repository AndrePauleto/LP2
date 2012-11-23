package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

import es2.atividade2.model.Cartao;
import es2.atividade2.model.Socio;

public class SocioDAO extends DAO<es2.atividade2.model.Socio> {

	public SocioDAO() {
		super();
		INSERT = "INSERT INTO \"Socio\"(nome, morada, idade, cartao_id) VALUES(?,?,?,?)";
		SELECT = "SELECT * FROM \"Socio\"";
		SELECT_ID = "SELECT * FROM \"Socio\" WHERE id_socio = ?";
		UPDATE = "UPDATE \"Socio\" SET nome = ?, morada = ?, idade = ?, cartao_id = ? WHERE id_socio = ?";
		DELETE = "DELETE FROM \"Socio\"  WHERE id_socio = ?";
	}

	@Override
	public boolean insert(Socio u) {
		try {
			PS_INSERT.setString(1, u.getNome());
			PS_INSERT.setString(2, u.getMorada());
			PS_INSERT.setInt(3, u.getIdade());
			PS_INSERT.setInt(4, u.getCartao().getId());
			PS_INSERT.executeUpdate();
			PS_INSERT.clearParameters();
		} catch (SQLException e) {
			throw new RuntimeException("Erro no INSERT Sócio Erro! "
					+ e.getMessage());
		}
		return false;
	}

	@Override
	public boolean update(Socio u) {
		try {
			PS_UPDATE.setString(1, u.getNome());
			PS_UPDATE.setString(2, u.getMorada());
			PS_UPDATE.setInt(3, u.getIdade());
			PS_UPDATE.setInt(4, u.getCartao().getId());
			PS_UPDATE.setInt(5, u.getId());
			PS_UPDATE.executeUpdate();
			PS_UPDATE.clearParameters();
		} catch (SQLException e) {
			throw new RuntimeException("Erro no UPDATE Sócio Erro! "
					+ e.getMessage());
		}
		return true;
	}

	@Override
	public Collection<Socio> select() {
		Collection<Socio> socio = new HashSet<Socio>();
		ResultSet rs;

		try {
			rs = PS_SELECT.executeQuery();
			while (rs.next()) {
				socio.add(new Socio(rs.getInt("id_socio"),
						rs.getString("nome"), rs.getString("morada"), rs
								.getInt("idade"), getObjetoRegra(rs
								.getInt("cartao_id"))));
			}
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException("Erro no SELECT Cartao Erro! "
					+ e.getMessage());
		}

		return socio;
	}

	private Cartao getObjetoRegra(int id) {
		CartaoDAO cartaoDAO = new CartaoDAO();
		cartaoDAO.conectar();
		Cartao n = cartaoDAO.select(id);
		cartaoDAO.desconectar();
		return n;
	}

	@Override
	public boolean delete(Socio u) {
		try {
			PS_DELETE.setInt(1, u.getId());
			PS_DELETE.executeUpdate();
			PS_DELETE.clearParameters();
		} catch (SQLException e) {
			throw new RuntimeException("Erro no DELETE Sócio Erro! "
					+ e.getMessage());
		}
		return true;
	}

	@Override
	public Socio select(int id) {
		Socio socio = null;
		ResultSet rs;

		try {
			PS_SELECT_ID.setInt(1, id);
			rs = PS_SELECT_ID.executeQuery();
			rs.next();
			socio = new Socio(rs.getInt("id_socio"), rs.getString("nome"),
					rs.getString("morada"), rs.getInt("idade"),
					getObjetoRegra(rs.getInt("cartao_id")));

		} catch (SQLException e) {
			throw new RuntimeException("Erro no SELECT_ID Cartao Erro! "
					+ e.getMessage());
		}

		return socio;
	}
}