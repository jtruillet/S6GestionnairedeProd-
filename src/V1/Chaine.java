package V1;

import java.util.HashMap;

public class Chaine extends CSVFile {
	
	private HashMap<String, PairChaine<String, Double>> in;
	private PairChaine<String, Double> out;

	public Chaine(String[] values) {
		super(values);
		
		this.in = new HashMap<String, PairChaine<String,Double>>();
		
		String input = values[2].trim();
        String[] pairs = input.split("\\),\\(");
		
        for (String pair : pairs) {
            pair = pair.replace("(", "").replace(")", ""); // Enlever les parenthèses
            String[] pairTab = pair.split(",");
            // Utiliser Double.parseDouble pour convertir la partie quantité en Double
            PairChaine<String, Double> pairChaine = new PairChaine<>(pairTab[0], Double.parseDouble(pairTab[1].trim()));
            in.put(pairTab[0], pairChaine);
        }
		
		String pair = values[3].substring(1, values[3].lastIndexOf(")"));
		String[] pairTab = pair.split(",");
		this.out = new PairChaine<>(pairTab[0], Double.parseDouble(pairTab[1]));
	}
	
	public void setOutQuantite(Double newQ) {
		this.out.setQuantite(newQ);
	}
	
	public Chaine getCSFile() {
		return this;
	}
	
	public String toString() {
		String result = super.toString() + ";";
		for (String key : in.keySet()) {
			result += this.in.get(key) + ",";
		}		
		return result.substring(0, result.length() - 1) + ";" + this.out.toString();
	}

}
