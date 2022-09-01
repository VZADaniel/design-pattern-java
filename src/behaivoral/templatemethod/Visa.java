package behaivoral.templatemethod;

public class Visa extends Payment{
    @Override
    void initilize() {
        System.out.println("Inicializando el pago con Visa...");
    }

    @Override
    void startPayment() {
        System.out.println("Realizando el pago con Visa...");
    }

    @Override
    void endPayment() {
        System.out.println("finalizando el pago con Visa...");
    }
}
