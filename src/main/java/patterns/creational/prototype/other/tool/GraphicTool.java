package patterns.creational.prototype.other.tool;

import lombok.Getter;
import lombok.Setter;
import patterns.creational.prototype.other.graphic.Graphic;

import java.security.SecureRandom;

import static java.util.Objects.isNull;

@Getter
@Setter
public class GraphicTool implements Tool {
    private Graphic graphic;

    public GraphicTool(Graphic graphic) {
        if (isNull(graphic))
            throw new NullPointerException("graphic should not be null");
        this.graphic = graphic;
    }

    @Override
    public void manipulate() {
        final SecureRandom random = new SecureRandom();
        graphic.draw(random.nextDouble() * 100, random.nextDouble() * 200);
    }
}
