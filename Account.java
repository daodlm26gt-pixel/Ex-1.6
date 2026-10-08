public class Account {
    private String id;
    private String name;
    private int balance = 0;

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    public String getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    // Nạp tiền vào tài khoản
    public int credit(int amount) {
        this.balance += amount;
        return this.balance;
    }

    // Rút tiền khỏi tài khoản
    public int debit(int amount) {
        if (amount <= balance) {
            this.balance -= amount;
        } else {
            System.out.println("Amount exceeded balance");
        }
        return this.balance;
    }

    // Chuyển tiền sang tài khoản khác
    public int transferTo(Account another, int amount) {
        if (amount <= balance) {
            this.debit(amount);      // Hoặc: this.balance -= amount;
            another.credit(amount);  // Hoặc: another.balance += amount;
        } else {
            System.out.println("Amount exceeded balance");
        }
        return this.balance;
    }

    // Phương thức trả về chuỗi thông tin tài khoản
    @Override
    public String toString() {
        return "Account[id=" + id + ",name=" + name + ",balance=" + balance + "]";
    }
}