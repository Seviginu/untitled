package persons;

public class Hat extends Cloth{
    public enum CornersState{
        STRAIGHT("Прямые"),
        TURNEDDOWN("Повернуты вниз"),
        TURNEDUP("Повернуты вверх");

        final String name;
        CornersState(String name){
            this.name = name;
        }

        @Override
        public String toString(){
            return name;
        }
    }

    private final CornersState cornersState;
    public Hat(CornersState cornersState){
        super("Шляпка", Material.WOOL);
        this.cornersState = cornersState;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Уголки: " + cornersState;
    }
}
