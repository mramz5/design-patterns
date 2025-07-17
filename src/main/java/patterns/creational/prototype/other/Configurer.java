package patterns.creational.prototype.other;

import patterns.creational.prototype.other.graphic.Graphic;
import patterns.creational.prototype.other.graphic.NullGraphic;
import patterns.creational.prototype.other.graphic.StaffNumber16;
import patterns.creational.prototype.other.tool.GraphicTool;

public class Configurer {
    public static void configPrototypes() {
        GraphicRegistry.loadDefaults();

        GraphicTool msGT = new GraphicTool(GraphicRegistry.getById(1));
        msGT.manipulate();

        msGT.setGraphic(GraphicRegistry.getById(2));
        msGT.manipulate();

        GraphicRegistry.addGraphic(new StaffNumber16("Mokhtar staff"));
        msGT.setGraphic(GraphicRegistry.getByLast());
        msGT.manipulate();

        //add new class, the client(msGT) does not know anything about this new subclass of Graphic,
        // and it does not even know that this class is dynamically added to the code.
        Graphic graphicPrototype = addFromNewClass("com.isoft.myPrototype");
        GraphicRegistry.addGraphic(graphicPrototype);
        msGT.setGraphic(GraphicRegistry.getByLast());
        msGT.manipulate();
    }

    public static Graphic addFromNewClass(String classFullName) {
        try {
            return addAndGetPrototypeFromNewClass(classFullName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return NullGraphic.getInstance();
        }
    }

    private static Graphic addAndGetPrototypeFromNewClass(String classFullName) throws Exception {
        Class<?> aClass = DynamicClassConfigurer.addAndGetNewClass(classFullName);
        Object instance = aClass.newInstance();
        aClass.getMethod("setAttribute", int.class).invoke(instance, 123);
        return (Graphic) instance;
    }
}
