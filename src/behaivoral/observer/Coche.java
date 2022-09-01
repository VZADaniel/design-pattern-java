package behaivoral.observer;

public class Coche implements Observer{
    @Override
    public void update(Semaforo semaforo) {
        if(semaforo.status.equals("ROJO_COCHE")){
            System.out.println("El Semaforo Rojo para Coche: -> Coche NO puede pasar");
        }else {
            System.out.println("El Semaforo Verde para Coche: -> Coche SI puede pasar");
        }
    }
}
