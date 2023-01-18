package train;

import other.Lookable;

public class CarriageItem implements Lookable {
    private Carriage carriage;
    private String name;

    public CarriageItem(String name){
        this.name = name;
    }


    public Carriage getCarriage(){
        return carriage;
    }

    public void setCarriage(Carriage carriage){
        this.carriage = carriage;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public int hashCode(){
        return name.hashCode() + carriage.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if (o == null || this.getClass() != o.getClass()) return false;
        return name.equals(((CarriageItem) o).name) && carriage.equals(((CarriageItem) o).carriage);
    }
}
