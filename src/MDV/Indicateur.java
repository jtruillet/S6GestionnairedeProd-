package MDV;

public abstract class Indicateur {
	
	private String name;
	
	public Indicateur(String name) {
		this.name = "Indicateur " + name;
	}
	
	public String toString() {
		return this.name + " : ";
	}
	
}
