package util;
import java.util.Scanner;

import rationnel.RationnelSimple;
import types.*;
public class Client {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    Rationnel precedent = new RationnelSimple(0); // start from 0
	    Rationnel courant;

	    
	    while (true) 
	    {
	        courant = lireRationnel(sc);
	        
	        if(courant.getNumerateur() == 0) {break;}//check if we need to end the loop
	        
	        String cmp;
	        if(courant.equals(precedent)) {cmp = "==";}
	        else {cmp = "!=";}
	        
            String sup;
            int comparaison = courant.compareTo(precedent);
	        if(comparaison == -1) {sup = "<";}
	        else if(comparaison == 0) {sup = "==";}
	        else {sup = ">";}
	        
            System.out.print("courant = " + courant);
            System.out.print(" ; " + courant + " + " + precedent + " = " + courant.somme(precedent));

            if (courant.getNumerateur() != 0) {
                System.out.print(" ; inverse = " + courant.inverse());
            } else {
                System.out.print(" ; inverse = undefined");
            }

            System.out.print(" ; valeur = " + courant.valeur());
            System.out.print(" ; " + courant + " " + sup + " " + precedent);
            System.out.println(" ; " + courant + " " + cmp + " " + precedent);
            
	        precedent = courant;
	    
	    }
		
	}

	
	
	
	static Rationnel lireRationnel(Scanner input) {
	    System.out.print("Enter numerator: ");
	    int num = input.nextInt();

	    int den;
	    do {
	        System.out.print("Enter denominator (non-zero): ");
	        den = input.nextInt();
	        if (den == 0)
	            System.out.println("Denominator cannot be zero. Try again.");
	    } while (den == 0);

	    return new RationnelSimple(num, den);
	}

}
