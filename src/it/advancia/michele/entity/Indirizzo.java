package it.advancia.michele.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Indirizzo
{
		private String regione;
		private String citt�;
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
		
		public String getCitt�()
		{
			return citt�;
		}
		
		public void setCitt�(String citt�)
		{
			this.citt� = citt�;
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
