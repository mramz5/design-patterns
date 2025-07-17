package patterns.creational.builder.effective_java.video;

import lombok.NonNull;
import patterns.creational.builder.effective_java.Coding;
import patterns.creational.builder.effective_java.ContainerFormat;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ASF extends AbstractVideo {
    /**
     * gives us:
     * 1-consistent object
     * 2-immutable and thread-safe object
     * 3-separated representation and construction process.
     **/
    public static class ASFBuilder extends VideoBuilder<ASF, ASFBuilder> {
        @Override
        public ASFBuilder name(@NonNull String name) {
            this.name = name;
            return this;
        }

        @Override
        public ASFBuilder fileExtension(@NonNull String fileExtension) {
            this.fileExtension = fileExtension;
            return this;
        }

        @Override
        public ASFBuilder containerFormat(@NonNull ContainerFormat containerFormat) {
            this.containerFormat = containerFormat;
            return this;
        }

        @Override
        public ASFBuilder audioCoding(@NonNull Coding audioCoding) {
            this.audioCoding = audioCoding;
            return this;
        }

        @Override
        public ASFBuilder videoCoding(@NonNull Coding videoCoding) {
            this.videoCoding = videoCoding;
            return this;
        }

        @Override
        public ASF build() {
            //custom validation for all possible combination to avoid inconsistent object
            if (isNull(fileExtension))
                throw new NullPointerException();
            if (isNull(audioCoding) == nonNull(videoCoding))
                throw new IllegalArgumentException("audio and video both should be set or not at all");
            return new ASF(this);
        }
    }

    public ASF(VideoBuilder<ASF, ASFBuilder> videoBuilder) {
        super(videoBuilder);
    }
}
