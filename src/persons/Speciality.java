package persons;

public enum Speciality {
    ENTREPRENEUR("Предприниматель"), ELECTRIC("Электрик"), MECHANIC("Механик"), MUSICIAN("Музыкант");
    public final String string;

    Speciality(String type){
        this.string = type;
    }
}
