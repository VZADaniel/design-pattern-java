package behaivoral.visitor;

public class BlackCreditCardVisitor implements CreditCardVisitor{
    @Override
    public void ofertaGasolina(OfertaGasolina ofertaGasolina) {
        System.out.println("Descuento del 10% en Gasolina con tu Tarjeta Black...");
    }

    @Override
    public void ofertaVuelos(OfertaVuelos ofertaVuelos) {
        System.out.println("Descuento del 25% en Vuelos con tu Tarjeta Black...");
    }
}
