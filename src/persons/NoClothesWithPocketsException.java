package persons;

public class NoClothesWithPocketsException extends Exception{
    public NoClothesWithPocketsException(){
        super("Невозожно засунуть руки в карманы. Нет подходящей одежды.");
    }
}
