package behaivoral.observer;

public class Peaton implements Observer{
    @Override
    public void update(Semaforo semaforo) {
        if(semaforo.status.equals("ROJO_COCHE")){
            System.out.println("El Semaforo Verde para Peaton: -> Peaton SI puede pasar");
        }else {
            System.out.println("El Semaforo Rojo para Peaton: -> Peaton NO puede pasar");
        }
    }
}
