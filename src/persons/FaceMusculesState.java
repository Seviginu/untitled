package persons;

public enum FaceMusculesState {
    NORMAL("Нормальные"), TENSE("Напряженные"), RELAXED("Расслабленные");
    public final String string;

    FaceMusculesState(String type){
        this.string = type;
    }
}
