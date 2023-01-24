package train;

import java.util.ArrayList;

public class Train {
    private boolean isRiding = false;
    private int speed;
    private final Wheels wheels;

    private final ArrayList<Carriage> carriages;

    public Train(Wheels wheels){
        this.wheels = wheels;
        this.carriages = new ArrayList<Carriage>();
    }

    public Wheels getWheels(){
        return wheels;
    }

    public ArrayList<Carriage> getCarriages(){
        return carriages;
    }


    public void addCarriage(Carriage carriage){
        carriage.setTrain(this);
        carriages.add(carriage);
        System.out.println("Добавлен вагон.");
    }

    public int getSpeed(){
        return speed;
    }

    public void ride(){
        if(!isRiding){
            if(wheels.switchRotate()) {
                System.out.println("Поезд едет.");
                speed = 50 - (100-wheels.getCondition())/10;
                isRiding = true;
            }
            else System.out.println("Поезд не может ехать. Колеса не крутятся.");
        }
    }

    public void stop(){
        if(isRiding){
            isRiding = false;
            wheels.switchRotate();
            speed = 0;
            System.out.println("Поезд остановился.");
        }
    }
}
