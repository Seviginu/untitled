package persons;

public enum HairColor {
    BLONDE("Светлые"), DARK("Темные"), BROWN("Коричневые");
    public final String string;

    HairColor(String type){
        this.string = type;
    }
}
