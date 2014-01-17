package it.cougar.main;


public class Ricevuta {

	private String nome;
	private float tax;
	private float prezzo;
	private boolean imported;
	private boolean free = false;	
	
	
	public Ricevuta(String nome, float prezzo, boolean imported, boolean free) {
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	public boolean isImported() {
		return imported;
	}
	public void setImported(boolean imported) {
		this.imported = imported;
	}
	public void calcolaTax() {
		
		this.tax = 0.0f;
		
		if (!isFree()) {
			this.tax = (float) (Math.round(((this.prezzo * 10) / 100)*100.0)/100.0);
			
			this.tax = (float) Math.ceil(this.tax / 0.05f) * 0.05f;
		}
		
		if (isImported()) {
			this.tax += (float) (Math.round(((this.prezzo * 5) / 100)*100.0)/100.0);
			this.tax = (float) Math.ceil(this.tax / 0.05f) * 0.05f;
		}
		
		this.prezzo += this.tax;
	}
	
	
	
}
