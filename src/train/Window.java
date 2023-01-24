package train;

import other.Repairable;
import persons.Person;

public class Window extends CarriageItem{
    private class Frame implements Repairable {

        private int condition = 80;
        private boolean isShaking;


        public void startShaking(){
            condition -= 10;
            System.out.println("Рамка начала трястись");
            isShaking = true;
        }

        public void stopShake(){
            isShaking = false;
        }

        public boolean isShaking(){
            return isShaking;
        }

        public void repair(Person person)
        {
            condition = 100;
        }

        public int getCondition(){
            return condition;
        }

        @Override
        public String toString(){
            return "Рамка. " + "Освещается: " + isShining + " Трясется" + isShaking;
        }
    }

    public Window(){
        super("Окно");
    }

    private final Frame frame = new Frame();
    private boolean isShining;
    public void shake(){
        frame.startShaking();
    }


    public void shineOn(){
        isShining = true;
    }

    public boolean isShining()
    {
        return isShining;
    }

    public void checkForStartShaking(){
        if (this.getCarriage().getTrain().getSpeed() >= 50 && frame.getCondition() <= 90){
            shake();
        }
    }
}
