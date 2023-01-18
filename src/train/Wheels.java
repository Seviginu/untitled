package train;

import other.Repairable;
import persons.Person;
import persons.Speciality;
import sounds.TypeOfWheelSound;
import sounds.WheelsSound;

public class Wheels implements Repairable {
    private int condition = 100;
    private int countOfHits = 0;

    private boolean isRotating = false;
    public int getCondition(){
        return condition;
    }
    @Override
    public void repair(Person person) {
        if (!isRotating){
            int repairValue = 10;
            if (person.getSpeciality() == Speciality.MECHANIC) repairValue += 40;
            condition += repairValue;
            System.out.println(person.getName() + " починил колеса на " + repairValue + " единиц.");
        }
        else{
            System.out.println(person.getName() + " хотел починить колеса, но не смог этого сделать из-за того, что они вращались.");
        }
    }

    public boolean switchRotate(){
        if (isRotating){
            System.out.println("Колеса перестали вращаться.");
            isRotating = false;
            return true;
        }
        else if (condition > 0){
            System.out.println("Колеса начали вращаться.");
            for (int i = 0; i < 9; ++i){
                hit();
            }
            isRotating = true;
            return true;
        }
        else{
            System.out.println("Движение невозможно из-за плохого состояния колес. Condition = " + condition);
            return false;
        }
    }

    private void hit() {
        if (countOfHits % 4 == 0){
            if(Math.random() < 0.25){
                System.out.println("ХРЯСЬ!");
                condition -= 50;
                System.out.println("Что-то хрустнуло, колеса потеряли 60 единиц прочности. Condition = " + condition);
            }
            System.out.println("ТУК!");
        }
        else
            System.out.println("Тук.");
        countOfHits += 1;
    }

    public WheelsSound getWheelSound(){
        if (!isRotating) return null;
        else if (condition >= 90)
            return new WheelsSound(TypeOfWheelSound.RHYTHMIC);
        else if (condition >= 50)
            return new WheelsSound(TypeOfWheelSound.SPASMODIC);
        else return new WheelsSound(TypeOfWheelSound.RATTLE);

    }
}
