// ClassNotes.cpp : This file contains the 'main' function. Program execution begins and ends there.

// Structure BIndings

#include <iostream>
#include <array>
using namespace std;

struct Point {
	double mX, mY, mZ;
};

int main()
{
	array<int, 4> values = { 1, 2, 3, 4 };
	auto [x, y, z, q] = value;

	Point point;
	point.mX = 1.0;
	point.mY = 2.0;
	point.mZ = 3.0;

	auto [xp, yp, zp] = point;
	
	return 0;
}
