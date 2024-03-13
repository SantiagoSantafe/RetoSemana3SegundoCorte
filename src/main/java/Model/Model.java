package Model;

import java.util.ArrayList;
import java.util.List;
import java.awt.geom.Line2D;


public class Model {
    private List<Line2D> lines;
    private List<Line2D> undoStack;
    private List<Line2D> redoStack;

    public Model() {
        lines = new ArrayList<>();
        undoStack = new ArrayList<>();
        redoStack = new ArrayList<>();
    }

    public void addLine(Line2D line) {
        lines.add(line);
        undoStack.add(line);
        redoStack.clear();
    }

    public void undo() {
        if (!lines.isEmpty()) {
            redoStack.add(lines.remove(lines.size() - 1));
            
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.add(redoStack.remove(redoStack.size() - 1));
            lines.add(undoStack.get(undoStack.size() - 1));
        }
    }

    public List<Line2D> getLines() {
        return lines;
    }

    public void remove(Line2D tempLine) {
        lines.remove(tempLine);
    }
}
