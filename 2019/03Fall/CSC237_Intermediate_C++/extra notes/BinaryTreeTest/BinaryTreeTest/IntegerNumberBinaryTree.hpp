//
//  IntegerNumberBinaryTree.hpp
//  BinaryTreeTest
//
//  Created by Bruno Koppel on 12/11/19.
//  Copyright © 2019 Bruno Koppel. All rights reserved.
//

#ifndef IntegerNumberBinaryTree_hpp
#define IntegerNumberBinaryTree_hpp

#include <stdio.h>
#include <string>

using namespace std;

class IntegerNumberBinaryTree
{
    private:

    struct binaryTree {
        
        int value;
        binaryTree *left;
        binaryTree *right;
    };
    
    binaryTree *root = nullptr;
    
    void displayNodes(binaryTree *nodeptr) const;
    
    public:
    
    void createNode();
    void insertNode(binaryTree *&newNode, binaryTree *&nodeptr);

    void deleteNode() const;
    void organizeTree() const;
    void displayNodes() const;
    int getIntegerFromUserInput(string prompt) const;

};

#endif /* IntegerNumberBinaryTree_hpp */
