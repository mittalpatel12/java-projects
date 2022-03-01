package test.toptal;

public class VendingMachine {

    int[] changes = {1, 5, 10, 25, 50, 100};
    int[] noOfChange = {0, 0, 0, 0, 0, 0};

    public static void main(String[] args) {

        VendingMachine vendingMachine = new VendingMachine();

        //vendingMachine.getChange(5, 0.99);
        //vendingMachine.getChange(3.14, 1.99);
        //vendingMachine.getChange(3, 0.01);
        //vendingMachine.getChange(4, 3.14);
        vendingMachine.getChange(0.45, 0.34);


    }

    private void reset() {

    }

    private void getChange(double amount, double price) {

        double returnAmount = amount - price;

        int returnAmountInCent = (int) (returnAmount * 100);


        for (int i = changes.length - 1; i >= 0; i--) {

            int coins = returnAmountInCent / changes[i];
            returnAmountInCent = returnAmountInCent % changes[i];
            noOfChange[i] = noOfChange[i] + coins;

            if (returnAmountInCent == 0) {
                break;

            }


        }
        for (int c : noOfChange) {
            System.out.print(c + ",");

        }
        System.out.println();
    }
}
