package model.dao;

import java.util.List;


import model.entities.Produtos;

public interface ProdutosDao {

	void insert(Produtos prod);
	void update(Produtos prod);
	void deleteById(Integer id);
	Produtos findById(Integer id);
	List<Produtos> findAll();
	
	

}