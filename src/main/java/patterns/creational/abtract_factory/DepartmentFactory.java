package patterns.creational.abtract_factory;

public class DepartmentFactory implements AbstractDepartmentFactory {
    @Override
    public Department factoryMethod(String type) {
        return switch (type.toLowerCase()) {
            case ("hr") -> new HR();
            case ("sales") -> new Sales();
            default -> throw new IllegalArgumentException("Not supported type : "+type);
        };
    }
}
