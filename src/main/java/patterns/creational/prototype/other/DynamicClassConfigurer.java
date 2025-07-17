package patterns.creational.prototype.other;

import javassist.*;
import patterns.creational.prototype.other.graphic.Graphic;

public class DynamicClassConfigurer {
    public static Class<?> addAndGetNewClass(String classFullName) {
        try {
            return addNewClassHelper(classFullName);
        } catch (Exception e) {
            System.out.println("error happened : [" + e.getMessage() + "]");
            return Object.class;
        }
    }

    private static Class<?> addNewClassHelper(String classFullName) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass(classFullName);
        pool.insertClassPath(new ClassClassPath(Graphic.class));
        cc.setInterfaces(new CtClass[]{pool.get("patterns.creational.prototype.other.graphic.Graphic"), pool.get("java.lang.Cloneable")});
        return addNewClassHelper(cc);
    }

    private static Class<?> addNewClassHelper(CtClass cc) throws Exception {
        CtField field = addNewClassFields(cc);
        addNewClassMethods(cc, field);
        return cc.toClass();
    }

    private static CtField addNewClassFields(CtClass cc) throws CannotCompileException {
        CtField field = new CtField(CtClass.intType, "attribute", cc);
        field.setModifiers(Modifier.PRIVATE);
        cc.addField(field);
        return field;
    }

    private static void addNewClassMethods(CtClass cc, CtField field) throws CannotCompileException {
        cc.addMethod(CtNewMethod.setter("setAttribute", field));
        cc.addMethod(CtNewMethod.getter("getAttribute", field));

        CtMethod clone = CtNewMethod.make(
                "public patterns.creational.prototype.other.graphic.Graphic clone() throws CloneNotSupportedException {" +
                        "    return (patterns.creational.prototype.other.graphic.Graphic) super.clone();" +
                        "}",
                cc
        );

        CtMethod draw = CtNewMethod.make(
                """
                            public void draw(double x, double y) {
                                java.lang.System.out.println("drawing staff number 16 at position (" + x + " , " + y + ")");
                            }
                        """,
                cc
        );

        cc.addMethod(clone);
        cc.addMethod(draw);
    }
}