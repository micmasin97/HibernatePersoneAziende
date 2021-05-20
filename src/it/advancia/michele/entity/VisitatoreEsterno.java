package it.advancia.michele.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ext")
public class VisitatoreEsterno extends Persona
{
	public Date getDataVisita()
	{
		return dataVisita;
	}

	public void setDataVisita(Date dataVisita)
	{
		this.dataVisita = dataVisita;
	}

	private Date dataVisita;
}
