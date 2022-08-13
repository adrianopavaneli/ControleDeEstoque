package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.ProdutosDao;
import model.entities.Produtos;

public class ProdutosDaoJDBC implements ProdutosDao {
	
private Connection conn;
	
	public ProdutosDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Produtos prod) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"INSERT INTO produtos " +
				"(descricao, unid, qtd, preccompra, precvenda) " +
				"VALUES " +
				"(?,?,?,?,?)", 
				Statement.RETURN_GENERATED_KEYS);

			st.setString(1, prod.getDescricao());
			st.setString(2, prod.getUnid());
			st.setInt(3, prod.getQtd());
			st.setDouble(4, prod.getPreccompra());
			st.setDouble(5, prod.getPrecvenda());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					prod.setId(id);
				}
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Produtos prod) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"UPDATE produtos " +
				"SET descricao = ? " +
				"WHERE Id = ?");

			st.setString(1, prod.getDescricao());
			st.setInt(2, prod.getId());

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"DELETE FROM produtos WHERE Id = ?");

			st.setInt(1, id);

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}
		
	

	@Override
	public Produtos findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM produtos WHERE Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Produtos prod = new Produtos();
				prod.setId(rs.getInt("Id"));
				prod.setDescricao(rs.getString("descricao"));
				return prod;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Produtos> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM produtos ORDER BY descricao");
			rs = st.executeQuery();

			List<Produtos> list = new ArrayList<>();

			while (rs.next()) {
				Produtos prod = new Produtos();
				prod.setId(rs.getInt("id"));
				prod.setDescricao(rs.getString("descricao"));
				list.add(prod);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}