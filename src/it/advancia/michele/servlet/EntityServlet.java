package it.advancia.michele.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.advancia.michele.dao.EntityDao;
import it.advancia.michele.entity.Azienda;
import it.advancia.michele.entity.Indirizzo;
import it.advancia.michele.entity.PersonaAssunta;
import it.advancia.michele.entity.VisitatoreEsterno;


@WebServlet("/EntityServlet")
public class EntityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SessionFactory sF=new Configuration().configure().buildSessionFactory();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	private Object action(HttpServletRequest request)
	{
		String operation=request.getParameter("submit");
		switch (operation)
		{
		case "searchPersona":
			String cf=(String)request.getParameter("CFSearch");
			return EntityDao.searchPersona(cf);
		case "searchDipendenti":
			long id=Long.parseLong(request.getParameter("idAzienda"));
			return EntityDao.searchAzienda(id);
		case "insertPersona":
			String cF=request.getParameter("CFNew");
			String nome=request.getParameter("nomeNew");
			String cognome=request.getParameter("cognomeNew");
			String ruolo=request.getParameter("ruoloNew");
			if(ruolo.equals("ext"))
			{
				VisitatoreEsterno visitatore= new VisitatoreEsterno();
				visitatore.setCodiceFiscale(cF);
				visitatore.setNome(nome);
				visitatore.setCognome(cognome);
				visitatore.setDataVisita(new Date());
				EntityDao.inserisciPersona(visitatore, 0);
			}
			else
			{
				PersonaAssunta dipendente= new PersonaAssunta();
				dipendente.setCodiceFiscale(cF);
				dipendente.setNome(nome);
				dipendente.setCognome(cognome);
				dipendente.setStipendio(Integer.parseInt(request.getParameter("stipendioNew")));
				id=Long.parseLong(request.getParameter("idAziendaNew"));
				try
				{
					EntityDao.inserisciPersona(dipendente, id);
				}
				catch(NullPointerException e)
				{
					System.out.println("Error");
				}
			}
			break;
		case "updatePersona":
			cF=request.getParameter("CFUpd");
			nome=request.getParameter("nomeUpd");
			cognome=request.getParameter("cognomeUpd");
			ruolo=request.getParameter("ruoloUpd");
			if(ruolo.equals("ext"))
			{
				VisitatoreEsterno visitatore= new VisitatoreEsterno();
				visitatore.setCodiceFiscale(cF);
				visitatore.setNome(nome);
				visitatore.setCognome(cognome);
				EntityDao.modificaPersona(visitatore);
			}
			else
			{
				PersonaAssunta dipendente= new PersonaAssunta();
				dipendente.setCodiceFiscale(cF);
				dipendente.setNome(nome);
				dipendente.setCognome(cognome);
				dipendente.setStipendio(Integer.parseInt(request.getParameter("stipendioNew")));
				EntityDao.modificaPersona(dipendente);
			}
			
		}
		return "";
	}

}
