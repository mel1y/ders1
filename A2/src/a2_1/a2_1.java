package a2_1;

public class a2_1 {

	public static void main(String[] args) {
		class Account {
		    private String fullName;
		    private String accountNumber;
		    private double balance;

		    // Constructor
		    public Account(String fullName, String accountNumber, double initialBalance) {
		        this.fullName = fullName;
		        this.accountNumber = accountNumber;
		        setBalance(initialBalance);
		    }

		    // Set balance with validation
		    private void setBalance(double balance) {
		        if (balance < 0) {
		            System.out.println("Hesap bakiyesi eksi olamaz. Lütfen geçerli bir bakiye girin.");
		            // Kullanıcıdan tekrar bakiye al
		            Scanner scanner = new Scanner(System.in);
		            System.out.print("Yeni bakiye girin: ");
		            double newBalance = scanner.nextDouble();
		            setBalance(newBalance); // Recursive call
		        } else {
		            this.balance = balance;
		        }
		    }

		    public double getBalance() {
		        return balance;
		    }

		    public String getFullName() {
		        return fullName;
		    }

		    public String getAccountNumber() {
		        return accountNumber;
		    }

		    public void depositMoney() {
		        Scanner scanner = new Scanner(System.in);
		        System.out.print("Ne kadar para yatırmak istersiniz? ");
		        double amount = scanner.nextDouble();
		        if (amount < 0) {
		            System.out.println("Yatırılacak miktar eksi olamaz.");
		        } else {
		            balance += amount;
		            System.out.println(amount + " TL yatırıldı.");
		            displayAccountInfo();
		        }
		    }

		    public void displayAccountInfo() {
		        System.out.println("Hesap Sahibi: " + fullName + ", Hesap Numarası: " + accountNumber + ", Bakiye: "
		}

	}

}
