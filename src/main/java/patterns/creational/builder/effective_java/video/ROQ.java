package patterns.creational.builder.effective_java.video;

import lombok.NonNull;
import patterns.creational.builder.effective_java.Coding;
import patterns.creational.builder.effective_java.ContainerFormat;

public class ROQ extends AbstractVideo {
    public static class ROQBuilder extends VideoBuilder<ROQ, ROQ.ROQBuilder> {
        private int mandatoryInt;

        public ROQBuilder(int mandatoryInt) {
            if (mandatoryInt <= 0)
                throw new IllegalArgumentException("mandatoryInt is positive");
            this.mandatoryInt = mandatoryInt;
        }

        @Override
        public ROQBuilder name(@NonNull String name) {
            this.name = name;
            return this;
        }

        @Override
        public ROQBuilder fileExtension(@NonNull String fileExtension) {
            this.fileExtension = fileExtension;
            return this;
        }

        @Override
        public ROQBuilder containerFormat(@NonNull ContainerFormat containerFormat) {
            this.containerFormat = containerFormat;
            return this;
        }

        @Override
        public ROQBuilder audioCoding(@NonNull Coding audioCoding) {
            this.audioCoding = audioCoding;
            return this;
        }

        @Override
        public ROQBuilder videoCoding(@NonNull Coding videoCoding) {
            this.videoCoding = videoCoding;
            return this;
        }

        @Override
        public ROQ build() {
            return new ROQ(this);
        }
    }

    public ROQ(VideoBuilder<?, ?> videoBuilder) {
        super(videoBuilder);
    }
}
