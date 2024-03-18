package V2_Chargement_Données_Contraites;

public class Production {
	
	private Stock chaine;
	private Stock element;
	private IndicateurCommande indC;
	
	public Production () {
		
	}
	
	public void chargementDonnées() {
	    this.chaine = new Stock("chaines.csv");
	    this.element = new Stock("elements.csv");
	}
	
	public void exportDonnées() {
		this.chaine.writeCSV();
		this.element.writeCSV();
	}
	
	public void doProductionNTimesPlanned(String keyCha, int times) {
		this.indC = new IndicateurCommande(times);
		this.indC.setSatisfiedOrders(this.getLimitProduction(keyCha) >= this.indC.getNumberOfOrders() ? times : this.getLimitProduction(keyCha));
		this.print(this.indC.toString());
	}
	
	public int getLimitProduction(String keyCha) {
		int limit = 1;
		for (String keyEle : this.chaine.getChaine(keyCha).getIn().keySet()) {
			while (this.element.getElement(keyEle).getQuantite() > this.chaine.getChaine(keyCha).getIn().get(keyEle).getQuantite() * limit) 
				limit++;
		}
		return limit;
	}	
	
	public void doProductionNTimes(String keyCha, int times) {
		//for (int i = 0; i < times && checkProduction(keyCha); i++) {
		for (int i = 0; i < times && i < this.getLimitProduction(keyCha); i++) {
			this.doProduction(keyCha);
		}
	}
	/*
	public boolean checkProduction(String keyCha) {
		for (String keyEle : this.chaine.getChaine(keyCha).getIn().keySet()) {
			if (this.element.getElement(keyEle).getQuantite() < this.chaine.getChaine(keyCha).getIn().get(keyEle).getQuantite())
				return false;
		}
		return true;
	}
	*/
	private void doProduction(String keyCha) {		
		for (String keyEle : this.chaine.getChaine(keyCha).getIn().keySet()) {
			this.element.getElement(keyEle).removeQuantite(this.chaine.getChaine(keyCha).getIn().get(keyEle).getQuantite());
		}
		this.element.getElement(this.chaine.getChaine(keyCha).getOut().getCode()).addQuantite(this.chaine.getChaine(keyCha).getOut().getQuantite());	
	}
	
	public Stock getChaine() {
		return this.chaine;
	}
	
	public Stock getElement() {
		return this.element;
	}
	
	public IndicateurCommande getIndicateurCommande() {
		return this.indC;
	}
	
	public void print(String result) {
		System.out.println(result);
	}
}
