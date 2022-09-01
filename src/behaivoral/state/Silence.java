package behaivoral.state;

public class Silence implements MobileAlertState{
    @Override
    public void alert(MobileAlertStateContext context) {
        System.out.println("Silencio...Pantalla Iluminada");
    }
}
