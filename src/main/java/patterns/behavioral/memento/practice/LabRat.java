package patterns.behavioral.memento.practice;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

@Getter
@Setter
public class LabRat implements Originator {
    private static final Logger logger = Logger.getLogger(LabRat.class.getSimpleName());
    private String principal;
    private double cd4ratio = 0.5;
    private boolean isAlive = true;

    public LabRat(String principal) {
        this.principal = principal;
    }

    private void checkAlive() {
        if (!isAlive)
            throw new IllegalArgumentException("rat is dead");
    }

    public void blastWithRadar() {
        checkAlive();
        cd4ratio /= ThreadLocalRandom.current().nextDouble();
        cd4ratio -= Math.floor(cd4ratio);
        cd4ratio -= Math.floor(cd4ratio);
        checkPulse();
    }

    public void feedDrugs() {
        checkAlive();
        cd4ratio *= ThreadLocalRandom.current().nextDouble();
        cd4ratio -= Math.floor(cd4ratio);
        checkPulse();
    }

    private void checkPulse() {
        if (cd4ratio < 0.1) isAlive = false;
        logger.info(String.format("Lab rat's ratio : %.2f.status: %s", cd4ratio, isAlive ? "alive" : "dead"));
    }

    public Memento saveStatus() {
        return new LabRatMemento(this, cd4ratio, isAlive);
    }

    @Override
    public String toString() {
        return String.format("[cd4 ratio: %.2f, alive ? %s]", cd4ratio, isAlive ? " yes " : " no ");
    }
}
