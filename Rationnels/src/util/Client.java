package util;
import java.util.Scanner;

import rationnel.RationnelCouple;
import rationnel.RationnelSimple;
import types.*;
public class Client {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    Rationnel precedent = new RationnelCouple(0); // start from 0
	    Rationnel courant;
	    Rationnel[] rationnels = new Rationnel[50]; 
	    int nb = 0; 

	    while (true) {
	        courant = lireRationnel(sc);

	        if (courant.getNumerateur() == 0) { break; } // stop if numerator is 0

	        // insert in sorted order
	        insererRationnel(courant, rationnels, nb);
	        nb++;

	        // display array and sum
	        System.out.println("Tableau trié des rationnels :");
	        afficher(rationnels, nb);
	        System.out.println("Somme des rationnels = " + sommeRationnels(rationnels, nb));

	        // compare with previous rational
	        String cmp = courant.equals(precedent) ? "==" : "!=";
	        int comparaison = courant.compareTo(precedent);
	        String sup = (comparaison == -1) ? "<" : (comparaison == 0) ? "==" : ">";

	        // print current info
	        System.out.print("courant = " + courant);
	        System.out.print(" ; " + courant + " + " + precedent + " = " + courant.somme(precedent));
	        System.out.print(" ; inverse = " + courant.inverse());
	        System.out.print(" ; valeur = " + courant.valeur());
	        System.out.print(" ; " + courant + " " + sup + " " + precedent);
	        System.out.println(" ; " + courant + " " + cmp + " " + precedent);

	        precedent = courant;
	    }
	}

	
	static Rationnel makeRationnel(int num, int den) {
	    return new RationnelCouple(num, den);
	}

	static void insererRationnel ( Rationnel nouveau , Rationnel [] lesRationnels , int nb ) 
	{
		boolean inserted = false;
		assert 0 <= nb && nb <= lesRationnels.length : "Outside the index of the table!";
		for (int i = 0; i < nb; i++) 
		{
			if(lesRationnels[i].compareTo(nouveau) == 1) //element in table superiour to new fraction
			{
				for (int j = nb-1; j >= i; j--)
				{
					lesRationnels[j+1] = lesRationnels[j]; //shift elements by 1 starting from point we found 
				}
				lesRationnels[i] = nouveau;
				inserted = true;
				break;
			}
		}
		if(!inserted) {lesRationnels[nb] = nouveau;} //small check to avoid duplicates
		
	}
	
	static Rationnel sommeRationnels(Rationnel[] lesRationnels , int nb) 
	{
		assert 0 <= nb && nb <= lesRationnels.length : "Outside the index of the table!";
		Rationnel sum_rationnel = makeRationnel(0,1);  
		for (int i = 0; i < nb; i++) {
		    sum_rationnel = sum_rationnel.somme(lesRationnels[i]);
		}
		return sum_rationnel;
	}
	
	static void afficher (Rationnel [ ] lesRationnels , int nb) 
	{
		assert 0 <= nb && nb <= lesRationnels.length : "Outside the index of the table!";
		
		for (int i = 0; i < nb; i++) 
		{
			System.out.println(lesRationnels[i] + " ; valeur = " + lesRationnels[i].valeur());
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

	    return makeRationnel(num, den);
	}

}
