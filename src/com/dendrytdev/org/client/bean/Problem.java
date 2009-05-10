package com.dendrytdev.org.client.bean;

import java.util.Date;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Problem implements IsSerializable{
	private String Produkt;
	private String imieZglaszajacego;
	private String nazwiskoZglaszajacego;
	private String telefonZglaszajacego;
	private String wagaKlienta;
	private Date dataZgloszenia;
	
	private String serwisant;
	private String projektant;
	private String programista;
	private String tester;
	
	private String opis;

	public String getProdukt() {
		return Produkt;
	}

	public void setProdukt(String produkt) {
		Produkt = produkt;
	}

	public String getImieZglaszajacego() {
		return imieZglaszajacego;
	}

	public void setImieZglaszajacego(String imieZglaszajacego) {
		this.imieZglaszajacego = imieZglaszajacego;
	}

	public String getNazwiskoZglaszajacego() {
		return nazwiskoZglaszajacego;
	}

	public void setNazwiskoZglaszajacego(String nazwiskoZglaszajacego) {
		this.nazwiskoZglaszajacego = nazwiskoZglaszajacego;
	}

	public String getTelefonZglaszajacego() {
		return telefonZglaszajacego;
	}

	public void setTelefonZglaszajacego(String telefonZglaszajacego) {
		this.telefonZglaszajacego = telefonZglaszajacego;
	}

	public String getWagaKlienta() {
		return wagaKlienta;
	}

	public void setWagaKlienta(String wagaKlienta) {
		this.wagaKlienta = wagaKlienta;
	}

	public Date getDataZgloszenia() {
		return dataZgloszenia;
	}

	public void setDataZgloszenia(Date dataZgloszenia) {
		this.dataZgloszenia = dataZgloszenia;
	}

	public String getSerwisant() {
		return serwisant;
	}

	public void setSerwisant(String serwisant) {
		this.serwisant = serwisant;
	}

	public String getProjektant() {
		return projektant;
	}

	public void setProjektant(String projektant) {
		this.projektant = projektant;
	}

	public String getProgramista() {
		return programista;
	}

	public void setProgramista(String programista) {
		this.programista = programista;
	}

	public String getTester() {
		return tester;
	}

	public void setTester(String tester) {
		this.tester = tester;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(Produkt).append(" - ").append(imieZglaszajacego);
		sb.append(" ").append(nazwiskoZglaszajacego);
		sb.append(opis);
		return sb.toString();	
	}

}
