package patterns.behavioral.memento.practice;

import java.time.LocalDateTime;

public interface Memento {
    String getName();
    LocalDateTime getDate();
    Originator getOriginator();
    void undo();
}
