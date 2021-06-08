//
//  IntegerNumberBinaryTree.cpp
//  BinaryTreeTest
//
//  Created by Bruno Koppel on 12/11/19.
//  Copyright © 2019 Bruno Koppel. All rights reserved.
//

#include "IntegerNumberBinaryTree.hpp"
#include <iostream>
#include <string>

using namespace std;

void IntegerNumberBinaryTree::createNode()
{
    binaryTree *newNode;
    insertNode(newNode, root);
}

void IntegerNumberBinaryTree::insertNode(binaryTree *&newNode, binaryTree *&nodeptr)
{
    if (nodeptr == nullptr)
    {
        nodeptr = newNode;
        int num = getIntegerFromUserInput("Enter value for new node: ");
        newNode->left = nullptr;
        newNode->right = nullptr;
    }
    else if (nodeptr->left)
    {
        insertNode(newNode, nodeptr->left);
    }
    else if (nodeptr->right)
    {
        insertNode(newNode, nodeptr->right);
    }
}

void IntegerNumberBinaryTree::deleteNode() const
{
    
}

void IntegerNumberBinaryTree::organizeTree() const
{
    
}

void IntegerNumberBinaryTree::displayNodes(binaryTree *nodeptr) const
{
    if (nodeptr)
    {
        cout << nodeptr->value;
    }
    else if (nodeptr->left)
    {
        displayNodes(nodeptr->left);
    }
    else if (nodeptr->right)
    {
        displayNodes(nodeptr->right);
    }
}

void IntegerNumberBinaryTree::displayNodes() const
{
    displayNodes(root);
}



int IntegerNumberBinaryTree::getIntegerFromUserInput(string prompt) const
{
    cout << prompt;
    int num;
    cin >> num;
    return num;
}
