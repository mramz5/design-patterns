package patterns.behavioral.memento.practice;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.time.LocalDateTime;

import static java.util.Objects.isNull;

public class LabRatMemento implements Memento {
    private final Reference<LabRat> labRat;
    private final double cd4Ratio;
    private final boolean isAlive;
    private final LocalDateTime creationTime = LocalDateTime.now();

    public LabRatMemento(LabRat labRat, double cd4Ratio, boolean isAlive) {
        this.labRat = new SoftReference<>(labRat);
        this.cd4Ratio = cd4Ratio;
        this.isAlive = isAlive;
    }

    public LabRat getOriginator() {
        LabRat labRat1 = labRat.get();
        if (isNull(labRat1))
            throw new UnsupportedOperationException("can't perform undo,the history is cleared by GC. please try another save and restore.");
        return labRat1;
    }

    @Override
    public String getName() {
        return String.format("lab rat :[ %s ]", labRat);
    }

    @Override
    public LocalDateTime getDate() {
        return this.creationTime;
    }

    @Override
    public void undo() {
        LabRat labRat1 = getOriginator();
        labRat1.setAlive(isAlive);
        labRat1.setCd4ratio(cd4Ratio);
    }
}
