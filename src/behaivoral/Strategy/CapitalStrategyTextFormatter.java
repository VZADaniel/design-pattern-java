package behaivoral.Strategy;

public class CapitalStrategyTextFormatter implements StrategyTextFormatter{
    @Override
    public void format(String text) {
        System.out.println("Texto en Mayusculas: " + text.toUpperCase());
    }
}
