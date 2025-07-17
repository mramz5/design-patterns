package patterns.creational.builder.effective_java;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContainerFormat {
    ASF("ASF"), AVCHD("AVCHD"), AVI("AVI"), FLV("FLV");
    private final String format;
}
