//
//  main.cpp
//  testMainArguments
//
//  Created by Bruno Koppel on 12/9/19.
//  Copyright © 2019 Bruno Koppel. All rights reserved.
//

#include <iostream>
#include <cmath>

using namespace std;

int main(int argc, const char * argv[]) {
    cout << "You entered " << (argc);
    argc++;
    cout << " command line arguments.\n";
    if (argc > 1)
    {
        cout << "Here they are:\n";
        for (int count = 1; count < argc; count++)
                 cout << argv[count] << endl;
    }
    
    double total = 0;
    if (argc > 1)
    {
        for (int count = 1; count < argc; count++)
        {
            total += atof(argv[count]);
        }
        cout << total << endl;
    }
    
    return 0;
}
