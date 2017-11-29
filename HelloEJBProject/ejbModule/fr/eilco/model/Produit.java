package fr.eilco.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="webcatalog", name="produit")
public class Produit implements Serializable {
	
	
	
	public Produit(int id, String nomProduit) {
		super();
		this.id = id;
		this.nomProduit = nomProduit;
	}
	
	public Produit() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	@Column
	private String nomProduit;
	
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id=id;
	}
	
	
}
