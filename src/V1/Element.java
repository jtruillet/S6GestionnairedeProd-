package V1;

public class Element extends CSVFile {
	
	private int quantite;
	private String unite;
	private int achat;		// mettre des exception avec pop up si nombre < 0 
	private int vente;
		
	public Element (String[] values) {
		super(values);
		
		this.quantite = Integer.parseInt(values[2]);
		this.unite = values[3];
		
		if ( !values[4].equals("NA")) {
			this.achat = Integer.parseInt(values[4]);
		} else {
			this.achat = -1;
		}
		
		if ( !values[5].equals("NA")) {
			this.vente = Integer.parseInt(values[5]);
		} else {
			this.vente = -1;
		}
	}

	public String toString() {
		/*
		 * String result = ""; for ( String value : this.values ) { result += value; }
		 * return result;
		 */
		return super.toString() + ";" + this.getQuantite() + ";" + this.getUnite() + ";" + this.getToStringAchat() + ";" + this.getToStringVente();
	}
	
	public int getQuantite() {
		return quantite;
	}

	public void addQuantite(int quantite) {
		this.quantite += quantite;
	}
	
	public void removeQuantite(int quantite) {
		this.quantite -= quantite;
	}

	public int getAchat() {
		return achat;
	}
	
	public String getToStringAchat() {
		if (("" + this.getAchat()).equals("-1")) {
			return "NA";
		} else {
			return "" + this.getAchat();
		}
	}

	public void setAchat(int achat) {
		this.achat = achat;
	}

	public int getVente() {
		return vente;
	}
	
	public String getToStringVente() {
		if (("" + this.getVente()).equals("-1")) {
			return "NA";
		} else {
			return "" + this.getVente();
		}
	}

	public void setVente(int vente) {
		this.vente = vente;
	}

	public String getUnite() {
		return unite;
	}
	
	public CSVFile getCSFile() {
		return this;
	}

}
