package persons;

import sounds.*;
import train.CarriageItem;
import java.util.HashSet;

public class Dagny extends Passanger {
    private Playable nowListening;
    private Think think;
    private final HashSet<Music> musicInMemory = new HashSet<>();
    private boolean identifyPlace = false;
    public Dagny() {
        super("Дагни Таггерт",
                30,
                new Apperance(HairColor.DARK, FaceMusculesState.NORMAL, FaceEmotions.SMILE));
    }

    public boolean isIdentifyPlace(){
        return identifyPlace;
    }

    public void identifyPlace(){
        identifyPlace = true;
        System.out.println("Дагни поняла, где находится.");
    }

    public void listenTo(Playable sound) {
        nowListening = sound;
        System.out.println("Дагни слушает " + sound.getSound());
    }

    public void rememberMusic(Music music){
        musicInMemory.add(music);
        System.out.println("Дагни запомнила " + music.getTitle());
    }

    public Think getThink(){
        return think;
    }

    public void tryToRelax() {
        if (nowListening instanceof WheelsSound){
            if (((WheelsSound) nowListening).getTypeOfSound() == TypeOfWheelSound.RHYTHMIC){
                mood = Mood.RELAX;
                System.out.println("Дагни смогла расслабиться, так как слышала ритмичный стук колес");
            }
            else if (((WheelsSound) nowListening).getTypeOfSound() == TypeOfWheelSound.SPASMODIC){
                mood = Mood.NORMAL;
                System.out.println("Дагни не смогла расслабиться, так как слышала неритмичный стук колес");
            }
            else{
                mood = Mood.STRESSED;
                System.out.println("Дагни не смогла расслабиться, так как слышала скрежет колес");
            }
        }
        else if (nowListening instanceof Music){
            mood = Mood.RELAX;
            System.out.println("Дагни расслабилась, слушая " + ((Music) nowListening).getTitle());
        }
    }

    public Person identifyAuthor() {
        if (nowListening instanceof Music){
            if (((Music) nowListening).isClear() && ((Music) nowListening).getDifficult() == Difficult.HARD){
                System.out.println("Дагни узнала музыку Халлея.");
                return ((Music) nowListening).getAuthor();
            }
        }
        System.out.println("Дагни не смогла распознать автора");
        return null;
    }

    public boolean ratePerson(Person person){
        Apperance personApperance = person.getApperance();
        return personApperance.getHairColor() == HairColor.BLONDE &&
                personApperance.getFaceEmotions() == FaceEmotions.SMILE &&
                personApperance.getFaceMusculesState() == FaceMusculesState.TENSE;
    }

    public void thinkAboutListening(){
        if (nowListening instanceof WheelsSound){
            String content = "Дагни подумала: \"вот почему должны вращаться колеса, вот куда они нас несут.\"";
            think = new Think(content, nowListening);
            System.out.println(think);
        }
        else if (nowListening instanceof Music){
            if (identifyAuthor() instanceof Halley){

                String content = "Дагни казалось, что отзвуки этой темы можно уловить во всех произведениях Ричарда Халлея.\n";
                content += "Дагни подумала: \"Это и было целью его борьбы\"\n";
                if(identifyMusic() == null)
                    content += "Дагни подумала: \"Когда он написал эту мелодию?\"";
                think = new Think(content, nowListening);
                System.out.println(think);
            }
        }
    }

    public Music identifyMusic() {
        if (nowListening instanceof Music && musicInMemory.contains(nowListening)){
            System.out.println("Дагни уже слышала эту мелодию.");
            return (Music)nowListening;
        }
        System.out.println("Дагни не слышала эту мелодию.");
        return null;
    }

    public void checkVisible(){
        if(!isIdentifyPlace() && getNowLookAt() instanceof CarriageItem) {
            System.out.println("Дагни не видит " + ((CarriageItem)getNowLookAt()).getName());
        }
        else if (getNowLookAt() instanceof CarriageItem){
            System.out.println("Дагни видит " + ((CarriageItem)getNowLookAt()).getName());
        }
    }

    public void askQuestionAboutMusic(Conductor conductor){
        lookAt(conductor);
        sayPhrase("Пожалуйста скажи мне, что ты насвистываешь?");
        Music music = conductor.replyMusicQuestion(this);
        listenTo(music);
        if(identifyMusic() == null){
            sayPhrase("Но он же не писал этой мелодии.");
        }
        else {
            sayPhrase("Хорошая мелодия.");
        }
    }
}
