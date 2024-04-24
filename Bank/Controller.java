package Bank;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static long balanceNumber = 1000000;
    List<TransactionHistory> listHistory = new ArrayList<TransactionHistory>();

    public long getBalanceNumber(){
        return balanceNumber;
    }

    public static long transfer(long money){
        return balanceNumber;
    }

    public void getHistory(){}

    public void actionTransfer(){

    }

    public static String formatMoney(long money){
        DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
        //100000->100,000.00
        return formatter.format(money);
    }
}
