// This program demonstrates nested loops.
#include <iostream>
using namespace std;

int main()
{
	int const NUM_ROWS = 4;
	int const NUM_COLS = 3;

	for (int row = 1; row <= NUM_ROWS; row++){  // outer
		for (int col = 1; col <= NUM_COLS; col++){  // inner
			cout << row << "," << col << "   ";
		}
		cout << endl;
	}

	system("pause");
	return 0;
}