package it.mauriziocozzetto.punti;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Punto implements Serializable {
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

	public boolean appartieneAsseY(){
		return x == 0;
	}

	public String descrizione(){
		return "Punto = (" + x + "; " + y + ")";
	}

	// Metodo non richiesto, mi serve solo come prova
	public void in() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci x e y: ");
		this.x = Float.parseFloat(sc.next());
		this.y = Float.parseFloat(sc.next());
		sc.close();
	}

	public void scrivi() {
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File("Punto.txt")));
			outputStream.writeObject(this);
			outputStream.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Metodo non richiesto
	public void out() {
		System.out.println(this);
	}
	
	public Punto simmetricoRispettoAsseX() {
		return new Punto(this.x, -this.y);
	}

	private static final float[][] quadranti = {{1.0f, 1.0f}, {-1.0f, 1.0f}, {-1.0f, -1.0f}, {1.0f, -1.0f}};

	private boolean evaluateSector(float[] multiplier){
		return (this.x*multiplier[0] > 0 && this.y*multiplier[1] > 0);
	}

	public boolean appartienePrimoQuadrante(){
		return evaluateSector(quadranti[0]);
	}

	public boolean appartieneSecondoQuadrante(){
		return evaluateSector(quadranti[1]);
	}

	public boolean appartieneTerzoQuadrante(){
		return evaluateSector(quadranti[2]);
	}

	public boolean appartieneQuartoQuadrante(){
		return evaluateSector(quadranti[3]);
	}
}
