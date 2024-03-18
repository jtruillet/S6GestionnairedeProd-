package V2_Chargement_Données_Contraites;

public class IndicateurCommande extends Indicateur{
	
	private int numberOfOrders;
	private int satisfiedOrders;
	
	public IndicateurCommande(int numberOfOrders) {
		super("Commande");
		this.numberOfOrders = numberOfOrders;
		this.satisfiedOrders = 0;
	}
	
	public int getNumberOfOrders() {
		return this.numberOfOrders;
	}
	
	public int getSatisfiedOrders() {
		return this.satisfiedOrders;
	}
	
	public void setSatisfiedOrders(int satisfiedOrders) {
		this.satisfiedOrders = satisfiedOrders;
	}
	
	public void orderSatisfied() {
		this.satisfiedOrders++;
	}
	
	
	public double percentageOrdersSatisfied() {
		return ((this.getSatisfiedOrders() + 0.0) / (this.getNumberOfOrders() + 0.0)) * 100;
	}
	
	public String toString() {
		return super.toString() + " " + String.format("%.2f", this.percentageOrdersSatisfied()) + "%";
	}

}
