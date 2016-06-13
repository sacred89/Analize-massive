package model;

public class Row {
    private Object[] row ;

    public Row(String[] massive,LogicScheme scheme) {
        row = new Object[massive.length];

        for (int i = 0; i < massive.length; i++) {
            TypeValues type = scheme.getTypeValues(i);
            switch (type) {
                case INT: {
                    row[i] = Integer.parseInt(massive[i]);
                    break;
                }
                case STR: {
                    row[i] = massive[i];
                    break;
                }
                case DOUBLE: {
                    row[i] = Double.parseDouble(massive[i]);
                    break;
                }
                default:
                    new IllegalArgumentException("Illegal logical scheme");
            }
        }
    }

    public Object[] getRow() {
            return row;
        }
}
