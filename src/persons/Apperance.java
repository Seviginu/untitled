package persons;

public class Apperance {
    private HairColor hairColor;
    private FaceMusculesState faceMusculesState;
    private FaceEmotions faceEmotions;

    public HairColor getHairColor(){
        return hairColor;
    }

    public FaceMusculesState getFaceMusculesState(){
        return faceMusculesState;
    }

    public FaceEmotions getFaceEmotions(){
        return faceEmotions;
    }

    public void setFaceEmotions(FaceEmotions faceEmotions){
        this.faceEmotions = faceEmotions;
    }
    public Apperance(HairColor hair, FaceMusculesState faceMusculesState, FaceEmotions faceEmotions){
        this.hairColor = hair;
        this.faceMusculesState = faceMusculesState;
        this.faceEmotions = faceEmotions;
    }


}
