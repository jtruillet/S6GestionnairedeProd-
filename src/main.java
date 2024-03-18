
public class main {

	 public static void main(String[] args) {
		 
	        CSVReader csvReader = new CSVReader("C:\\Users\\Paul-AlexandreBaudra\\Desktop\\elements.csv", new Element(null));
	        csvReader.readCSV();
	        
	        //csvReader.affichageStock();
	        System.out.println(csvReader.getStock().getCSVFile("E001").toString());
	        csvReader.getStock().getCSVFile("E001");
	        System.out.println(csvReader.getStock().getCSVFile("E001").toString());
	    }

}
