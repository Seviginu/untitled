package persons;

public enum Mood {
    RELAX("Расслабленное"), STRESSED("Напряженное"), SLEEPING("Сон"), NORMAL("Нормальное");

    private String string;

    Mood(String type){
        this.string = type;
    }
}
