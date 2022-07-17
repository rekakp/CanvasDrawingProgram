package drawing.domain;


public class Line implements Shape {
    private Integer firstXCoordinate;
    private Integer firstYCoordinate;
    private Integer secondXCoordinate;
    private Integer secondYCoordinate;
    private Character delimiter;

    public Line(Integer firstXCoordinate, Integer firstYCoordinate, Integer secondXCoordinate, Integer secondYCoordinate) {
        this.firstXCoordinate = firstXCoordinate;
        this.firstYCoordinate = firstYCoordinate;
        this.secondXCoordinate = secondXCoordinate;
        this.secondYCoordinate = secondYCoordinate;
    }

    public Line(Integer firstXCoordinate, Integer firstYCoordinate, Integer secondXCoordinate, Integer secondYCoordinate, Character delimiter) {
        this(firstXCoordinate, firstYCoordinate , secondXCoordinate , secondYCoordinate);
        this.delimiter = delimiter;
    }

    public Integer getFirstXCoordinate() {
        return firstXCoordinate;
    }

    public void setFirstXCoordinate(Integer firstXCoordinate) {
        this.firstXCoordinate = firstXCoordinate;
    }

    public Integer getFirstYCoordinate() {
        return firstYCoordinate;
    }

    public void setFirstYCoordinate(Integer firstYCoordinate) {
        this.firstYCoordinate = firstYCoordinate;
    }

    public Integer getSecondXCoordinate() {
        return secondXCoordinate;
    }

    public void setSecondXCoordinate(Integer secondXCoordinate) {
        this.secondXCoordinate = secondXCoordinate;
    }

    public Integer getSecondYCoordinate() {
        return secondYCoordinate;
    }

    public void setSecondYCoordinate(Integer secondYCoordinate) {
        this.secondYCoordinate = secondYCoordinate;
    }

    public Character getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(Character delimiter) {
        this.delimiter = delimiter;
    }
}
