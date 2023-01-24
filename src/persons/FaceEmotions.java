package persons;

public enum FaceEmotions {
    SMILE("Улыбка"), SAD("Нормальное"), ANGRY("Стресс"), LIPSCOMPRESSED("Губы сжаты");
    public final String string;

    FaceEmotions(String type){
        this.string = type;
    }
}
