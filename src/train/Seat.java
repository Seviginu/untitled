package train;

import persons.Person;

public class Seat extends CarriageItem implements Seatable{
    private Person nowSitting;
    private final int id;
    private static int countOfSeats = 0;

    public Seat(){
        super("Сиденье №" + ++countOfSeats);
        id = countOfSeats;
    }
    @Override
    public void seatDown(Person person) {
        if (nowSitting != null) throw new SeatOccupationException();
        nowSitting = person;
    }

    @Override
    public void standUp() {
        nowSitting = null;
    }


    @Override
    public int hashCode(){
        return id;
    }

    @Override
    public boolean equals(Object o){
        if (o == null || this.getClass() != o.getClass()) return false;
        return id == ((Seat) o).id;
    }
}
