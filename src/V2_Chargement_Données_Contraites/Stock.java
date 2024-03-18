package V2_Chargement_Données_Contraites;
import java.util.HashMap;
import java.util.Optional;
import java.util.TreeMap;

public class Stock {

	private HashMap<String, CSVFile> stock;
	private CSVReader reader;
	private CSVWriter writer;
	private String path;
	
	public Stock(String path) {
		this.stock = new HashMap<String, CSVFile>();
		this.path = path;
		this.reader = new CSVReader(path, this.getType()); 
		this.readCSV();
		this.writer = new CSVWriter(path, stock, this.reader.getOnTop()); 
	}
	
	public boolean getType() {
		if (this.path.substring(0, this.path.lastIndexOf(".csv")).equals("elements")) {
			return true;
		} else {
			return false;
		}		
	}
	
	public void readCSV() {
		this.reader.readCSV(stock);
	}
	
	public void writeCSV() {
		this.writer.writeCSV(stock);
	}
	
	/*
	 * public void add(String key, CSVFile ele) { this.stock.put(key, ele); }
	 */
	
	/*
	 * public CSVFile getCSVFile(String key) { if (this.getType()) { return
	 * (Element) this.stock.get(key); } else { return (Chaine) this.stock.get(key);
	 * } }
	 */
	
	
	public Element getElement(String key) {
	    return (Element) this.stock.get(key);
	}

	public Chaine getChaine(String key) {
	    return (Chaine) this.stock.get(key);
	}
	
	
	
	
	
	public CSVFile getC(String key) {
		return this.stock.get(key);
	}
	
	public Class<? extends CSVFile> getClassType() {
		if (this.path.substring(0, this.path.lastIndexOf(".csv")).equals("elements")) {
			return Element.class;
		} else {
			return Chaine.class;
		}		
	}
	
	
	
	
	public String toString() {

		TreeMap<String, CSVFile> sortedStock = new TreeMap<>(stock);
		StringBuilder result = new StringBuilder();
	    for (String key : sortedStock.keySet()) {
	    	result.append(sortedStock.get(key)).append("\n");
	    }
	    return result.toString();
	}
		
}
