package behaivoral.chainOfResponsability;

public class Platinium implements ApproveLoanChain{
    private ApproveLoanChain next;
    @Override
    public void setNext(ApproveLoanChain loan) {
        next = loan;
    }

    @Override
    public ApproveLoanChain getNext() {
        return next;
    }

    @Override
    public void creditCardRequest(int totalLoan) {
        if(totalLoan >= 10000 && totalLoan <= 50000){
            System.out.println("Esta solicitud de tarjeta de credito la maneja la tarjeta platinium");
        }else{
            next.creditCardRequest(totalLoan);
        }
    }
}
