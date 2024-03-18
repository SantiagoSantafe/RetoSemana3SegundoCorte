package View;

import javax.swing.*;
import java.awt.*;
import java.util.List;


import Controller.PaintMouseListener;
import Model.Line;
import Model.Model;

public class View extends JPanel{
    Model modelo;
    Line line;

    public View(Model modelo) {
        this.modelo = modelo;

        PaintMouseListener pml = new PaintMouseListener(this, modelo);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);
        frame.setTitle("Line Paint");
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(this, BorderLayout.CENTER);

        JButton undoButton = new JButton("Undo");
        JButton redoButton = new JButton("Redo");
        JButton loadDataButton = new JButton("Load Data");
        undoButton.addActionListener(pml::actionUndo);
        redoButton.addActionListener(pml::actionRedo);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));


        buttonPanel.add(undoButton);
        buttonPanel.add(redoButton);
        buttonPanel.add(loadDataButton);

        panel.add(buttonPanel,BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);

        this.addMouseListener(pml);
        this.addMouseMotionListener(pml);

        setBackground(Color.WHITE);
        
    }
    public void setTemporalLine(Line l){
        this.line= l;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(Color.BLACK);

        List<Line> lines = modelo.getLines();
        for (Line line : lines) {
            int x1 = line.getX1();
            int y1 = line.getY1();
            int x2 = line.getX2();
            int y2 = line.getY2();

            g2d.drawLine(x1, y1, x2, y2);
        }
    }
    

}
