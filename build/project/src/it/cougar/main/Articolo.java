package it.cougar.main;

public class Articolo {

	private String nome;
	private float prezzo;
	private boolean imported = false;
	private boolean free = false;
	
	public Articolo(String nome, float prezzo, boolean imported, boolean free) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
		this.imported = imported;
		this.free = free;
	}
	
	
	public boolean isFree() {
		return free;
	}


	public void setFree(boolean free) {
		this.free = free;
	}


	public boolean isImported() {
		return imported;
	}


	public void setImported(boolean imported) {
		this.imported = imported;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	
	
}
