package persons;

import sounds.Difficult;
import sounds.Music;

import java.util.ArrayList;

public class Halley extends Person {

    private final ArrayList<Music> musicList = new ArrayList<>();

    public Halley() {
        super("Ричард Халлей",
                56,
                new Apperance(HairColor.BROWN, FaceMusculesState.NORMAL, FaceEmotions.SMILE));
    }

    public ArrayList<Music> getMusicList(){
        return musicList;
    }

    private Music makeMusic(String title, String content){
        Music music = new Music(this, title, content, Difficult.HARD, true);
        musicList.add(music);
        return music;
    }

    public Music makeConcert(int part){
        System.out.println("Халлей выпустил концерт " + part + ".");
        return makeMusic("Концерт " + part, "*мелодия концерта " + part + "*");
    }

}
