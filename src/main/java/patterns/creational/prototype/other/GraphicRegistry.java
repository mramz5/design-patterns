package patterns.creational.prototype.other;

import patterns.creational.prototype.other.graphic.Graphic;
import patterns.creational.prototype.other.graphic.NullGraphic;
import patterns.creational.prototype.other.graphic.StaffNumber16;
import patterns.creational.prototype.other.graphic.StaffNumber9;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static java.util.Objects.isNull;

public class GraphicRegistry {

    private static Map<Integer, Graphic> registry;
    private static int idGenerator;

    private GraphicRegistry() {
    }

    public static void loadDefaults() {
        registry = new HashMap<>();
        registry.put(idGenerator++, new StaffNumber9("ahmad staff"));
        registry.put(idGenerator++, new StaffNumber16("hossein staff"));
        registry.put(idGenerator++, new StaffNumber9("hassan staff"));
        registry.put(idGenerator++, new StaffNumber9("reza staff"));
    }

    public static void addGraphic(Graphic graphic) {
        if (isNull(registry))
            throw new NullPointerException("registry is not initialized");
        registry.put(idGenerator++, graphic);
    }

    public static Graphic getById(int id) {
        Graphic graphic = registry.get(id);
        if (isNull(graphic))
            throw new NoSuchElementException("no graphic with id : [" + id + "] found");
        try {
            return graphic.clone();
        } catch (CloneNotSupportedException e) {
            return NullGraphic.getInstance();
        }
    }

    public static Graphic getByLast() {
        return getById(idGenerator - 1);
    }
}
