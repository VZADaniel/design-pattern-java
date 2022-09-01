import behaivoral.Strategy.CapitalStrategyTextFormatter;
import behaivoral.Strategy.Context;
import behaivoral.Strategy.LowerStrategyTextFormatter;
import behaivoral.chainOfResponsability.Tarjeta;
import behaivoral.command.CreditCard;
import behaivoral.command.CreditCardActivateCommand;
import behaivoral.command.CreditCardDesactivateCommand;
import behaivoral.command.CreditCardInvoker;
import behaivoral.interpreter.AndExpression;
import behaivoral.interpreter.Expression;
import behaivoral.interpreter.OrExpression;
import behaivoral.interpreter.TerminalExpression;
import behaivoral.iterator.CardList;
import behaivoral.iterator.Iterator;
import behaivoral.iterator.List;
import behaivoral.mediator.ConcreteColleage1;
import behaivoral.mediator.ConcreteColleage2;
import behaivoral.mediator.ConcreteMediator;
import behaivoral.memento.Article;
import behaivoral.memento.ArticleMemento;
import behaivoral.memento.CareTaker;
import behaivoral.observer.Coche;
import behaivoral.observer.MessagePublisher;
import behaivoral.observer.Peaton;
import behaivoral.observer.Semaforo;
import behaivoral.state.MobileAlertStateContext;
import behaivoral.state.Silence;
import behaivoral.state.Vibration;
import behaivoral.templatemethod.Paypal;
import behaivoral.templatemethod.Visa;
import behaivoral.visitor.*;
import creational.abstractfactory.AbstractFactory;
import creational.abstractfactory.Card;
import creational.abstractfactory.FactoryProvider;
import creational.abstractfactory.PaymentMethod;
import creational.factorymethod.Payment;
import creational.factorymethod.PaymentFactory;
import creational.factorymethod.TypePayment;
import creational.prototype.PrototypeCard;
import creational.prototype.PrototypeFactory;
import structural.bridge.ClassicCreditCard;
import structural.bridge.SecureCreditCard;
import structural.bridge.UnsecureCreditCard;
import structural.composite.CuentaAhorro;
import structural.composite.CuentaComponent;
import structural.composite.CuentaComposite;
import structural.composite.CuentaCorriente;
import structural.decorator.*;
import structural.facade.CreditMarket;
import structural.flyweight.Enemy;
import structural.flyweight.EnemyFactory;
import structural.proxy.Internet;
import structural.proxy.ProxyInternet;

import java.util.Random;

import static creational.prototype.PrototypeFactory.CardType.AMEX;
import static creational.prototype.PrototypeFactory.CardType.VISA;

public class Main {
    public static void main(String[] args) {
//        CREACIONALES
//        probarFactoryMethod();
//        probarAbstractFactory();
//        probarBuilder();
//        probarPrototype();
//        probarSingleton();

//        COMPORTAMIENTO
//        probarChaindOfResponsability();
//        probarCommand();
//        probarIterator();
//        probarMediator();
//        probarMemento();
//        probarObserver();
//        probarState();
//        probarInterpreter();
//        probarStrategy();
//        probarTemplateMethod();
//        probarVisitor();

//        ESTRUCTURALES
//        probarAdapter();
//        probarBridge();
//        probarComposite();
//        probarDecorator();
//        probarFacade();
//        probarFlyweight();
        probarProxy();
    }

    private static void probarProxy() {
        Internet internet = new ProxyInternet();
        try {
            internet.connectTo("udemy.com");
            internet.connectTo("facebook.com");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void probarFlyweight() {
        for (int i = 0; i < 15; i++) {
            Enemy enemy = EnemyFactory.getEnemy(getRandomEnemyType());
            enemy.setWeapon(getRandomWeaponType());
            enemy.lifePoints();
        }
    }

    private static String getRandomWeaponType() {
        Random r = new Random();
        int randInt = r.nextInt(weaponType.length);
        return weaponType[randInt];
    }

    private static String getRandomEnemyType() {
        Random r = new Random();
        int randInt = r.nextInt(enemyType.length);
        return enemyType[randInt];
    }

    private static String[] enemyType = {"Private", "Detective"};
    private static String[] weaponType = {"Fusil", "Revolver", "Pistola", "Ametralladora", "Lanza Granada", "9mm"};

    private static void probarFacade() {
        CreditMarket creditMarket = new CreditMarket();

        creditMarket.showCreditGold();
        creditMarket.showCreditSilver();
        creditMarket.showCreditBlack();
    }

    private static void probarDecorator() {
        Credit gold = new Gold();

        Credit blackInternationalPayment = new Black();
        blackInternationalPayment = new InternationalPaymentDecorator(blackInternationalPayment);

        Credit goldSecureInternational = new Gold();
        goldSecureInternational = new InternationalPaymentDecorator(goldSecureInternational);
        goldSecureInternational = new SecureDecorator(goldSecureInternational);

        System.out.println("----Tarjeta Gold con configuracion");
        gold.showCredit();

        System.out.println("----Tarjeta Black con configuracion");
        blackInternationalPayment.showCredit();

        System.out.println("----Tarjeta Gold2 con configuracion");
        goldSecureInternational.showCredit();
    }

    private static void probarComposite() {
        CuentaComponent cuentaCorriente = new CuentaCorriente(1000.0, "Daniel");
        CuentaComponent cuentaAhorro = new CuentaAhorro(20000.0, "Daniel");

        CuentaComposite cuentaComposite = new CuentaComposite();
        cuentaComposite.addCuenta(cuentaAhorro);
        cuentaComposite.addCuenta(cuentaCorriente);

        cuentaComposite.showAccountName();
        cuentaComposite.getAmount();
    }

    private static void probarBridge() {
        structural.bridge.CreditCard creditCard = new ClassicCreditCard(new UnsecureCreditCard());
        creditCard.realizarPago();

        creditCard = new ClassicCreditCard(new SecureCreditCard());
        creditCard.realizarPago();
    }

    private static void probarAdapter() {
        structural.adapter.CreditCard creditCard = new structural.adapter.CreditCard();
        creditCard.pay("classic");
        creditCard.pay("gold");
        creditCard.pay("black");
        creditCard.pay("silver");
    }

    private static void probarVisitor() {
        OfertaElement ofertaElement = new OfertaGasolina();
        ofertaElement.accept(new BlackCreditCardVisitor());

        ofertaElement = new OfertaVuelos();
        ofertaElement.accept(new ClassicCreditCardVisitor());
    }

    private static void probarTemplateMethod() {
        behaivoral.templatemethod.Payment payment = new Visa();
        payment.makePayment();

        payment = new Paypal();
        payment.makePayment();
    }

    private static void probarStrategy() {
        Context context = new Context(new CapitalStrategyTextFormatter());
        context.publishText("Este texto sera convertido a MAYUSCULAS a traves del algoritmo");

        context = new Context(new LowerStrategyTextFormatter());
        context.publishText("Este texto sera convertido a MINISCULAS a traves del algoritmo");
    }

    private static void probarInterpreter() {
        Expression cero = new TerminalExpression("0");
        Expression uno = new TerminalExpression("1");

        Expression contieneBoolean = new OrExpression(cero, uno);
        Expression contieneOneAndCero = new AndExpression(cero, uno);

        System.out.println(contieneBoolean.interpret("cero"));
        System.out.println(contieneBoolean.interpret("0"));

        System.out.println(contieneOneAndCero.interpret("0"));
        System.out.println(contieneOneAndCero.interpret("0, 1"));
    }

    private static void probarState() {
        MobileAlertStateContext context = new MobileAlertStateContext();
        context.alert();
        context.alert();
        context.setState(new Vibration());
        context.alert();
        context.alert();
        context.setState(new Silence());
        context.alert();
        context.alert();

    }

    private static void probarObserver() {
        Coche coche = new Coche();
        Peaton peaton = new Peaton();
        MessagePublisher messagePublisher = new MessagePublisher();

        messagePublisher.attach(coche);
        messagePublisher.attach(peaton);
        messagePublisher.notifyUpdate(new Semaforo("ROJO_COCHE"));
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }

        messagePublisher.notifyUpdate(new Semaforo("VERDE_COCHE"));
    }

    private static void probarMemento() {
        CareTaker careTaker = new CareTaker();
        Article article = new Article("Daniel", "Memento es una pelicula");
        article.setText(article.getText() + " de Nolan");
        System.out.println(article.getText());

        careTaker.addMemento(article.createMemento());

        article.setText(article.getText() + " protagonizada por Guy Pearce");
        System.out.println(article.getText());

        careTaker.addMemento(article.createMemento());

        article.setText(article.getText() + " y Leonardo DiCaprio");
        System.out.println(article.getText());

        ArticleMemento memento1 = careTaker.getMemento(0);
        ArticleMemento memento2 = careTaker.getMemento(1);

        article.restoreMemento(memento1);
        System.out.println(article.getText());

        article.restoreMemento(memento2);
        System.out.println(article.getText());

        article.setText(article.getText() + " del año");
        System.out.println(article.getText());
    }

    private static void probarMediator() {
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleage1 user1 = new ConcreteColleage1(mediator);
        ConcreteColleage2 user2 = new ConcreteColleage2(mediator);

        mediator.setUser1(user1);
        mediator.setUser2(user2);

        user1.send("Hola soy user1");
        user2.send("Hola user1, soy user2");
    }

    private static void probarIterator() {
        behaivoral.iterator.Card[] cards = new behaivoral.iterator.Card[5];
        cards[0] = new behaivoral.iterator.Card("VISA");
        cards[1] = new behaivoral.iterator.Card("MASTER CARD");
        cards[2] = new behaivoral.iterator.Card("AMEX");
        cards[3] = new behaivoral.iterator.Card("GOOGLE CARD");
        cards[4] = new behaivoral.iterator.Card("APPLE CARD");

        List lista = new CardList(cards);
        Iterator iterator = lista.iterator();
        while (iterator.hasNext()) {
            behaivoral.iterator.Card tarjeta = (behaivoral.iterator.Card) iterator.next();
            System.out.println(tarjeta.getType());
        }
    }

    private static void probarCommand() {
        CreditCard creditCard = new CreditCard();
        CreditCard creditCardDeactivate = new CreditCard();

        CreditCardInvoker invoker = new CreditCardInvoker();
        invoker.setCommand(new CreditCardActivateCommand(creditCard));
        invoker.run();
        System.out.println("---------------------");
        invoker.setCommand(new CreditCardDesactivateCommand(creditCardDeactivate));
        invoker.run();
    }

    private static void probarChaindOfResponsability() {
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.creditCardRequest(20000);  // Tarjeta Platinium
        tarjeta.creditCardRequest(1000);  // Tarjeta Gold
        tarjeta.creditCardRequest(200000);  // Tarjeta Black
    }

    private static void probarSingleton() {
        creational.singleton.Card.getINSTANCE().setCardNumber("0000 1111 2222 3333");
        System.out.println(creational.singleton.Card.getINSTANCE().getCardNumber());
    }

    private static void probarPrototype() {
        PrototypeFactory.loadCard();
        try {
            PrototypeCard visa = PrototypeFactory.getinstance(VISA);
            visa.getCard();
            PrototypeCard amex = PrototypeFactory.getinstance(AMEX);
            amex.getCard();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private static void probarBuilder() {

        creational.builder.Card card = new creational.builder.Card.CardBuilder("VISA", "0000 1111 2222 3333").name("Daniel").expires(2030).credit(false).build();

        System.out.println(card.toString());

        creational.builder.Card card2 = new creational.builder.Card.CardBuilder("MASTERCARD", "0000 0000 0000 0000").build();

        System.out.println(card2.toString());
    }

    private static void probarAbstractFactory() {
        AbstractFactory abstractFactory = FactoryProvider.getFactory("Card");
        Card card = (Card) abstractFactory.create("VISA");

        AbstractFactory abstractFactory1 = FactoryProvider.getFactory("PaymentMethod");
        PaymentMethod paymentMethod = (PaymentMethod) abstractFactory1.create("DEBIT");

        System.out.println("Una tarjeta de tipo: " + card.getCardType() + "\ncon el metodo de pago: " + paymentMethod.doPayment());
    }

    private static void probarFactoryMethod() {
        Payment payment = PaymentFactory.buildPayment(TypePayment.GOOGLEPAY);
        payment.doPayment();
    }
}