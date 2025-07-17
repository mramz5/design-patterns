package patterns.behavioral.state;

import java.security.SecureRandom;

public interface TrafficLightColor {
    String showStatus(TrafficLight trafficLight);
}

class Red implements TrafficLightColor {

    @Override
    public String showStatus(TrafficLight trafficLight) {
        System.out.println(trafficLight + " is showing : RED , your status:\tSTOP!");
        return "RED";
    }
}

class Yellow implements TrafficLightColor {

    @Override
    public String showStatus(TrafficLight trafficLight) {
        System.out.println(trafficLight + " is showing : YELLOW, your status:\tCAREFUL!");
        return "YELLOW";
    }
}

class Green implements TrafficLightColor {

    @Override
    public String showStatus(TrafficLight trafficLight) {
        System.out.println(trafficLight + " is showing : GREEN, your status:\tGO!");
        return "GREEN";
    }
}

class TrafficLight {
    private TrafficLightColor color;

    public void setColor(TrafficLightColor color) {
        this.color = color;
    }

    public TrafficLightColor getColor() {
        return color;
    }

    public String showColor() {
        return color.showStatus(this);
    }

    @Override
    public String toString() {
        return "Traffic light number :" + new SecureRandom().nextInt(10) + 1;
    }
}

class Main1 {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.setColor(new Red());
        trafficLight.showColor();

        trafficLight.setColor(new Green());
        trafficLight.showColor();
    }
}