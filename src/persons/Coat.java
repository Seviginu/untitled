package persons;

public class Coat extends Cloth implements Pockets{
    public enum CollarState{
        STRAIGHT("Прямые"),
        TURNEDDOWN("Повернуты вниз"),
        TURNEDUP("Повернуты вверх"),
        NOCOLLAR("Нет воротники");
        final String name;
        CollarState(String name){
            this.name = name;
        }

        @Override
        public String toString(){
            return name;
        }
    }

    private final CollarState collarState;
    private boolean handsInPockets = false;



    public Coat(CollarState collarState){
        super("Пальто", Material.CAMELWOOl);
        this.collarState = collarState;
    }

    @Override
    public void putHandsInPockets(){
        handsInPockets = true;
    }

    public boolean isHandsInPockets(){
        return handsInPockets;
    }

    @Override
    public String toString(){
        return super.toString() +
                ", Воротник: " + collarState  +
                ", Руки в карманах: " + isHandsInPockets();
    }
}
