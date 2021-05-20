package it.advancia.michele.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Persona
{
	@Id
	private String codiceFiscale;
	private String nome;
	private String cognome;
	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name="Indirizzi_Utenti",
	     joinColumns=@JoinColumn(name="codice_fiscale"))
	private Collection<Indirizzo> Indirizzi= new ArrayList<Indirizzo>();
	@ManyToMany
	@JoinTable(	name="Persona_Auto",
				joinColumns=@JoinColumn(name="codice_fiscale"),
				inverseJoinColumns=@JoinColumn(name="targa"))
	private Collection<Auto> automobili=new ArrayList<Auto>();

	public Collection<Auto> getAutomobili()
	{
		return automobili;
	}

	public void setAutomobili(Collection<Auto> automobili)
	{
		this.automobili = automobili;
	}

	public String getCodiceFiscale()
	{
		return codiceFiscale;
	}
	
	public void setCodiceFiscale(String codiceFiscale)
	{
		this.codiceFiscale = codiceFiscale;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public String getCognome()
	{
		return cognome;
	}
	
	public void setCognome(String cognome)
	{
		this.cognome = cognome;
	}
	
	public Collection<Indirizzo> getIndirizzi()
	{
		return Indirizzi;
	}
	
	public void setIndirizzi(Collection<Indirizzo> indirizzi)
	{
		Indirizzi = indirizzi;
	}
		
}
