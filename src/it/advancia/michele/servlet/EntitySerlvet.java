package it.advancia.michele.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.advancia.michele.entity.Indirizzo;
import it.advancia.michele.entity.Persona;


@WebServlet("/EntitySerlvet")
public class EntitySerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory sF=new Configuration().configure().buildSessionFactory();
		Session session = sF.openSession();
		Persona persona = new Persona();
		persona.setCodiceFiscale("msnmhl97p25e512j");
		persona.setNome("michele");
		persona.setCognome("masin");
		Indirizzo indirizzo = new Indirizzo();
		indirizzo.setRegione("Veneto");
		indirizzo.setCittà("Villa Bartolomea");
		indirizzo.setVia("Prasara");
		indirizzo.setCivico("10");
		persona.getIndirizzi().add(indirizzo);
		session.beginTransaction();
		session.save(persona);
		session.getTransaction().commit();
		session.close();
		sF.close();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
