package com.udemy.javaTutorials;

public class StudentDatabase {
    public static void main(String[] args) {
       Student s1 = new Student("Kruthi", "1GA14EC054");

       s1.enroll("Machine Learning");
       s1.enroll("Java Development");
       s1.pay(150);
       s1.showCourse();
       s1.checkBalance();
       s1.pay(200);
       s1.checkBalance();

    }
}

class Student {
    private String studentName;
    private String ssn;
    private String email;
    private String phoneNumber;
    private String city;
    private String state;
    private String userID;
    private String courses;
    private static int ID = 1000;
    private double balance=0.0;
    private static final double enrollmentFees  = 800;

    //Constructor
    public Student(String studentName,String ssn){
        this.studentName = studentName;
        this.ssn = ssn;
        setEmail();
        ID++;
        generateUserID();
    }

    //getter and setter for phone Number
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //getter and setter for City
    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    //getter and setter for State
    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    private void setEmail(){
        this.email = studentName.toLowerCase()+ID+ "@gmail.com";
        System.out.println("Your email ID: " + this.email );
    }

    public String getEmail(){
        return email;
    }

    private void generateUserID(){
        long random = Math.round(Math.random()*9000);
        if ( random < 1000)
            random = random+1000;

        int len = ssn.length();
        userID = ID +""+ random + ssn.substring(len-4);
        System.out.println("Your UserID: " + userID);
    }

    public String getUserID(){
        return userID;
    }
    //Methods
    public void enroll(String courseName){
        if (courses != null)
            this.courses = this.courses + "\n" + courseName;
        else
            this.courses = courseName;
           System.out.println("Course Enrolled: " + courseName);
            balance =balance+enrollmentFees;
    }

    public void pay(double amount){
        balance = balance - amount;
                if ( balance > 0 )
                    System.out.println("you have paid $" + amount + ".your should pay: $" + balance +" more");
                else
                    System.out.println("Thanks for paying: " + amount);
    }

    public double checkBalance(){
        return balance;
    }

    public void showCourse(){

        System.out.println("Your Courses:" + "\n"+this.courses);
    }
    }


