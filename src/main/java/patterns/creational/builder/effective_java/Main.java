package patterns.creational.builder.effective_java;

import patterns.creational.builder.effective_java.video.ASF;

public class Main {
    public static void main(String[] args) {
//        ROQ roq = new ROQ.ROQBuilder(100)
//                .name("mp4")
//                .fileExtension(".m4")
//                .containerFormat(ContainerFormat.AVCHD)
//                .audioCoding(Coding.MPEG_2)
//                .videoCoding(Coding.AAC)
//                .build();
//        System.out.println(roq);
        ASF asf = new ASF.ASFBuilder()
                .audioCoding(Coding.MPEG_2)
                .videoCoding(Coding.AAC)
                .build();
        System.out.println(asf);

    }
}
