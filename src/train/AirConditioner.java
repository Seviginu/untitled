package train;

import other.Repairable;
import persons.Person;
import persons.Speciality;

public class AirConditioner extends CarriageItem implements Repairable {
    private double realTemperature = 20;
    private double setTemperature = 20;
    private int condition = 100;
    private boolean isWorking = false;

    public AirConditioner() {
        super("Кондиционер");
    }

    public void switchPower(){
        if (!isWorking){
            if (condition > 0) {
                isWorking = true;
                System.out.println("Кондиционер включился.");
            }
            else {
                System.out.println("Кондиционер не включается из-за плохого состояния.");
            }
        }
        else {
            isWorking = false;
            System.out.println("Кондиционер выключен.");
        }
    }

    public void setTemperature(double temperature){
        if (temperature > 30 || temperature < 0){
            condition -= 5;
            System.out.println("Нельзя выставлять некорректные значения температуры. Состояние уменьшено на 5 единиц.");
        }
        else {
            setTemperature = temperature;
            realTemperature = (100.0 - condition) / 100.0 * (Math.random() - 0.5) * 0.1 + temperature;
            System.out.println("В кондиционеер выставлена температура: " + setTemperature);
            System.out.println("Реальная температура: " + realTemperature);
        }
    }

    public void repair(Person person){
        if (!isWorking){
            int repairValue = 10;
            if (person.getSpeciality() == Speciality.ELECTRIC) repairValue += 40;
            condition += repairValue;
            System.out.println(person.getName() + " починил кондиционер на " + repairValue + " единиц.");
        }
        else{
            System.out.println(person.getName() + " хотел починить кондиционер, но не смог этого сделать из-за того, что он работал.");
        }

    }
}
