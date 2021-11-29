// BrunoKoppel-Template2.cpp.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <cmath>

template<typename T1, typename T2>
auto swap(T1& t1, T2& t2) {
    T1 temp;
    temp = t1;
    t1 = t2;
    t2 = temp;
}



short randBetweenShorts(short min, short max) {
    if (max < min) swap(max, min);
    return((rand() % (max - min + 1)) + min);
}

int randBetweenIntegers(int min, int max) {
    if (max < min) swap(max, min);
    return((rand() % (max - min + 1)) + min);
}

double randBetweenDouble(double min, double max) {
    if (max < min) swap(max, min);
    int imin = min * 100;
    int imax = max * 100;
    double num = (rand() % (imax - imin + 1)) + min;
    num /= 100.;
    return(num);
}

char randBetweenChars(char min, char max) {
    if (max < min) swap(max, min);
    char value;
    do {
        value = (rand() % (max - min + 1)) + min;
    } while (value >= 91 && value <= 96);
    return(value);
}

template<typename T1, typename T2>
auto randBetween(T1& min, T2& max) {
    std::cout << typeid(min).name() << std::endl;
    if (max < min) swap(max, min);

    T1 value;
    
    if (typeid(min).name() == "double") {
        int imin = min * 100;
        int imax = max * 100;
        value = std::fmod(rand(), (imax - imin + 1)) + min;
        value /= 100.;
    } 
    
    if (typeid(min).name() == "char") {
        do {
            value = std::fmod(rand(), (max - min + 1)) + min;
        } while (value >= 91 && value <= 96);
    }
    
    
    value = (std::fmod(rand(),(max - min + 1)) + min);
    
    return value;
}

int main()
{
    srand(time(NULL));
    short s_a = 1;
    short s_b = 3;
    short s_r = randBetween(s_a, s_b);
    std::cout << "result from random short = " << s_r << std::endl;

    int i_a = 1231;
    int i_b = 344423;
    int i_r = randBetween(i_a, i_b);
    std::cout << "result from random integer = " << i_r << std::endl;

    double d_a = 1.231;
    double d_b = 3.44423;
    double d_r = randBetween(d_a, d_b);
    std::cout << "result from random double = " << d_r << std::endl;

    char c_a = 'A';
    char c_b = 'z';
    char c_r = randBetween(c_a, c_b);
    std::cout << "result from random char = " << c_r << std::endl;
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
