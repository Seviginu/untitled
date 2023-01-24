package train;

public class Flashlight {
    private boolean isWorking;

    public void startWorking(){
        System.out.println("Фонари начали работать.");
        isWorking = true;
    }

    public void stopWorking(){
        isWorking = false;
    }

    public void lightInWindow(Window window){
        window.shineOn();
        System.out.println(window + " теперь освещается." );
    }

}
