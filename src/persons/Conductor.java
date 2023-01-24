package persons;

import other.Repairable;
import sounds.Music;
import train.AirConditioner;

public class Conductor extends Passanger{
    private Music whistling;

    public Conductor(){
        super("Джон Голт",
                30,
                new Apperance(HairColor.BLONDE, FaceMusculesState.NORMAL, FaceEmotions.SMILE));
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
        sayPhrase("Я насвистываю " + whistling.getTitle() + " Автор: " + whistling.getAuthor().getName());
        return whistling;
    }

    public void repair(Repairable item){
        item.repair(this);
    }

    public void setConditionerTemp(AirConditioner conditioner, double temp){
        System.out.println("Кондуктор настроил кондиционер");
        conditioner.setTemperature(temp);
    }
}
