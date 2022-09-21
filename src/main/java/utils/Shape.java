package utils;

import lombok.Data;

@Data
public class Shape implements Comparable<Shape> {
    private final String name;
    private final COLOR color;
    private final Integer angles;

    @Override
    public int compareTo(Shape shape) {
        if(shape == null)
            return -1;
        int res = name.compareToIgnoreCase(shape.getName());
        if(res != 0)
            return res;
        res = angles - shape.getAngles();
        if(res != 0)
            return res;
        return color.compareTo(shape.getColor());
    }
}
