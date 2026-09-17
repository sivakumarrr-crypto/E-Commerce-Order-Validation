// User-defined exceptions
class InvalidProductException extends Exception {
    InvalidProductException(String msg) {
        super(msg);
    }
}

class InvalidQuantityException extends Exception {
    InvalidQuantityException(String msg) {
        super(msg);
    }
}

class InsufficientStockException extends Exception {
    InsufficientStockException(String msg) {
        super(msg);
    }
}

class InvalidPaymentException extends Exception {
    InvalidPaymentException(String msg) {
        super(msg);
    }
}

// Main class
public class EcommerceDemo {

    static void order(int id, int qty, double payment)
            throws Exception {

        int productId = 101;
        double price = 500;
        int stock = 10;

        if (id != productId)
            throw new InvalidProductException("Invalid Product ID");

        if (qty <= 0)
            throw new InvalidQuantityException("Invalid Quantity");

        if (qty > stock)
            throw new InsufficientStockException("Insufficient Stock");

        double total = price * qty;

        if (payment < total)
            throw new InvalidPaymentException("Invalid Payment Amount");

        System.out.println("Order Successful");
        System.out.println("Total Amount: Rs." + total);
    }

    public static void main(String[] args) {

        try {
            order(101, 2, 1200);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            order(101, 0, 500);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            order(101, 20, 10000);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            order(101, 2, 500);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            order(999, 1, 500);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
