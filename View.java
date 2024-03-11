import javax.swing.*;
import java.awt.*;

public class View {
    private long serialVersionUID = 1L;
    Model model;

    public View(Model model) {
        this.model = new Model();
        PaintMouseListener pml = new PaintMouseListener(model,this);
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set frame location to the center of the screen
        frame.setLocationRelativeTo(null);

        JPanel pizarra = new JPanel();
        pizarra.setPreferredSize(new Dimension(700, 400));
        pizarra.setBackground(Color.lightGray);
        pizarra.addMouseListener(pml);

        // Create buttons
        JButton undoButton = new JButton("Undo");
        undoButton.setSize(20, 20);
        JButton redoButton = new JButton("Redo");
        redoButton.setSize(20, 20);

        // Set layout for the frame's content pane
        frame.getContentPane().setLayout(new BorderLayout());

        // Add pizarra at the top
        frame.getContentPane().add(pizarra, BorderLayout.NORTH);

        // Create a panel for the buttons and set layout to horizontal
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Add buttons to the button panel
        buttonPanel.add(undoButton);
        buttonPanel.add(redoButton);

        // Add button panel at the bottom
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }


    protected void paintComponent(Graphics g) {
        
    
    }
	public void setTemporalLine(double x, double y, double x2, double y2) {
		this.model.addLine(new Line(x, y, x2, y2));
	}
}
