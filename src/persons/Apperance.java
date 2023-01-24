package persons;

public class Apperance {
    public HairColor hairColor;
    public FaceMusculesState faceMusculesState;
    public FaceEmotions faceEmotions;

    public Apperance(HairColor hair, FaceMusculesState faceMusculesState, FaceEmotions faceEmotions){
        this.hairColor = hair;
        this.faceMusculesState = faceMusculesState;
        this.faceEmotions = faceEmotions;
    }

    @Override
    public String toString(){
        return "Цвет волос: " + hairColor.string+
                ", Состояние мышц лица: " + faceMusculesState.string +
                ", Эмоции лица: " + faceEmotions.string;
    }
}
