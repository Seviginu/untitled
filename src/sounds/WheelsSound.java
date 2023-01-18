package sounds;

public class WheelsSound implements Playable{
    private TypeOfWheelSound typeOfSound;

    public WheelsSound(TypeOfWheelSound typeOfSound){
        this.typeOfSound = typeOfSound;
    }

    public TypeOfWheelSound getTypeOfSound() {
        return typeOfSound;
    }

    @Override
    public String getSound() {
        return "*" + typeOfSound.string + "*";
    }
}
