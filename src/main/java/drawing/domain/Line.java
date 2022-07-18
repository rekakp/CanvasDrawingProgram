package drawing.domain;


public class Line implements Shape {
    private Integer x1;
    private Integer y1;
    private Integer x2;
    private Integer y2;
    private Character delimiter;

    public Line(Integer x1, Integer firstYCoordinate, Integer x2, Integer y2) {
        this.x1 = x1;
        this.y1 = firstYCoordinate;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Line(Integer x1, Integer firstYCoordinate, Integer x2, Integer y2, Character delimiter) {
        this(x1, firstYCoordinate, x2, y2);
        this.delimiter = delimiter;
    }

    public Integer getX1() {
        return x1;
    }

    public void setX1(Integer x1) {
        this.x1 = x1;
    }

    public Integer getY1() {
        return y1;
    }

    public void setY1(Integer y1) {
        this.y1 = y1;
    }

    public Integer getX2() {
        return x2;
    }

    public void setX2(Integer x2) {
        this.x2 = x2;
    }

    public Integer getY2() {
        return y2;
    }

    public void setY2(Integer y2) {
        this.y2 = y2;
    }

    public Character getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(Character delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (x1 != null ? !x1.equals(line.x1) : line.x1 != null) return false;
        if (y1 != null ? !y1.equals(line.y1) : line.y1 != null) return false;
        if (x2 != null ? !x2.equals(line.x2) : line.x2 != null) return false;
        if (y2 != null ? !y2.equals(line.y2) : line.y2 != null) return false;
        return delimiter != null ? delimiter.equals(line.delimiter) : line.delimiter == null;
    }

    @Override
    public int hashCode() {
        int result = x1 != null ? x1.hashCode() : 0;
        result = 31 * result + (y1 != null ? y1.hashCode() : 0);
        result = 31 * result + (x2 != null ? x2.hashCode() : 0);
        result = 31 * result + (y2 != null ? y2.hashCode() : 0);
        result = 31 * result + (delimiter != null ? delimiter.hashCode() : 0);
        return result;
    }
}
