package patterns.creational.builder.effective_java.video;

import lombok.NonNull;
import patterns.creational.builder.effective_java.Coding;
import patterns.creational.builder.effective_java.ContainerFormat;

public class Dirac extends AbstractVideo {
    public static class DiracBuilder extends VideoBuilder<Dirac, Dirac.DiracBuilder> {
        @Override
        public DiracBuilder name(@NonNull String name) {
            this.name = name;
            return this;
        }

        @Override
        public DiracBuilder fileExtension(@NonNull String fileExtension) {
            this.fileExtension = fileExtension;
            return this;
        }

        @Override
        public DiracBuilder containerFormat(@NonNull ContainerFormat containerFormat) {
            this.containerFormat = containerFormat;
            return this;
        }

        @Override
        public DiracBuilder audioCoding(@NonNull Coding audioCoding) {
            this.audioCoding = audioCoding;
            return this;
        }

        @Override
        public DiracBuilder videoCoding(@NonNull Coding videoCoding) {
            this.videoCoding = videoCoding;
            return this;
        }

        @Override
        public Dirac build() {
            return new Dirac(this);
        }
    }

    public Dirac(VideoBuilder<?, ?> videoBuilder) {
        super(videoBuilder);
    }
}
