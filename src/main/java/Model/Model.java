package Model;

import java.util.ArrayList;
import java.util.List;


public class Model {
    private List<Line> lines;
    private List<Line> undoStack;
    private List<Line> redoStack;

    public Model() {
        lines = new ArrayList<>();
        undoStack = new ArrayList<>();
        redoStack = new ArrayList<>();
    }

    public void addLine(Line line) {
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

    public List<Line> getLines() {
        return lines;
    }

    public void remove(Line line) {
        lines.remove(line);
    }
}
