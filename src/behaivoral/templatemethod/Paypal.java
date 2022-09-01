package behaivoral.templatemethod;

public class Paypal extends Payment {
    @Override
    void initilize() {
        System.out.println("Inicializando el pago con Paypal...");
    }

    @Override
    void startPayment() {
        System.out.println("Realizando el pago con Paypal...");
    }

    @Override
    void endPayment() {
        System.out.println("finalizando el pago con Paypal...");
    }
}
