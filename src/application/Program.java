package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.ProdutosDao;
import model.entities.Produtos;

public class Program  {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		ProdutosDao produtosDao = DaoFactory.createProdutosDao();
		
		
		System.out.println("==========Teste1===========");
		Produtos produtos = produtosDao.findById(1);
		System.out.println(produtos);
	
		
		
		
		

		
		System.out.println("\n=== TEST 4: seller insert =====");
		Produtos newprod = new Produtos(0, "porca", "peca", 10, 8.00, 16.00);
		produtosDao.insert(newprod);
		System.out.println("Inserted! New id = " + newprod.getId());
	
		System.out.println("\n=== TEST 5: seller update =====");
		produtos = produtosDao.findById(3);
		produtos.setDescricao("carro");
		produtosDao.update(produtos);
		System.out.println("Update completed");
		
		
		System.out.println("\n=== TEST 6: seller delete =====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		produtosDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
