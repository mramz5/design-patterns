package patterns.creational.builder.effective_java.video;

import lombok.Getter;
import lombok.ToString;
import patterns.creational.builder.effective_java.Coding;
import patterns.creational.builder.effective_java.ContainerFormat;

@Getter
@ToString
public abstract class AbstractVideo {
    protected final String name;
    protected final ContainerFormat containerFormat;
    protected final Coding audioCoding;
    protected final Coding videoCoding;
    protected final String fileExtension;

    protected static abstract class VideoBuilder<T extends AbstractVideo, S extends VideoBuilder<T, S>> {
        protected String name;
        protected ContainerFormat containerFormat;
        protected Coding audioCoding;
        protected Coding videoCoding;
        protected String fileExtension;

        public abstract S name(String name);

        public abstract S fileExtension(String fileExtension);

        public abstract S containerFormat(ContainerFormat containerFormat);

        public abstract S audioCoding(Coding audioCoding);

        public abstract S videoCoding(Coding videoCoding);

        public abstract T build();
    }

    public AbstractVideo(VideoBuilder<?, ?> videoBuilder) {
        this.name = videoBuilder.name;
        this.fileExtension = videoBuilder.fileExtension;
        this.containerFormat = videoBuilder.containerFormat;
        this.audioCoding = videoBuilder.audioCoding;
        this.videoCoding = videoBuilder.videoCoding;
    }
}
