package V2_Chargement_Données_Contraites;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CSVWriter {
	
	private String path;
    private String onTop;
    private HashMap<String, CSVFile> stock;

    public CSVWriter(String path, HashMap<String, CSVFile> stock, String onTop) {
        this.path = path;
        this.onTop = onTop;
        this.stock = stock;
    }

    public void writeCSV(HashMap<String, CSVFile> stock) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.path))) {           
            bw.write(this.onTop);
            bw.newLine();
        	
            TreeMap<String, CSVFile> sortedStock = new TreeMap<>(this.stock);
    	    for (String key : sortedStock.keySet()) {
    	    	bw.write(sortedStock.get(key).toString());
    	    	bw.newLine();
    	    }  
        	
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
