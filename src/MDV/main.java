package MDV;

public class main {

	 public static void main(String[] args) {
			            
	     Production prod = new Production();
	     prod.chargementDonnées();
	     
	     System.out.println(prod.getElement().toString());
	     //System.out.println(prod.getChaine().toString());
	     
	     System.out.println(prod.doProductionNTimesPlanned("C002", 110));
	     

	     prod.doProductionNTimes("C001", 5);
	     //prod.doProductionNTimes("C002", 110);
	     //prod.doProductionNTimes("C003", 1);
	     
	     System.out.println(prod.getElement().toString());

	     
	     // TODO: MARCHE UNIQUEMENT EN JAVA17
			/*
			 * CSVFile csvFile = cha.getC("C001"); if(csvFile instanceof Chaine chaine) {
			 * chaine.setOutQuantite(null); } else if (csvFile instanceof Element element) {
			 * element.addQuantite(0); }
			 */
    	 
	     //cha.getCSVFile(new Chaine(null), "C001").setOutQuantite(null);;
	        
	     //ele.writeCSV();
	     //cha.writeCSV(); 
	        
	    }

}