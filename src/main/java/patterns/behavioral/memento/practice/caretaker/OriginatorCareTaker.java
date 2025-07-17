package patterns.behavioral.memento.practice.caretaker;

import lombok.*;
import patterns.behavioral.memento.practice.Memento;
import patterns.behavioral.memento.practice.Originator;

import java.lang.ref.SoftReference;
import java.util.Stack;

import static java.util.Objects.isNull;

@NoArgsConstructor
@AllArgsConstructor
public abstract class OriginatorCareTaker<T extends Originator> implements CareTaker {
    @Getter(AccessLevel.NONE)
    protected final Stack<SoftReference<Memento>> history = new Stack<>();
    @Getter
    @Setter
    protected T originator;

    protected void makeBackup(T originator) {
        history.push(new SoftReference<>(originator.saveStatus()));
    }

    protected void makeBackup(Memento memento) {
        if (this.originator != memento.getOriginator())
            throw new IllegalArgumentException("invalid originator");
        history.push(new SoftReference<>(memento));
    }

    protected void undo(T originator) {
        if (history.isEmpty())
            throw new UnsupportedOperationException("history is empty");
        Memento memento = history.pop().get();
        if (isNull(memento))
            throw new UnsupportedOperationException("can't perform undo,the history is cleared by GC. please try another save and restore.");
        memento.undo();
    }
}
