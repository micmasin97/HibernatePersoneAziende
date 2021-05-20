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
}
