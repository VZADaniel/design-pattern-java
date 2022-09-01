package structural.adapter;

public class BlackCreditCard implements Secure {
    @Override
    public void payWithSecureLevelA() {
        System.out.println("Tarjeta Black: Pagando con seguridad ALTA Nivel A...");
    }

    @Override
    public void payWithSecureLevelZ() {
//no implementar
    }
}
