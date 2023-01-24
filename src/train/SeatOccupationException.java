package train;

public class SeatOccupationException extends RuntimeException{
    public SeatOccupationException(){
        super("Seat is not available");
    }
}
