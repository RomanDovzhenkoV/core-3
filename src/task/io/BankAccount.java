package task.io;

public class BankAccount {

    // TODO: Создайте класс, который представляет банковский счет. Реализуйте метод для снятия денег со
    //  счета. Обработайте исключение, если на счете недостаточно средств.

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void spendMoney(int money) throws InsufficientFunds {
        if (getBalance() >= money) {
            setBalance(getBalance() - money);
        } else throw new InsufficientFunds("Недостаточно средств на счету");
    }

}
