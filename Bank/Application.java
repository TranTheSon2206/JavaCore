package Bank;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ValidateAcount validate = new ValidateAcount();
        Controller controller = new Controller();

        boolean isCheck = false;
        while(!isCheck) {
            System.out.println("Enter Your Mobile");
            String mobile = sc.nextLine();
            System.out.println("Enter Your Password");
            String password = sc.nextLine();

            isCheck = validate.checkAcount(mobile, password);
        }

        while(true){
            menu();
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Account balance: ");
                    long balance = controller.getBalanceNumber();
                    System.out.println(Controller.formatMoney(balance));
                    break;
                    case 2:
                        controller.actionTransfer();
                        break;
                        case 3:
                            System.out.println("Transaction History: ");
                            controller.getHistory();
                            break;
                            case 0:
                                sc.close();
                                System.exit(0);
                                break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
    public static void menu(){
        System.out.println("Enter your Choice: ");
        System.out.println("1: Check Account");
        System.out.println("2: Transfer Money");
        System.out.println("3: Check History");
        System.out.println("0: Exit");
    }
}
