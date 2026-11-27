import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class SoundManager {

    public static final String BASIC_ATTACK_SOUND = "src/dds-sfx/sound-effect-3.wav";
    public static final String MAGIC_ATTACK_SOUND = "src/dds-sfx/sound-effect-9.wav";
    public static final String HEAL_SOUND         = "src/dds-sfx/sound-effect-7.wav";
    public static final String WIN_SOUND          = "src/dds-sfx/win.wav";
    public static final String DEFEAT_SOUND       = "src/dds-sfx/sound-effect-11.wav";

    //bättre med flera metoder som kallar på en play metod istället för att ha samma kod i alla
    //se mitt projekt på github för att fatta vad jag menar

    public static void playBasicAttack() { play(BASIC_ATTACK_SOUND); }
    public static void playMagicAttack() { play(MAGIC_ATTACK_SOUND); }
    public static void playHeal()        { play(HEAL_SOUND); }
    public static void playWin()         { play(WIN_SOUND); }
    public static void playDefeat()      { play(DEFEAT_SOUND); }

    public static void play(String path) {
        File soundFile = new File(path);
        if (!soundFile.exists()) {
            soundError();
            return;
        }

        try (AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) clip.close();
            });
            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | IllegalArgumentException e) {
            soundError();
        }
    }

    private static void soundError() {
        System.out.println(TextColor.RED + "Could not play sound!!");
    }
}
