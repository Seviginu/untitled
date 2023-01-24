
import other.Lookable;
import persons.*;
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
        Cloth coat = new Coat(Coat.CollarState.TURNEDUP);
        dagny.putOn(coat);
        class Boots extends Cloth{
            Boots(){
                super("Туфли с высокими каблуками", Material.LEATHER);
            }
        }
        Cloth boots = new Boots();
        Hat hat = new Hat(Hat.CornersState.TURNEDDOWN);
        dagny.putOn(boots);
        dagny.putOn(hat);
        System.out.println(coat);
        System.out.println(hat);
        System.out.println(boots);

        Wheels wheels = new Wheels();
        Train train = new Train(wheels);
        Carriage carriage = new Carriage();
        carriage.addPassanger(dagny);
        carriage.addPassanger(conductor);
        CarriageItem roof = new CarriageItem("Крыша");
        AirConditioner airConditioner = new AirConditioner();
        Seat seat1 = new Seat();
        Seat seat2 = new Seat();
        Window window = new Window();
        carriage.addItem(seat1);
        carriage.addItem(seat2);
        carriage.addItem(roof);
        carriage.addItem(airConditioner);
        carriage.addItem(window);
        train.addCarriage(carriage);

        dagny.lookAt(new Lookable() {
            @Override
            public String toString() {
                return "Надпись на стене";
            }
        });

        System.out.println("Дагни смотрит на " + dagny.getNowLookAt());

        train.ride();
        dagny.seat(seat1);
        Flashlight flashlight = new Flashlight();
        flashlight.startWorking();
        flashlight.lightInWindow(window);
        window.checkForStartShaking();
        dagny.throwHead();
        try {
            dagny.putHandsInPockets();
        }
        catch (NoClothesWithPocketsException e){
            System.err.println(e.getMessage());
        }
        System.out.println(dagny);
        System.out.println(dagny.rateSelf());
        dagny.listenTo(wheels.getWheelSound());
        dagny.tryToRelax();
        conductor.startWhistling(halley.getMusicList().get(4));
        dagny.thinkAboutListening();
        dagny.listenTo(conductor.getWhistling());
        dagny.thinkAboutListening();
        dagny.identifyAuthor();
        dagny.identifyMusic();
        dagny.lookAt(roof);
        dagny.checkVisible();
        dagny.identifyPlace();
        conductor.setConditionerTemp(airConditioner, 20);
        dagny.askQuestionAboutMusic(conductor);
        dagny.incrementDayStreak();
        System.out.println("Дагни не спит " + dagny.getStreakWithoutSleeping() + " дней");
        dagny.takeOffHat(hat);
        dagny.tryToThinking();
        dagny.printThinks();
        dagny.sleep();
        train.stop();
        flashlight.stopWorking();
        if(train.getWheels().getCondition() < 100) train.getWheels().repair(conductor);
    }
}