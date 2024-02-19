package task.io;

public class InsufficientFunds extends Exception {
    InsufficientFunds(String message) {
        super(message);
    }
}

