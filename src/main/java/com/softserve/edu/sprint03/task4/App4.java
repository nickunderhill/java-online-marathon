package sprint03.task4;

class App4 {

    enum LineType {
        SOLID,
        DOTTED,
        DASHED,
        DOUBLE
    }

    public static String drawLine(LineType lineType) {
        return "The line is "
                + lineType.toString().toLowerCase()
                + " type";
    }

    public static void main(String[] args) {
        LineType line = LineType.SOLID;
        System.out.println(drawLine(line));
    }
}