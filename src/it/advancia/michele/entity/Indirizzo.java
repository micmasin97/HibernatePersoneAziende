package it.advancia.michele.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Indirizzo
{
		private String regione;
		private String città;
		private String via;
		private String civico;
		
		public String getRegione()
		{
			return regione;
		}
		
		public void setRegione(String regione)
		{
			this.regione = regione;
		}
		
		public String getCittà()
		{
			return città;
		}
		
		public void setCittà(String città)
		{
			this.città = città;
		}
		
		public String getVia()
		{
			return via;
		}
		
		public void setVia(String via)
		{
			this.via = via;
		}
		
		public String getCivico()
		{
			return civico;
		}
		
		public void setCivico(String civico)
		{
			this.civico = civico;
		}
}
