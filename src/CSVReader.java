import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

	private Stock stock;
    private String path;
    private CSVFile file;

    public CSVReader(String path, CSVFile file) {
        this.path = path;
        this.stock = new Stock();
        this.file = file;
    }

    public void readCSV() {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
        	br.readLine();
            while ((line = br.readLine()) != null) {
                // Utilisation d'une virgule comme séparateur
                String[] values = line.split(",");
                
                // Traitement des valeurs ici...
                String[] valuesLine = values[0].split(";");

                //Element ele = new Element(valuesLine);            
                //this.stock.addElement(valuesLine[0], ele);
                
                //CSVFile file = new CSVFile(valuesLine);
                this.stock.add(valuesLine[0], this.file);
                
                //System.out.println(ele.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Stock getStock() {
    	return this.stock;
    }
    
    public void affichageStock() {
    	System.out.println(this.stock.toString());
    }

}