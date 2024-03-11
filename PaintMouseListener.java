import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
public class PaintMouseListener extends MouseAdapter{
    private Point puntoInicio = null;
    private Point puntoFinal = null;
    int contador = 0;
    Model model;
    View view;
    public PaintMouseListener(Model m,View v ) {
        this.model = m;
        this.view = v;
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {

        
        if (contador == 0){
            puntoInicio = e.getPoint();
            contador++;
        }
        else if (contador != 0){
            puntoFinal = e.getPoint();
            view.setTemporalLine(puntoInicio.getX(),puntoInicio.getY(),puntoInicio.getX(),puntoInicio.getY());
            contador = 0;
        }

    }

    /*public void mousePressed(MouseEvent  e) {
        while (!e.isConsumed()){
        view.paintComponent();

        }
    }*/

    public void mouseReleased(MouseEvent e){
        

    }




}
