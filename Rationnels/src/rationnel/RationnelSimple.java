package rationnel;

import types.Rationnel;
import util.Outils;
import java.lang.Math;

public class RationnelSimple implements Rationnel{
	private int numerateur;
	private int denominateur;
	
	public RationnelSimple(int numerateur) {
		this.numerateur = numerateur;
		this.denominateur = 1;
		
	}
	
	public RationnelSimple(int numerateur, int denominateur) {
	    assert denominateur != 0 : "Denominator cannot be zero";

	    if (denominateur < 0) {
	        numerateur = -numerateur;
	        denominateur = -denominateur;
	    }

	    int a = Outils.pgcd(Math.abs(numerateur), denominateur);
	    this.numerateur = numerateur / a;
	    this.denominateur = denominateur / a;
	}

	
	public RationnelSimple(Rationnel r) {
		this.numerateur = r.getNumerateur();
		this.denominateur = r.getDenominateur();
	}


	@Override
	public boolean equals(Rationnel r) {
	    return this.numerateur * r.getDenominateur() == r.getNumerateur() * this.denominateur;
	}

	
	@Override
	public Rationnel somme(Rationnel r) 
	{
		return new RationnelSimple(r.getDenominateur() * this.numerateur +  this.denominateur* r.getNumerateur()   ,    this.denominateur * r.getDenominateur()); 
	}
	@Override
	public Rationnel inverse() 
	{
		return new RationnelSimple(this.denominateur, this.numerateur);
	}
	@Override
	public double valeur() 
	{
		return (double) this.numerateur/this.denominateur;
	}
	@Override
	public String toString() {
	    if (denominateur == 1)
	        return Integer.toString(numerateur);
	    return numerateur + "/" + denominateur;
	}

	
	  @Override
	  public int getNumerateur() {
		return this.numerateur;
	  }
	
	  @Override
	  public int getDenominateur() {
		return this.denominateur;
	  }
	
	  @Override
	  public int compareTo(Rationnel autre) {
	      int left = this.numerateur * autre.getDenominateur();
	      int right = autre.getNumerateur() * this.denominateur;

	      if (left < right) return -1;
	      if (left > right) return 1;
	      return 0;
	  }

		
}
