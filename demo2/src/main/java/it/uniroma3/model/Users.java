package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Users {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	@Size(min=1)
	@Column (unique=true)
	private String username;
	@NotNull
	@Size(min=1)
	private String cognome;
	@NotNull
	private Integer eta;
	@NotNull
	@Size(min=4)
	private String password;
	private boolean enabled;
	@OneToOne
	private Authorities auth;
	
	public Users(){}
	
	public Users(String username,String cognome,Integer eta,String password,Authorities auth){
		this.username=username;
		this.cognome=cognome;
		this.eta=eta;
		this.password=password;
		this.enabled=true;
		this.auth=auth;
	}

	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public Integer getEta() {
		return eta;
	}
	
	public void setEta(Integer eta) {
		this.eta = eta;
	}
	
	public Authorities getAuth() {
		return auth;
	}
	
	public void setAuth(Authorities auth) {
		this.auth = auth;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean isEnabled() {
		return this.enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
