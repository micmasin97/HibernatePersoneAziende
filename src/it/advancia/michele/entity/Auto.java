package it.advancia.michele.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Auto
{
	@Id
	private String targa;
	private String modello;
	@ManyToMany(mappedBy="automobili")
	private Collection<Persona> proprietari= new ArrayList<Persona>();
	public String getTarga()
	{
		return targa;
	}
	public void setTarga(String targa)
	{
		this.targa = targa;
	}
	public String getModello()
	{
		return modello;
	}
	public void setModello(String modello)
	{
		this.modello = modello;
	}
	public Collection<Persona> getProprietari()
	{
		return proprietari;
	}
	public void setProprietari(Collection<Persona> proprietari)
	{
		this.proprietari = proprietari;
	}
}
