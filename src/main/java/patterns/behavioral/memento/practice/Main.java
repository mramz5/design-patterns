package patterns.behavioral.memento.practice;

import patterns.behavioral.memento.practice.caretaker.LabRatTakeCare;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getSimpleName());

    public static void main(String[] args) {
        LabRatTakeCare timCareTaker = new LabRatTakeCare(new LabRat("tim"));
        experiment(timCareTaker);
    }

    private static void experiment(LabRatTakeCare labRatTakeCare) {
        LabRat labRat = labRatTakeCare.getOriginator();
        labRatTakeCare.setOriginator(labRat);

        logger.info(labRat.getPrincipal() + " before feeding:" + labRat);
        labRatTakeCare.feedDrugs(labRat);
        logger.info(labRat.getPrincipal() + " after feeding:" + labRat);
        if (!labRat.isAlive()) {
            labRatTakeCare.undo(labRat);
            logger.info(labRat.getPrincipal() + " respawned! :" + labRat);
        }

        try {
            labRatTakeCare.blastWithRadar(labRat);
            logger.info(labRat.getPrincipal() + " after radar:" + labRat);
        } catch (Exception ignore) {
            if (!labRat.isAlive()) {
                labRatTakeCare.undo(labRat);
                logger.info(labRat.getPrincipal() + " respawned! :" + labRat);
            }
        }
    }
}