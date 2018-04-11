package it.mauriziocozzetto.punti;

import java.util.Scanner;

public class Punto {
	private float x;
	private float y;
	
	// Costruttore con due argomenti
	public Punto(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	// Getter e setter non mi servono neanche, non li metto
	
	// Somma tra due punti (regola del parallelogramma)
	public Punto somma(Punto p) {
		return new Punto(this.x + p.x, this.y + p.y);
	}
	
	// Prodotto tra due punti
	public Punto prodotto(Punto p) {
		return new Punto(this.x*p.x - this.y*p.y, this.x*p.y + this.y*p.x);
	}

	// Prodotto di uno scalare per un punto, sfrutto il polimorfismo e lascio lo stesso nome
	public Punto prodotto(float c) {
		return new Punto(this.x*c, this.y*c);
	}
	
	@Override
	public String toString() {
		return "Punto = (" + x + ", " + y + ")";
	}
	
	// Metodo non richiesto, mi serve solo come prova
	public void in() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci x e y: ");
		this.x = Float.parseFloat(sc.next());
		this.y = Float.parseFloat(sc.next());
		sc.close();
	}
	
	// Metodo non richiesto
	public void out() {
		System.out.println(this);
	}
	
	public Punto simmetricoRispettoAsseX() {
		return new Punto(this.x, -this.y);
	}
    public boolean eUguale (Punto p){
    return this.x==p.x && this.y==p.y;
}
