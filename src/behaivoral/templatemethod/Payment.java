package behaivoral.templatemethod;

public abstract class Payment {
    abstract void initilize();

    abstract void startPayment();

    abstract void endPayment();

    public final void makePayment() {
        initilize();
        startPayment();
        endPayment();
    }
}
