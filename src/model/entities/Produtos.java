package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Produtos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String descricao;
	private String unid;
	private int qtd;
	private double preccompra;
	private double precvenda;
	
	public  Produtos() {
		
	}

	public Produtos(int id, String descricao, String unid, int qtd, double preccompra, double precvenda) {
		
		this.id = id;
		this.descricao = descricao;
		this.unid = unid;
		this.qtd = qtd;
		this.preccompra = preccompra;
		this.precvenda = precvenda;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnid() {
		return unid;
	}

	public void setUnid(String unid) {
		this.unid = unid;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public double getPreccompra() {
		return preccompra;
	}

	public void setPreccompra(double preccompra) {
		this.preccompra = preccompra;
	}

	public double getPrecvenda() {
		return precvenda;
	}

	public void setPrecvenda(double precvenda) {
		this.precvenda = precvenda;
	}

	

	


	@Override
	public int hashCode() {
		return Objects.hash(descricao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produtos other = (Produtos) obj;
		return Objects.equals(descricao, other.descricao);
	}

	@Override
	public String toString() {
		return "Produtos [id=" + id + ", descricao=" + descricao + ", unid=" + unid + ", qtd=" + qtd + ", preccompra="
				+ preccompra + ", precvenda=" + precvenda + "]";
	}

	
	
}
