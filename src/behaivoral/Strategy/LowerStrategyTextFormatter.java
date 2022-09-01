package behaivoral.Strategy;

public class LowerStrategyTextFormatter implements StrategyTextFormatter {
    @Override
    public void format(String text) {
        System.out.println("Texto en Minisculas: " + text.toLowerCase());
    }
}
