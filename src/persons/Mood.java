package persons;

public enum Mood {
    RELAX("Расслабленное"), STRESSED("Напряженное"), FUNNY("Веселое"), NORMAL("Нормальное");

    private String string;

    Mood(String type){
        this.string = type;
    }
}
