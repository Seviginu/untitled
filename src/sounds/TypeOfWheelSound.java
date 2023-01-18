package sounds;

public enum TypeOfWheelSound {
    RHYTHMIC("Ритмичный стук"), RATTLE("Скрежет"), SPASMODIC("Неритмичный стук");
    public final String string;

    TypeOfWheelSound(String type){
        this.string = type;
    }
}
