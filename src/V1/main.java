package V1;

public class main {

	 public static void main(String[] args) {
			        
	     Stock ele = new Stock("elements.csv");
	     Stock cha = new Stock("chaines.csv");

	     System.out.println(ele.toString());
	     System.out.println(cha.toString());
	     
	     
	     // TODO: MARCHE UNIQUEMENT EN JAVA17
			/*
			 * CSVFile csvFile = cha.getC("C001"); if(csvFile instanceof Chaine chaine) {
			 * chaine.setOutQuantite(null); } else if (csvFile instanceof Element element) {
			 * element.addQuantite(0); }
			 */
    	 
	     //cha.getCSVFile(new Chaine(null), "C001").setOutQuantite(null);;
	        
	     ele.writeCSV();
	     //cha.writeCSV(); // l'écriture marche
	        
	    }

}