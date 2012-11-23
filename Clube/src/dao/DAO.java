package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public abstract class DAO<T> {

	protected String driver = "org.postgresql.Driver";
	protected String url = "jdbc:postgresql://localhost/clube";
	protected String user = "postgres";
	protected String psw = "senacrs";
	protected Connection con;
	// TODO: Substituir variaveis de conexão por uma Properties;
	// protected Properties p;
	protected PreparedStatement PS_INSERT = null;
	protected String INSERT;
	protected PreparedStatement PS_SELECT = null;
	protected String SELECT;
	protected PreparedStatement PS_SELECT_ID = null;
	protected String SELECT_ID;
	protected PreparedStatement PS_UPDATE = null;
	protected String UPDATE;
	protected PreparedStatement PS_DELETE = null;
	protected String DELETE;

	public DAO() {
	}

	public Connection conectar() {

		if (con == null) {
			try {

				con = DriverManager.getConnection(url, user, psw);

				PS_INSERT = con.prepareStatement(INSERT,
						Statement.RETURN_GENERATED_KEYS);
				PS_SELECT = con.prepareStatement(SELECT);
				PS_SELECT_ID = con.prepareStatement(SELECT_ID);
				PS_UPDATE = con.prepareStatement(UPDATE);
				PS_DELETE = con.prepareStatement(DELETE);

			} catch (SQLException e) {
				throw new RuntimeException(
						"Sem acesso ao banco de dados! Erro! " + e.getMessage());
			}

		}
		return con;
	}

	public boolean desconectar() {
		try {
			if (PS_INSERT != null)
				PS_INSERT.close();

			if (PS_UPDATE != null)
				PS_UPDATE.close();

			if (PS_SELECT != null)
				PS_SELECT.close();

			if (PS_DELETE != null)
				PS_DELETE.close();

			if (PS_SELECT_ID != null)
				PS_SELECT_ID.close();

			if (con != null)
				con.close();

		} catch (Exception e) {
			throw new RuntimeException("Erro ao fechar conexão Erro! "
					+ e.getMessage());
		}
		return true;
	}

	abstract public boolean insert(T u);

	abstract public boolean update(T u);

	abstract public Collection<T> select();

	abstract public boolean delete(T u);

	abstract public T select(int id);

}
