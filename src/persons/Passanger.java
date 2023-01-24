package persons;

import persons.Person;
import train.Carriage;

abstract public class Passanger extends Person {
    private Carriage carriage;

    public Passanger(String name, int age, Apperance apperance){
        super(name, age, apperance);
    }

    public void setCarriage(Carriage carriage){
        this.carriage = carriage;
    }

    public Carriage getCarriage(){
        return carriage;
    }
}
