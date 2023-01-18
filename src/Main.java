
import persons.Conductor;
import persons.Dagny;
import persons.Halley;
import sounds.Music;
import train.*;

public class Main {
    public static void main(String[] args) {
        Dagny dagny = new Dagny();
        Conductor conductor = new Conductor();
        Halley halley = new Halley();
        for (int i = 1; i <= 5; ++i){
            Music concert = halley.makeConcert(i);
            if (i != 5)
                dagny.rememberMusic(concert);
        }
        Wheels wheels = new Wheels();
        Train train = new Train(wheels);
        Carriage carriage = new Carriage();
        carriage.addPassanger(dagny);
        carriage.addPassanger(conductor);
        CarriageItem roof = new CarriageItem("Крыша");
        AirConditioner airConditioner = new AirConditioner();
        carriage.addItem(roof);
        carriage.addItem(airConditioner);
        train.addCarriage(carriage);

        train.ride();
        dagny.listenTo(wheels.getWheelSound());
        dagny.tryToRelax();
        conductor.startWhistling(halley.getMusicList().get(4));
        dagny.thinkAboutListening();
        dagny.listenTo(conductor.getWhistling());
        dagny.thinkAboutListening();
        System.out.println(dagny.getThink());
        dagny.identifyAuthor();
        dagny.identifyMusic();
        dagny.lookAt(roof);
        dagny.checkVisible();
        dagny.identifyPlace();
        conductor.setConditionerTemp(airConditioner, 20);
        dagny.askQuestionAboutMusic(conductor);
        if(dagny.ratePerson(conductor)){
            System.out.println("Дагни понравился кондуктор");
        }
        else {
            System.out.println("Дагни не понравился кондуктор");
        }
        train.stop();
        if(train.getWheels().getCondition() < 100) train.getWheels().repair(conductor);

    }
}