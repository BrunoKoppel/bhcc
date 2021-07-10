package com.haley.pk2;
public class Customer extends CD implements CD_Iface{
public String name;
public String address;
public double deposit;


// the implementing class must define the calc_interest method
// or must itself be declared as abstract !!!!

public double calc_interest()
{

// we will use the simple formula I = P * R * T;

//System.out.println(" the amount of interest earned is " + (deposit *  interest_rate * months/12));

return (deposit * interest_rate * months/12);

}//calc_interest


}// class Customer
