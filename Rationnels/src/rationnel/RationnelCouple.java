package rationnel;
import types.Rationnel;
import util.Couple;
import util.Outils;
public class RationnelCouple implements Rationnel{
	Couple<Integer, Integer> valeurs ;
	
	
	public RationnelCouple(int numerateur) {
		valeurs = new Couple<Integer, Integer>(numerateur, 1);
		
	}
	
	public RationnelCouple(int numerateur, int denominateur) {
	    assert denominateur != 0 : "Denominator cannot be zero";

	    if (denominateur < 0) {
	        numerateur = -numerateur;
	        denominateur = -denominateur;
	    }

	    int a = Outils.pgcd(Math.abs(numerateur), denominateur);
		valeurs = new Couple<Integer, Integer>(numerateur/a, denominateur/a);
	}

	
	public RationnelCouple(Rationnel r) {
		valeurs = new Couple<Integer, Integer>(r.getNumerateur(), r.getDenominateur());
	}


	@Override
	public boolean equals(Rationnel r) {
	    return this.valeurs.getFirst() * r.getDenominateur() == r.getNumerateur() * this.valeurs.getSecond();
	}

	
	@Override
	public Rationnel somme(Rationnel r) 
	{
		return new RationnelSimple(r.getDenominateur() * this.valeurs.getFirst() +  this.valeurs.getSecond()* r.getNumerateur()   ,    this.valeurs.getSecond() * r.getDenominateur()); 
	}
	@Override
	public Rationnel inverse() 
	{
		return new RationnelSimple(this.valeurs.getSecond(), this.valeurs.getFirst());
	}
	@Override
	public double valeur() 
	{
		return (double) this.valeurs.getFirst()/this.valeurs.getSecond();
	}
	@Override
	public String toString() {
	    if (this.valeurs.getSecond() == 1)
	        return Integer.toString(this.valeurs.getFirst());
	    return this.valeurs.getFirst() + "/" + this.valeurs.getSecond();
	}

	
	  @Override
	  public int getNumerateur() {
		return this.valeurs.getFirst();
	  }
	
	  @Override
	  public int getDenominateur() {
		return this.valeurs.getSecond();
	  }
	
	  @Override
	  public int compareTo(Rationnel autre) {
	      int left = this.valeurs.getFirst() * autre.getDenominateur();
	      int right = autre.getNumerateur() * this.valeurs.getSecond();

	      if (left < right) return -1;
	      if (left > right) return 1;
	      return 0;
	  }
	
}
