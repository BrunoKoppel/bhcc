//package finalproject;

public class Employee {
    private int id;
    private String name;
    private String position;
    private String address;
    private String phoneNumber;
    private double hours;
    private double rate;
    private char sex;
    private int age;
    private boolean active;
    private String ssn;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String pos) {
        this.position = pos;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoNum) {
        this.phoneNumber = phoNum;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getSSN() {
        return ssn;
    }

    public void setSSN(String ssn) {
        this.ssn = ssn;
    }

    double calculateGrossPay() {
        return (hours * rate);
    }

    double calculateFederalTax() {
        double yearlyIncome = calculateGrossPay() * 52;
        double taxRate;

        if (yearlyIncome < 30000.00)
            taxRate = .28;
        else if (yearlyIncome < 50000.00)
            taxRate = .32;
        else
            taxRate = .38;

        return (calculateGrossPay() * taxRate);
    }

    double calculateStateTax() {
        return (calculateGrossPay() * .0561);
    }

    double calculateNetPay() {
        return (calculateGrossPay() - calculateFederalTax() - calculateStateTax());
    }

    //Note toString returns name only because it is used by the JList widget to populate
    //the users in the pick list.
    public String toString() {
        return name;
    }
}