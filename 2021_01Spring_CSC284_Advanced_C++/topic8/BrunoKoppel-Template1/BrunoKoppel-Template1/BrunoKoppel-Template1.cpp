// BrunoKoppel-Template1.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
template<typename T1, typename T2> 
auto swap(T1& t1, T2& t2) {
    T1 temp;
    temp = t1;
    t1 = t2;
    t2 = temp;
}


void shortSwap(short& min, short& max) {
    short temp;
    temp = min;
    min = max;
    max = temp;
}
void doubleSwap(double& min, double& max) {
    double temp;
    temp = min;
    min = max;
    max = temp;
}
void charSwap(char& min, char& max) {
    char temp;
    temp = min;
    min = max;
    max = temp;
}

int main()
{
    int x = 4;
    int y = 2;
    std::cout << "Swapping x = " << x << ", with y = " << y << std::endl;
    swap(x, y);
    std::cout << "Checking x = " << x << ", and y = " << y << std::endl;

    char a = 't';
    char b = 'u';
    std::cout << "Swapping a = " << a << ", with b = " << b << std::endl;
    swap(a, b);
    std::cout << "Checking a = " << a << ", and b = " << b << std::endl;

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
