import Model.Model;
import View.Vista;

public class MainFrame {
    public static void main(String[] args) {
        Model modelo = new Model();
        Vista vista = new Vista(modelo);
        vista.setVisible(true);
    }
}
