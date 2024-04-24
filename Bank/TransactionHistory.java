package Bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TransactionHistory {
    private Long id;
    private LocalDate dayTrading;
    private String description;
    private String beneficiaryAccount;
    private long money;

    public TransactionHistory(String description, String beneficiaryAccount, long money) {
        this.id = IdGenerate.getNewID(); // Automatic increasingly id
        this.dayTrading = LocalDate.now();
        this.description = description;
        this.beneficiaryAccount = beneficiaryAccount;
        this.money = money;
    }

    public String getBeneficiaryAccount(){ return beneficiaryAccount; }
    public String getDescription(){ return description; }
    public long getMoney(){ return money; }
    public LocalDate getDayTrading(){ return dayTrading; }
    public Long getId(){ return id; }
    public void setBeneficiaryAccount(String beneficiaryAccount){ this.beneficiaryAccount = beneficiaryAccount; }
    public void setDescription(String description){ this.description = description; }
    public void setMoney(long money){ this.money = money; }

    public String toString(){
        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return id + " - " + dayTrading.format(myFormatter) + " - " + description + " - " + Controller.formatMoney(money) + beneficiaryAccount +"\n" ;
    }
}
