package patterns.creational.builder.effective_java;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Coding {
    AAC("AAC"), MP3("MP3"), MPEG_2("MPEG_2"), PART_3("PART 3");
    private final String coding;
}
