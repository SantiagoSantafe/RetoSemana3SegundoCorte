package Controller;
import Model.Model;
import View.Vista;
import java.awt.event.*;
import java.awt.geom.Line2D;
public class PaintMouseListener extends MouseAdapter {
    Vista vista;
    Model modelo;
    private int x1,y1;
    private Line2D tempLine;
    public PaintMouseListener(Vista vista, Model modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();

        tempLine = new Line2D.Double(x1, y1, x1, y1);
        modelo.addLine(tempLine);
        vista.repaint();
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x2 = e.getX();
        int y2 = e.getY();

        tempLine.setLine(x1, y1, x2, y2);
        vista.repaint();
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int x2 = e.getX();
        int y2 = e.getY();

        Line2D line = new Line2D.Double(x1, y1, x2, y2);
        modelo.addLine(line);
        modelo.remove(tempLine);
        vista.repaint();

        x1 = 0;
        y1 = 0;
        tempLine = null;
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
