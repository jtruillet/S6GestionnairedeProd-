package V2_Chargement_Données_Contraites;

public class Element extends CSVFile {
	
	private Double quantite;	// en fonction de l'unité, no possible de soustraire >1
	private String unite;
	private Double achat;		// mettre des exception avec pop up si nombre < 0 
	private Double vente;
		
	public Element (String[] values) {
		super(values);
		
		this.quantite = Double.parseDouble(values[2]);
		this.unite = values[3];
		
		if ( !values[4].equals("NA")) {
			this.achat = Double.parseDouble(values[4]);
		} else {
			this.achat = -1.0;
		}
		
		if ( !values[5].equals("NA")) {
			this.vente = Double.parseDouble(values[5]);
		} else {
			this.vente = -1.0;
		}
	}

	public String toString() {
		/*
		 * String result = ""; for ( String value : this.values ) { result += value; }
		 * return result;
		 */
		return super.toString() + ";" + this.getQuantite() + ";" + this.getUnite() + ";" + this.getToStringAchat() + ";" + this.getToStringVente();
	}
	
	public Double getQuantite() {
		return quantite;
	}

	public void addQuantite(Double quantite) {
		this.quantite += quantite;
	}
	
	public void removeQuantite(Double quantite) {
		this.quantite -= quantite;
	}

	public Double getAchat() {
		return achat;
	}
	
	public String getToStringAchat() {
		if (("" + this.getAchat()).equals("-1.0")) {
			return "NA";
		} else {
			return "" + this.getAchat();
		}
	}

	public void setAchat(Double achat) {
		this.achat = achat;
	}

	public Double getVente() {
		return vente;
	}
	
	public String getToStringVente() {
		if (("" + this.getVente()).equals("-1.0")) {
			return "NA";
		} else {
			return "" + this.getVente();
		}
	}

	public void setVente(Double vente) {
		this.vente = vente;
	}

	public String getUnite() {
		return unite;
	}
	
}
