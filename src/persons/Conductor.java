package persons;

import other.Repairable;
import sounds.Music;
import train.AirConditioner;

public class Conductor extends Passanger{
    private Music whistling;

    public Conductor(){
        super("Джон Голт",
                30,
                new Apperance(HairColor.BLONDE, FaceMusculesState.TENSE, FaceEmotions.SAD));
    }

    private void smile() {
        apperance.setFaceEmotions(FaceEmotions.SMILE);
        System.out.println("Кондуктор улыбнулся");
    }

    public void startWhistling(Music music){
        whistling = music;
        System.out.println("Кондуктор начал насвистывать " + music.getTitle());
    }

    public Music getWhistling(){
        return whistling;
    }

    public Music replyMusicQuestion(Person person){
        System.out.println("Кондуктор повернулся в сторону " + person.getName());
        lookAt(person);
        smile();
        sayPhrase("Я насвистываю " + whistling.getTitle() + " Автор: " + whistling.getAuthor().getName());
        return whistling;
    }


    public void setConditionerTemp(AirConditioner conditioner, double temp){
        System.out.println("Кондуктор настроил кондиционер");
        conditioner.setTemperature(temp);
    }
}
