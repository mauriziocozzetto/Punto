package it.mauriziocozzetto.punti;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;


public class Punto implements Serializable {
    private float x;
    private float y;

    public Punto(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Punto somma(Punto p) {
        return new Punto(this.x + p.x, this.y + p.y);
    }

    public Punto prodotto(Punto p) {
        return new Punto(this.x * p.x - this.y * p.y, this.x * p.y + this.y * p.x);
    }

    public Punto prodotto(float c) {
        return new Punto(this.x * c, this.y * c);
    }

    public String descrizione() {
        return "Punto = (" + x + "; " + y + ")";
    }

    public void out() {
        System.out.println(this);
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

    public void leggi() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci x e y: ");
        this.x = Float.parseFloat(sc.next());
        this.y = Float.parseFloat(sc.next());
        sc.close();
    }

    private static final float[][] quadranti = {{1.0f, 1.0f}, {-1.0f, 1.0f}, {-1.0f, -1.0f}, {1.0f, -1.0f}};

    private boolean evaluateSector(float[] multiplier) {
        return (this.x * multiplier[0] > 0 && this.y * multiplier[1] > 0);
    }

    public boolean appartienePrimoQuadrante() {
        return evaluateSector(quadranti[0]);
    }

    public boolean appartieneSecondoQuadrante() {
        return evaluateSector(quadranti[1]);
    }

    public boolean appartieneTerzoQuadrante() {
        return evaluateSector(quadranti[2]);
    }

    public boolean appartieneQuartoQuadrante() {
        return evaluateSector(quadranti[3]);
    }

    public boolean appartieneAsseY() {
        return x == 0;
    }

    public Punto simmetricoRispettoAsseX() {
        return new Punto(this.x, -this.y);
    }

public Punto simmetricoRispettoOrigine(){
		return new Punto(-this.x, -this.y);
	}
	
	public Punto simmetricoRispettoAsseX() {
		return new Punto(this.x, -this.y);
	}


	public Punto simmetricoRispettoAsseY() {
		return new Punto(-this.x, this.y);
	}

    public static double distanza2(Punto p, Punto q) {
        double dist = Math.sqrt((q.x * q.x) - (p.x * p.x)) + Math.sqrt((q.y * q.y) - (p.y * p.y));
        return dist;
    }
public double distanza(Punto p){
		double distanza;
		return distanza = Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
	}
