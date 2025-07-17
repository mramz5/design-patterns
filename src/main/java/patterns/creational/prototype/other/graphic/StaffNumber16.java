package patterns.creational.prototype.other.graphic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StaffNumber16 implements Graphic {
    private String attribute;

    @Override
    public void draw(double x, double y) {
        System.out.printf("drawing %s at position (%.3f , %.3f)%n","staff number 16", x, y);
    }

    @Override
    public Graphic clone() throws CloneNotSupportedException {
        return (Graphic) super.clone();
    }
}
