package it.advancia.michele.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Azienda
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codice;
	private String Nome;
	private String cittaSede;
	@OneToMany(mappedBy="azienda",cascade=CascadeType.ALL)
	private Collection<PersonaAssunta> listaPersonale= new ArrayList<PersonaAssunta>();
	public long getCodice()
	{
		return codice;
	}
	public void setCodice(long codice)
	{
		this.codice = codice;
	}
	public String getNome()
	{
		return Nome;
	}
	public void setNome(String nome)
	{
		Nome = nome;
	}
	public String getCittaSede()
	{
		return cittaSede;
	}
	public void setCittaSede(String cittaSede)
	{
		this.cittaSede = cittaSede;
	}
	public Collection<PersonaAssunta> getListaPersonale()
	{
		return listaPersonale;
	}
	public void setListaPersonale(Collection<PersonaAssunta> listaPersonale)
	{
		this.listaPersonale = listaPersonale;
	}
}
