package V1;

public class PairChaine <String, Double>{

	private String code;
	private Double quantite;
	
	public PairChaine (String code, Double quantite) {
		this.code = code;
		this.quantite = quantite;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public Double getQuantite() {
		return this.quantite;
	}
	
	public void setQuantite(Double newQ) {
		this.quantite = newQ;
	}
	
	public java.lang.String toString() {
		return "(" + this.getCode() + "," + this.getQuantite() + ")";
	}
	
	

}
