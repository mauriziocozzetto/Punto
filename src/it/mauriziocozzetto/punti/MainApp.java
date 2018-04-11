package it.mauriziocozzetto.punti;

public class MainApp {

	public static void main(String[] args) throws InterruptedException {
		Punto p1 = new Punto(1, 2);
		Punto p2 = new Punto(3, 4);
		Punto p3 = new Punto(5, 6);
		
		Expr expr1 = new Expr(p1, p2);
		Expr expr2 = new Expr(p1, p3, 2);
		Expr expr3 = new Expr(p2, p3);
		
		expr1.start();
		expr2.start();
		expr3.start();
		
		expr1.join();
		expr2.join();
		expr3.join();
		
		Punto r = expr1.getR().somma(expr2.getR()).somma(expr3.getR());
		//System.out.println(r.toString());
		r.out();
	}
}
