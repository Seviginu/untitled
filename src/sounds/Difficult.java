package sounds;

public enum Difficult {
    EASY("Легкая"), MEDIUM("Средняя"), HARD("Сложная");
    public final String string;

    Difficult(String type){
        this.string = type;
    }
}
