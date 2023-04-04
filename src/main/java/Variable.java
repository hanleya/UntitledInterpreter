public class Variable {
    DataType type;
    Object value;

    public Variable(DataType type, Object value) {
        this.type = type;
        this.value = value;
    }

    public void printVar() {
        System.out.println(switch (type) {
            case None -> "none";
            case Int -> "int: " + (int)value;
            case Real -> "real: " + (double)value;
            case String -> "string: nyi";
        });
    }


}
