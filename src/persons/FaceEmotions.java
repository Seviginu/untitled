package persons;

public enum FaceEmotions {
    SMILE("Улыбка"), SAD("Расстроенное"), ANGRY("Стресс");
    public final String string;

    FaceEmotions(String type){
        this.string = type;
    }
}
