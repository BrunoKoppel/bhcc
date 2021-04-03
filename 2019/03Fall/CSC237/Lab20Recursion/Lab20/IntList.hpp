//
//  IntList.hpp
//  Lab20
//
//  Created by Bruno Koppel on 12/7/19.
//  Copyright © 2019 Bruno Koppel. All rights reserved.
//

#ifndef IntList_hpp
#define IntList_hpp

#include <stdio.h>

class IntList
{
private:
    
    int sum;
    int totalSum;
    struct ListNode
    {
        int value;
        struct ListNode *next;
        struct ListNode *previous;
    };
    
    ListNode *head;
    
public:
    IntList()
    {
        head = nullptr;
    }
    
    ~IntList();
    
    void setSum(int num)
    {
        sum = num;
    }
    int getSum() const
    {
        return sum;
    }
    
    
    
    void setTotalSum(int num)
    {
        totalSum = num;
    }
    int getTotalSum() const
    {
        return totalSum;
    }
    
    
    
    
    void appendNode(int);
    void insertNode(int);
    void deleteNode(int);
    
    void printListRecursively();
    void printListRecursivelyMechanism(ListNode *nodePtr);
    
    void printListBackwards();
    void printListBackwardsMechanism(ListNode *nodePtr);
    
    int countNodesRecursively();
    void countNodes(ListNode *nodePtr);
    
    int calculateTotalSumOfNodes();
    void calculateTotalSumOfNodesMechanism(ListNode *nodePtr);
    
    void displayList() const;
};

#endif /* IntList_hpp */
