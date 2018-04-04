package it.mauriziocozzetto.punti;

public class Expr extends Thread {
	private Punto p;
	private Punto q;
	private float c;
	private Punto r;
	
	public Expr(Punto p, Punto q) {
		this.p = p;
		this.q = q;
		this.c = 1;
	}
	
	public Expr(Punto p, Punto q, float c) {
		this.p = p;
		this.q = q;
		this.c = c;
	}
	
	@Override
	public void run() {
		r = p.prodotto(q).prodotto(c);
	}
	
	public Punto getR() {
		return r;
	}

}
