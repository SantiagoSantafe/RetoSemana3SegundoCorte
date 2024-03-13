package View;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.List;


import Controller.PaintMouseListener;
import Model.Line;
import Model.Model;

public class Vista extends JPanel{
    Model modelo;
    Line line;

    public Vista(Model modelo) {
        this.modelo = modelo;

        PaintMouseListener pml = new PaintMouseListener(this, modelo);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(this, BorderLayout.CENTER);

        JButton undoButton = new JButton("Undo");
        JButton redoButton = new JButton("Redo");
        // Ubicar los botones en la parte de abajo del frame que ocupen solo 20 pixeles de altura
        panel.add(undoButton, BorderLayout.SOUTH);
        panel.add(redoButton, BorderLayout.SOUTH);
        panel.add(undoButton, BorderLayout.LINE_START);
        panel.add(redoButton, BorderLayout.LINE_END);
        undoButton.addActionListener(e -> pml.actionUndo(e));
        redoButton.addActionListener(e -> pml.actionRedo(e));

        

        frame.add(panel);
        frame.setVisible(true);

        this.addMouseListener(pml);
        this.addMouseMotionListener(pml);

        setBackground(Color.WHITE);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(Color.BLACK);

        List<Line2D> lines = modelo.getLines();
        for (Line2D line : lines) {
            int x1 = (int) line.getX1();
            int y1 = (int) line.getY1();
            int x2 = (int) line.getX2();
            int y2 = (int) line.getY2();

            g2d.drawLine(x1, y1, x2, y2);
        }
    }
    

}
