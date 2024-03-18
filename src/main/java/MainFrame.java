import Model.Model;
import View.View;

public class MainFrame {
    public static void main(String[] args) {
        Model modelo = new Model();
        View vista = new View(modelo);
        vista.setVisible(true);
    }
}
