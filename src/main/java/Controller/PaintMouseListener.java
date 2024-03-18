package Controller;
import Model.Model;
import Model.Line;
import View.View;
import java.awt.event.*;
public class PaintMouseListener extends MouseAdapter {
    View vista;
    Model modelo;
    private int x1,y1;
    private Line line;
    public PaintMouseListener(View vista, Model modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();

        line = new Line(x1, y1, x1, y1);
        modelo.addLine(line);
        vista.repaint();
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x2 = e.getX();
        int y2 = e.getY();

        line.setLine(x1, y1, x2, y2);
        vista.setTemporalLine(line);
        vista.repaint();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int x2 = e.getX();
        int y2 = e.getY();

        Line line = new Line(x1, y1, x2, y2);
        modelo.addLine(line);
        modelo.remove(line);
        vista.repaint();

        x1 = 0;
        y1 = 0;
        line = null;
    }

    public void actionUndo(ActionEvent e) {
        modelo.undo();
        vista.repaint();
    }

    public void actionRedo(ActionEvent e) {
        modelo.redo();
        vista.repaint();
    }
}
