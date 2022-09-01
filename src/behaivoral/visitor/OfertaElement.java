package behaivoral.visitor;

public interface OfertaElement {
    void accept(CreditCardVisitor visitor);
}
