import java.util.ArrayList;

public class Model {
    View view;
    private ArrayList<Line> lineas;
    private ArrayList<Line> lineasBorradas;

    public void addLine(Line l) {
        lineas.add(l);
        lineasBorradas.clear();
    }
    public void undo() {
        lineasBorradas.add(lineas.getLast());
        lineas.removeLast();
    }
    public void redo() {
        lineas.add(lineasBorradas.getLast());
        lineasBorradas.removeLast();
    }
    
    

}
