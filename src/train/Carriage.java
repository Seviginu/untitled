package train;

import persons.Passanger;

import java.util.ArrayList;

public class Carriage{
    private ArrayList<Passanger> passangers = new ArrayList<>();
    private ArrayList<CarriageItem> items = new ArrayList<>();
    private static int countOfCarriages = 0;
    private final int id;
    public Carriage(){
        this.id = ++countOfCarriages;
    }

    public void addPassanger(Passanger passanger){
        passanger.setCarriage(this);
        passangers.add(passanger);
        System.out.println("Пассажир " + passanger.getName() + " теперь находится в вагоне " + this.id);
    }

    public void addItem(CarriageItem item){
        item.setCarriage(this);
        items.add(item);
        System.out.println("Предмет " + item.getName() + " теперь находится в вагоне " + this.id);
    }

    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != this.getClass() || this.hashCode() != o.hashCode()) return false;
        return this.id == ((Carriage) o).id;
    }
    @Override
    public int hashCode(){
        return id;
    }

    @Override
    public String toString(){
        return "Вагон: " + id;
    }
}
