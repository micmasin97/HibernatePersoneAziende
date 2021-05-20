package it.advancia.michele.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import it.advancia.michele.entity.Azienda;
import it.advancia.michele.entity.Indirizzo;
import it.advancia.michele.entity.Persona;
import it.advancia.michele.entity.PersonaAssunta;
import it.advancia.michele.entity.VisitatoreEsterno;

public class EntityDao
{
	private static SessionFactory sF;

	private static Session getSession()
	{
		if(sF==null)
			sF=new Configuration().configure().buildSessionFactory();
		return sF.openSession();
	}
	
	public static Persona searchPersona(String cf)
	{
		Session session = getSession();
		Persona persona = session.get(Persona.class, cf);
		session.close();
		return persona;
	}
	
	public static Azienda searchAzienda(long id)
	{
		Session session = getSession();
		Azienda azienda = session.get(Azienda.class, id);
		session.close();
		return azienda;
	}
	
	public static void inserisciPersona(Persona p, long id)
	{
		try
		{
			Session session = getSession();
			session.beginTransaction();
			if(p.getClass().getSimpleName().equals("PersonaAssunta"))
			{
				Azienda azienda = session.get(Azienda.class, id);
				PersonaAssunta dipendente = (PersonaAssunta) p;
				dipendente.setAzienda(azienda);
				azienda.getListaPersonale().add(dipendente);
				session.persist(dipendente);
			}
			else
			{
				VisitatoreEsterno visitatore=(VisitatoreEsterno) p;
				session.persist(visitatore);
			}
			session.getTransaction().commit();
			session.close();
		}
		catch(NullPointerException e)
		{
			System.out.println("Azienda non disponibile");
			throw e;
		}
	}
	
	public static List<Persona> showPersone()
	{
		Session session = getSession();
		Query query= session.createQuery("from Persona");
		List<Persona> persone= query.list();
		return persone;
	}
	
	public static void modificaPersona(Persona persona)
	{
		Session session = getSession();
		session.getTransaction().begin();
		if(persona.getClass().getSimpleName().equals("PersonaAssunta"))
		{
			PersonaAssunta dipendente = (PersonaAssunta) persona;
			Query query = session.createQuery("update Persona set nome= :nome, cognome=: cognome, stipendio=:stipendio where codiceFiscale= :codiceFiscale");
			query.setParameter("nome", dipendente.getNome());
			query.setParameter("cognome", dipendente.getCognome());
			query.setParameter("stipendio", dipendente.getStipendio());
			query.setParameter("codiceFiscale", dipendente.getCodiceFiscale());
			int result=query.executeUpdate();
		}
		else
		{
			VisitatoreEsterno visitatore=(VisitatoreEsterno) persona;
			Query query = session.createQuery("update Persona set nome= :nome, cognome=: cognome where codiceFiscale= :codiceFiscale");
			query.setParameter("nome", visitatore.getNome());
			query.setParameter("cognome", visitatore.getCognome());
			query.setParameter("codiceFiscale", visitatore.getCodiceFiscale());
			int result=query.executeUpdate();
			System.out.println(result);
		}
		session.getTransaction().commit();
		session.close();
	}
}
