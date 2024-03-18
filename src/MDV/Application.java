package MDV;

public class Application {
    public static void main(String[] args) {
        Production prod = new Production();
        View view = new View();
        new Controler(prod, view);
    }
}
