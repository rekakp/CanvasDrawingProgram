package drawing.domain;

import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Shape {

    private List<Line> boundaryLines = new ArrayList<>(4);

    public List<Line> getBoundaryLines() {
        return boundaryLines;
    }

    public void setBoundaryLines(List<Line> boundaryLines) {
        this.boundaryLines = boundaryLines;
    }

    public void addLine(Line line) {
        this.boundaryLines.add(line);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        return boundaryLines != null ? boundaryLines.equals(rectangle.boundaryLines) : rectangle.boundaryLines == null;
    }

    @Override
    public int hashCode() {
        return boundaryLines != null ? boundaryLines.hashCode() : 0;
    }
}
