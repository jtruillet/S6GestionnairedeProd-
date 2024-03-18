package V1;

public abstract class CSVFile{
	
	private String[] values;
	private String code;
	private String nom;
	
	public CSVFile(String[] values) {
		this.values = values;

		this.code = values[0];
		this.nom = values[1];
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getCode() {
		return code;
	}
	
	public String[] getValues() {
		return values;
	}
	
	public String toString() {
		return this.getCode() + ";" + this.getNom();
	}
	
	public abstract CSVFile getCSFile();
}
