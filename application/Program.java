package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.ProdutosDao;
import model.entities.Produtos;

public class Program {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ProdutosDao produtosDao = DaoFactory.createProdutosDao();

		char n = 's';

		n = 's';
		while (n == 's') {
			System.out.println("CONSULTA DE PRODUTOS: ");
			System.out.println("Digite o codigo do produto para consulta: ");
			int c = sc.nextInt();
			while (produtosDao.findById(c) == null) {
				System.out.println("Produto não encontrado, digite outro código: ");
				c = sc.nextInt();
			}

			Produtos produtos = produtosDao.findById(c);
			System.out.println(produtos);
			System.out.println("Deseja consultar outro produto? s/n: ");
			n = sc.next().charAt(0);

		}

		n = 's';
		while (n == 's') {
			System.out.println("ALTERAÇÃO DE PRODUTOS:");
			System.out.println("Digite o codigo do produto para consulta: ");
			int c = sc.nextInt();
			while (produtosDao.findById(c) == null) {
				System.out.println("Produto não encontrado, digite outro código: ");
				c = sc.nextInt();
			}
			Produtos produtos = produtosDao.findById(c);
			System.out.println("Digite a descrição do produto:");
			String descricao = sc.nextLine();
			sc.nextLine();
			System.out.println("Digite a unidade de medida do produto:");
			String unid = sc.nextLine();
			System.out.println("Digite a quantidade em estoque do produto:");
			int qtd = sc.nextInt();
			System.out.println("Digite o valor de compra do produto:");
			double valorCompra = sc.nextDouble();
			System.out.println("Digite o valor de venda do produto:");
			double valorVenda = sc.nextDouble();

			produtos.setDescricao(descricao);
			produtos.setUnid(unid);
			produtos.setQtd(qtd);
			produtos.setPreccompra(valorCompra);
			produtos.setPrecvenda(valorVenda);
			produtosDao.update(produtos);
			System.out.println("Update completed");
			System.out.println("Deseja alterar outro produto? s/n: ");
			n = sc.next().charAt(0);
		}

		n = 's';
		while (n == 's') {
			System.out.println("DELETAR PRODUTOS:");
			System.out.println("Digite o código do produto a deletar: ");
			int id = sc.nextInt();
			while (produtosDao.findById(id) == null) {
				System.out.println("Produto não encontrado, digite outro código: ");
				id = sc.nextInt();
			}
			produtosDao.deleteById(id);
			System.out.println("Delete completed");
			System.out.println("Deseja deletar outro produto? s/n: ");
			n = sc.next().charAt(0);
		}

		System.out.println("Fim do Programa!");
		sc.close();

	}

}
