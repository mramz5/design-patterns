package patterns.structutral.adapter;

public class Challenge {
    public static void main(String[] args) {
        AdvancedMediaPlayer advancedMediaPlayer=new VlcMediaPlayer("Ya Hossein",AudioType.VLC);

        AdvancedMediaPlayerAdapter adapter=new AdvancedMediaPlayerAdapter(advancedMediaPlayer);
        adapter.play(AudioType.VLC,"Ya Hossein 2");
    }
}

enum AudioType {
    MP3("MP3"), MP4("MP4"), VLC("VLC");
    private String type;

    AudioType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

interface MediaPlayer {
    void play(AudioType type, String fileName);
}

class AudioPlayer implements MediaPlayer {
    @Override
    public void play(AudioType type, String fileName) {
        if (!type.getType().equalsIgnoreCase("mp3"))
            throw new IllegalArgumentException("Type : " + type.getType() + " Not supported");
        System.out.println("Playing Audio");
    }
}

abstract class AdvancedMediaPlayer {
    protected String fileName;
    protected AudioType supportedType;

    public AdvancedMediaPlayer(String fileName,AudioType supportedType) {
        this.fileName = fileName;
        this.supportedType=supportedType;
    }

    public void loadFileName(AudioType type,String fileName) {
        if (!supportedType.equals(type))
            throw new IllegalArgumentException("Not supported format");
        System.out.println("Loading : " + fileName);
    }

    public void listen() {
        System.out.println("Listening to " + fileName);
    }
}

class VlcMediaPlayer extends AdvancedMediaPlayer {
    public VlcMediaPlayer(String fileName, AudioType supportedType) {
        super(fileName, supportedType);
        super.supportedType = AudioType.VLC;
    }
}

class MP4MediaPlayer extends AdvancedMediaPlayer {
    public MP4MediaPlayer(String fileName, AudioType supportedType) {
        super(fileName, supportedType);
        super.supportedType = AudioType.MP4;
    }

}

class AdvancedMediaPlayerAdapter implements MediaPlayer{
    private final AdvancedMediaPlayer advancedMediaPlayer;

    public AdvancedMediaPlayerAdapter(AdvancedMediaPlayer advancedMediaPlayer) {
        this.advancedMediaPlayer = advancedMediaPlayer;
    }

    @Override
    public void play(AudioType type, String fileName) {
        advancedMediaPlayer.loadFileName(type,fileName);
        advancedMediaPlayer.listen();
    }
}