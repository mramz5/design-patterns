package patterns.creational.builder;

import lombok.*;

public class Main {

    public static void main(String[] args) {
        SportCarBuilder sportCarBuilder = new SportCarBuilder();
        Director director = new Director();
        director.build(sportCarBuilder);

        AbstractCar car = sportCarBuilder.getCar();
        System.out.println(car);
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class PC {
    private String pcCase, motherBoard, mouse, keyboard, monitor;
}

interface PCBuilder {
    void pcCase(String pcCase);

    void motherBoard(String motherBoard);

    void mouse(String mouse);

    void keyboard(String keyboard);

    void monitor(String keyboard);

    void reset();
}



class AsusPcBuilder implements PCBuilder {
    private static final AsusPcBuilder instance = new AsusPcBuilder();
    private static PC pc = new PC();

    private AsusPcBuilder() {
    }

    @Override
    public void pcCase(String pcCase) {
        pc.setPcCase(pcCase);
    }

    @Override
    public void motherBoard(String motherBoard) {
        pc.setMotherBoard(motherBoard);
    }

    @Override
    public void mouse(String mouse) {
        pc.setMouse(mouse);
    }

    @Override
    public void keyboard(String keyboard) {
        pc.setKeyboard(keyboard);
    }

    @Override
    public void monitor(String monitor) {
        pc.setMonitor(monitor);
    }

    @Override
    public void reset() {
        AsusPcBuilder.pc = new PC();
    }

    public static AsusPcBuilder getInstance() {
        return instance;
    }

    public PC getPc() {
        return pc;
    }
}

class AcerLaptopBuilder implements PCBuilder {
    private static final AcerLaptopBuilder instance = new AcerLaptopBuilder();
    private static PC pc = new PC();

    private AcerLaptopBuilder() {
    }

    @Override
    public void pcCase(String pcCase) {
        pc.setPcCase(pcCase);
    }

    @Override
    public void motherBoard(String motherBoard) {
        pc.setMotherBoard(motherBoard);
    }

    @Override
    public void mouse(String mouse) {
        pc.setMouse(mouse);
    }

    @Override
    public void keyboard(String keyboard) {
        pc.setKeyboard(keyboard);
    }

    @Override
    public void monitor(String monitor) {
        pc.setMonitor(monitor);
    }

    @Override
    public void reset() {
        AcerLaptopBuilder.pc = new PC();
    }

    public static AcerLaptopBuilder getInstance() {
        return instance;
    }

    public PC getPc() {
        return pc;
    }
}

@Setter
class AsusPCBuilderManager {
    private PCBuilder pcBuilder;

    public AsusPCBuilderManager(PCBuilder pcBuilder) {
        this.pcBuilder = pcBuilder;
    }

    public PC getAsusPC() {
        pcBuilder.mouse("asus mouse");
        pcBuilder.keyboard("asus keyboard");
        pcBuilder.monitor("asus monitor");
        pcBuilder.pcCase("asus case");
        pcBuilder.motherBoard("asus motherboard");
        return ((AsusPcBuilder) pcBuilder).getPc();
    }
}

@Setter
class AcerLaptopBuilderManager {
    private PCBuilder pcBuilder;

    public AcerLaptopBuilderManager(PCBuilder pcBuilder) {
        this.pcBuilder = pcBuilder;
    }

    public PC getAcerLaptop() {
        pcBuilder.mouse("acer mouse");
        pcBuilder.keyboard("acer keyboard");
        pcBuilder.monitor("acer monitor");
        pcBuilder.pcCase("acer case");
        pcBuilder.motherBoard("acer motherboard");
        return ((AcerLaptopBuilder) pcBuilder).getPc();
    }
}

class Main2{
    public static void main(String[] args) {
        AsusPcBuilder asusPcBuilder=AsusPcBuilder.getInstance();
        AsusPCBuilderManager asusPCBuilderManager=new AsusPCBuilderManager(asusPcBuilder);

        AcerLaptopBuilder acerLaptopBuilder=AcerLaptopBuilder.getInstance();
        AcerLaptopBuilderManager acerLaptopBuilderManager=new AcerLaptopBuilderManager(acerLaptopBuilder);

        PC pc = acerLaptopBuilderManager.getAcerLaptop();
        System.out.println(pc);
    }
}