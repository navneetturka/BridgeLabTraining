import java.util.*;

public class BankAccountManagement {

    static class BankAccount {
        int accountNumber;
        String holderName;
        double balance;

        BankAccount(int accountNumber, String holderName, double balance) {
            this.accountNumber = accountNumber;
            this.holderName = holderName;
            this.balance = balance;
        }

        void deposit(double amount) {
            if (amount <= 0) {
                System.out.println("Deposit amount must be greater than 0.");
                return;
            }
            balance = balance + amount;
            System.out.println("Deposit successful. New balance: " + balance);
        }

        void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Withdraw amount must be greater than 0.");
                return;
            }

            if (amount > balance) {
                System.out.println("Insufficient balance. Current balance: " + balance);
                return;
            }

            balance = balance - amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        }

        void displayAccount() {
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Holder Name   : " + holderName);
            System.out.println("Balance       : " + balance);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        int choice;

        while (true) {
            System.out.println("\n--- Bank Account Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Search Account by account number");
            System.out.println("5. Sort accounts by balance");
            System.out.println("6. Display all accounts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter account number: ");
                int accNo = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter holder name: ");
                String name = sc.nextLine();

                System.out.print("Enter initial balance: ");
                double bal = sc.nextDouble();

                BankAccount acc = new BankAccount(accNo, name, bal);
                accounts.add(acc);

                System.out.println("Account created successfully!");

            } else if (choice == 2) {
                System.out.print("Enter account number: ");
                int accNo = sc.nextInt();

                BankAccount found = null;

                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).accountNumber == accNo) {
                        found = accounts.get(i);
                        break;
                    }
                }

                if (found == null) {
                    System.out.println("Account not found!");
                } else {
                    System.out.print("Enter deposit amount: ");
                    double amount = sc.nextDouble();
                    found.deposit(amount);
                }

            } else if (choice == 3) {
                System.out.print("Enter account number: ");
                int accNo = sc.nextInt();

                BankAccount found = null;

                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).accountNumber == accNo) {
                        found = accounts.get(i);
                        break;
                    }
                }

                if (found == null) {
                    System.out.println("Account not found!");
                } else {
                    System.out.print("Enter withdraw amount: ");
                    double amount = sc.nextDouble();
                    found.withdraw(amount);
                }

            } else if (choice == 4) {
                System.out.print("Enter account number: ");
                int accNo = sc.nextInt();

                BankAccount found = null;

                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).accountNumber == accNo) {
                        found = accounts.get(i);
                        break;
                    }
                }

                if (found == null) {
                    System.out.println("Account not found!");
                } else {
                    System.out.println("Account found:");
                    found.displayAccount();
                }

            } else if (choice == 5) {
                accounts.sort(new Comparator<BankAccount>() {
                public int compare(BankAccount a, BankAccount b) {
                if (a.balance > b.balance) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });


        System.out.println("\nSorted Accounts (by balance):");

        for (int i = 0; i < accounts.size(); i++) {
            accounts.get(i).displayAccount();
            System.out.println();
        }

            } else if (choice == 6) {
                if (accounts.size() == 0) {
                    System.out.println("No accounts available.");
                } else {
                    System.out.println("--- All Accounts ---");
                    for (int i = 0; i < accounts.size(); i++) {
                        System.out.println("\nAccount " + (i + 1));
                        accounts.get(i).displayAccount();
                    }
                }

            } else if (choice == 7) {
                System.out.println("Exiting program. Bye!");
                break;

            } else {
                System.out.println("Invalid choice. Please enter 1 to 7.");
            }
        }

        sc.close();
    }
}