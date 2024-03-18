package V2_Chargement_Données_Contraites;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CSVReader {

    private String path;
    private boolean type;
    private String onTop;

    public CSVReader(String path, boolean type) {
        this.path = path;
        this.type = type;
        this.onTop ="";
    }

    public void readCSV(HashMap<String, CSVFile> stock) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
        	this.onTop = br.readLine();
        	
            while ((line = br.readLine()) != null) {
                           
                CSVFile typeCSV;
                if (type) {
                	String[] values = line.split(",");
                    String[] valuesLine = values[0].split(";");
                	typeCSV = new Element(valuesLine);
                	stock.put(valuesLine[0], typeCSV);
                } else {
                	String[] values = line.split(";");
                	typeCSV = new Chaine(values);
                	stock.put(values[0], typeCSV);
                }
                	
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getOnTop() {
    	return this.onTop;
    }
}