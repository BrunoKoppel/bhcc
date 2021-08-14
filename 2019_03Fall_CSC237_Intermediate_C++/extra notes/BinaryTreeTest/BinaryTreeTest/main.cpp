//
//  main.cpp
//  BinaryTreeTest
//
//  Created by Bruno Koppel on 12/11/19.
//  Copyright © 2019 Bruno Koppel. All rights reserved.
//

#include "IntegerNumberBinaryTree.hpp"
#include <iostream>
#include <string>

using namespace std;

char getCommandFromUserInput(string prompt);

int main(int argc, const char * argv[]) {
    
    bool machineState = true;
    IntegerNumberBinaryTree *tree;
    
    while (machineState)
    {
        char command = getCommandFromUserInput("Enter a command: ");
        
        if (command == 'c')
        {
            tree->createNode();
        }
        else if (command == 'd')
        {
            tree->deleteNode();
        }
        else if (command == 'o')
        {
            tree->organizeTree();
        }
        else if (command == 'p')
        {
            tree->displayNodes();
        }
        
    }
    
    return 0;
}

char getCommandFromUserInput(string prompt)
{
    cout << prompt;
    char letter;
    cin >> letter;
    return letter;
}
