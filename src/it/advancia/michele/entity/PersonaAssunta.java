package it.advancia.michele.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PersonaAssunta extends Persona
{
	private int stipendio;
	@ManyToOne
	@JoinColumn(name="codice_azienda")
	private Azienda azienda;

	public int getStipendio()
	{
		return stipendio;
	}

	public void setStipendio(int stipendio)
	{
		this.stipendio = stipendio;
	}
}
