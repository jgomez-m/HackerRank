package hacker.rank.digitalwallet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution
{
    private static final Scanner INPUT_READER = new Scanner(System.in);
    private static final DigitalWalletTransaction DIGITAL_WALLET_TRANSACTION = new DigitalWalletTransaction();

    private static final Map<String, DigitalWallet> DIGITAL_WALLETS = new HashMap<>();

    public static void main(String[] args) {
        int numberOfWallets = Integer.parseInt(INPUT_READER.nextLine());
        while (numberOfWallets-- > 0) {
            String[] wallet = INPUT_READER.nextLine().split(" ");
            DigitalWallet digitalWallet;

            if (wallet.length == 2) {
                digitalWallet = new DigitalWallet(wallet[0], wallet[1]);
            } else {
                digitalWallet = new DigitalWallet(wallet[0], wallet[1], wallet[2]);
            }

            DIGITAL_WALLETS.put(wallet[0], digitalWallet);
        }

        int numberOfTransactions = Integer.parseInt(INPUT_READER.nextLine());
        while (numberOfTransactions-- > 0) {
            String[] transaction = INPUT_READER.nextLine().split(" ");
            DigitalWallet digitalWallet = DIGITAL_WALLETS.get(transaction[0]);

            if (transaction[1].equals("add")) {
                try {
                    DIGITAL_WALLET_TRANSACTION.addMoney(digitalWallet, Integer.parseInt(transaction[2]));
                    System.out.println("Wallet successfully credited.");
                } catch (TransactionException ex) {
                    System.out.println(ex.getErrorCode() + ": " + ex.getMessage() + ".");
                }
            } else {
                try {
                    DIGITAL_WALLET_TRANSACTION.payMoney(digitalWallet, Integer.parseInt(transaction[2]));
                    System.out.println("Wallet successfully debited.");
                } catch (TransactionException ex) {
                    System.out.println(ex.getErrorCode() + ": " + ex.getMessage() + ".");
                }
            }
        }

        System.out.println();

        DIGITAL_WALLETS.keySet()
            .stream()
            .sorted()
            .map((digitalWalletId) -> DIGITAL_WALLETS.get(digitalWalletId))
            .forEachOrdered((digitalWallet) -> {
                System.out.println(digitalWallet.getWalletId()
                    + " " + digitalWallet.getUsername()
                    + " " + digitalWallet.getWalletBalance());
            });
    }

    static class DigitalWallet {
        private String walletId;
        private String userName;
        private String userAccesCode;
        private int walletBalance;


        public DigitalWallet(String walletId, String userName)
        {
            this.walletId = walletId;
            this.userName = userName;
        }

        public DigitalWallet(String walletId, String userName, String userAccesCode)
        {
            this.walletId = walletId;
            this.userName = userName;
            this.userAccesCode = userAccesCode;
        }

        public String getWalletId()
        {
            return walletId;
        }

        public String getUsername()
        {
            return userName;
        }

        public String getUserAccesCode()
        {
            return userAccesCode;
        }

        public int getWalletBalance()
        {
            return walletBalance;
        }

        public void setWalletBalance(final int walletBalance)
        {
            this.walletBalance = walletBalance;
        }
    }

    static class DigitalWalletTransaction {

        public void addMoney(DigitalWallet digitalWallet, int amount) throws TransactionException
        {
            validateUser(digitalWallet);
            validateAmount(amount);
            int balance = digitalWallet.getWalletBalance();
            digitalWallet.setWalletBalance(balance + amount);
        }

        public void payMoney(DigitalWallet digitalWallet, int amount) throws TransactionException
        {
            validateUser(digitalWallet);
            validateAmount(amount);
            int balance = digitalWallet.getWalletBalance();
            if(balance < amount){
                throw new TransactionException("Insufficient balance", "INSUFFICIENT_BALANCE");
            }
            digitalWallet.setWalletBalance(balance - amount);
        }

        private void validateUser(DigitalWallet digitalWallet) throws TransactionException
        {
            if(digitalWallet.getUserAccesCode() == null
                || digitalWallet.getUserAccesCode().isEmpty()) {
                throw new TransactionException("User not authorized", "USER_NOT_AUTHORIZED");
            }
        }

        private void validateAmount(int amount) throws TransactionException
        {
            if(amount <= 0){
                throw new TransactionException("Amount should be greater than zero", "INVALID_AMOUNT");
            }
        }
    }

    static class TransactionException extends Exception{
        private String errorCode;

        public TransactionException(String errorMessage, String errorCode)
        {
            super(errorMessage);
            this.errorCode = errorCode;
        }

        public String getErrorCode(){
            return errorCode;
        }
    }
}
