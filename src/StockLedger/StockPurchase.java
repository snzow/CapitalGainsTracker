package StockLedger;

public class StockPurchase {
    String symbol;
    double cost;

    public StockPurchase(String s, double c){
        symbol = s;
        cost = c;
    }

    public String getSymbol(){
        return symbol;
    }

    public double getCost(){
        return cost;
    }

}
