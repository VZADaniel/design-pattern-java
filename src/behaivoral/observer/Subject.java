package behaivoral.observer;

public interface Subject {
    void attach(Observer observer);
    void dettach(Observer observer);
    void notifyUpdate(Semaforo semaforo);
}
