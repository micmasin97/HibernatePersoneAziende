package it.advancia.michele.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("dip")
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

	public Azienda getAzienda()
	{
		return azienda;
	}

	public void setAzienda(Azienda azienda)
	{
		this.azienda = azienda;
	}

	public void setStipendio(int stipendio)
	{
		this.stipendio = stipendio;
	}
}
