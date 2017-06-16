package it.uniroma3.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQuery(name= "findAllOperas",query="SELECT o FROM Opera o")
public class Opera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min=1)
	private String titolo;
	
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date anno;
	
	@NotNull
	@Size(min=1)
	private String tecnica;
	
	@NotNull
	private Integer dimensioni;
	
	@ManyToOne
	private Autore autore;
	
	public Opera(){}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public Date getAnno() {
		return this.anno;
	}
	
	public void setAnno(Date anno) {
		this.anno = anno;
	}
	
	public String getTecnica() {
		return tecnica;
	}
	
	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}
	
	public Integer getDimensioni() {
		return dimensioni;
	}
	
	public void setDimensioni(Integer dimensioni) {
		this.dimensioni = dimensioni;
	}
	
	public Autore getAutore() {
		return autore;
	}
	
	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	
}
