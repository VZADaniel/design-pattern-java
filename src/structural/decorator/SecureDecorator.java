package structural.decorator;

public class SecureDecorator extends CreditDecorator{
    public SecureDecorator(Credit decoratedCredit) {
        super(decoratedCredit);
    }

    @Override
    public void showCredit() {
        decoratedCredit.showCredit();
        configSecure();
    }

    private void configSecure(){
        System.out.println("La tarjeta ha sido configurada con seguridad maxima...");
    }
}
