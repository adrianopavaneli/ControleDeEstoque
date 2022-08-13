package model.dao;

import db.DB;

import model.dao.impl.ProdutosDaoJDBC;

public class DaoFactory {

	public static ProdutosDao createSellerDao() {
		return new ProdutosDaoJDBC(DB.getConnection());
	}
	
	public static ProdutosDao createDepartmentDao() {
		return new ProdutosDaoJDBC(DB.getConnection());
	}
}
