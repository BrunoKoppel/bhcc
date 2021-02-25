#include <iostream>
#include <string>
#include "enum.h"

int askUserIntegerInput(std::string);
std::string returnWeekDayGivenTheNumber(int);
std::string returnMonthGivenTheNumber(int);
void calculateWeekDayGivenDate();

const bool VERBOSE = true;

int main()
{
    bool machineState = true;
    
    while (machineState) {
        calculateWeekDayGivenDate();
    }
}

int askUserIntegerInput(std::string prompt) {
    int number;
    std::cout << prompt;
    std::cin >> number;
    return number;
};

std::string returnWeekDayGivenTheNumber(int number) {
    switch (number) {
        case static_cast<int>(WeekDay::Sunday) :
            return "Sunday";
            break;
        case static_cast<int>(WeekDay::Monday) :
            return "Monday";
            break;
        case static_cast<int>(WeekDay::Tuesday) :
            return "Tuesday";
            break;
        case static_cast<int>(WeekDay::Wednesday) :
            return "Wednesday";
            break;
        case static_cast<int>(WeekDay::Thursday) :
            return "Thursday";
            break;
        case static_cast<int>(WeekDay::Friday) :
            return "Friday";
            break;
        case static_cast<int>(WeekDay::Saturday) :
            return "Saturday";
            break;
    };
};

std::string returnMonthGivenTheNumber(int number) {
    switch (number) {
        case static_cast<int>(Month::March): 
            return "March";
            break;
        case static_cast<int>(Month::April): 
            return "April";
            break;
        case static_cast<int>(Month::May) : 
            return "May";
            break;
        case static_cast<int>(Month::June) : 
            return "June";
            break;
        case static_cast<int>(Month::July) : 
            return "July";
            break;
        case static_cast<int>(Month::August) : 
            return "August";
            break;
        case static_cast<int>(Month::September) : 
            return "September";
            break;
        case static_cast<int>(Month::October) :
            return "October";
            break;
        case static_cast<int>(Month::November) :
            return "November";
            break;
        case static_cast<int>(Month::December) :
            return "December";
            break;
        case static_cast<int>(Month::January) :
            return "January";
            break;
        case static_cast<int>(Month::February) :
            return "February";
            break;
    }
}
void calculateWeekDayGivenDate()
{
    std::cout << "\nEnter your birthday in the format (MM/DD/YYYY): " << std::endl;

    int m, month;
    m = month = askUserIntegerInput("Month (MM): ");
    int d, day;
    d = day = askUserIntegerInput("Day (DD): ");
    int y, year;
    y = year = askUserIntegerInput("Year (YYYY): ");

    if (m > 2) {
        m = m - 2;
    }
    else {
        m = m + 10;
        y = y - 1;
    }

    int c = year / 100;
    int v1 = static_cast<int>((2.6 * m) - 0.2);
    int v2 = static_cast<int>((y % 100) / 4);
    int v3 = static_cast<int>(c / 4);

    int weekDay = (d + y%100 - (2 * c) + v1 + v2 + v3) % 7;

    if (VERBOSE) {
        std::cout << "User Input Values:" << std::endl;
        std::cout << "Month = " << month << std::endl;
        std::cout << "Day = " << day << std::endl;
        std::cout << "Year = " << year << std::endl;
        std::cout << "------------------" << std::endl;
        std::cout << "Computed Values:" << std::endl;
        std::cout << "Month = " << m << std::endl;
        std::cout << "Day = " << d << std::endl;
        std::cout << "Year = " << y << std::endl;
        std::cout << "Century = " << c << std::endl;
        std::cout << "Week Day = " << weekDay << std::endl;
        std::cout << "Value #1 = " << v1 << std::endl;
        std::cout << "Value #2 = " << v2 << std::endl;
        std::cout << "Value #3 = " << v3 << std::endl;
    }

    std::cout << returnMonthGivenTheNumber(m - 1) << " " << day << ", " << year <<
        " was a " << returnWeekDayGivenTheNumber(weekDay) << std::endl;
}
;