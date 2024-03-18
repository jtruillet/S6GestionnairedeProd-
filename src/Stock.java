import java.util.HashMap;

public class Stock {

	private HashMap<String, CSVFile> stock;
	private String name; // fonctionnalitée future, plusieurs stock
	
	public Stock() {
		this.stock = new HashMap<String, CSVFile>();
	}
	
	public void add(String key, CSVFile ele) {
		this.stock.put(key, ele);
	}
	
	public CSVFile getCSVFile(String key) {
		return this.stock.get(key);
	}
	
	public String toString() {

		//this.stock.keySet().stream().sorted().forEach(System.out::println); 
		//System.out.println(this.stock.values());
		
		String result = "";
		
		for (String key : this.stock.keySet()) {
			result += "\n" + key + " : " + this.stock.get(key);
		}
		
		return result;
	}
	
	//TODO modifierAchatElement, modifierVenteElement, modifierQuantiteElement 
	
}
