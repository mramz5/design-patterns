package patterns.behavioral.memento.practice.caretaker;

import patterns.behavioral.memento.practice.LabRat;
import patterns.behavioral.memento.practice.Memento;


public class LabRatTakeCare extends OriginatorCareTaker<LabRat> {
    public LabRatTakeCare(LabRat originator) {
        super(originator);
    }

    public void blastWithRadar(LabRat labRat) {
        Memento previousStatus = labRat.saveStatus();
        labRat.blastWithRadar();
        if (!labRat.isAlive())
            super.makeBackup(previousStatus);
    }

    public void feedDrugs(LabRat labRat) {
        Memento previousState = labRat.saveStatus();
        labRat.feedDrugs();
        if (!labRat.isAlive())
            super.makeBackup(previousState);
    }

    public void undo(LabRat labRat) {
        super.undo(labRat);
    }

}
