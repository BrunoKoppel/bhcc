//
//  IntList.cpp
//  Lab20
//
//  Created by Bruno Koppel on 12/7/19.
//  Copyright © 2019 Bruno Koppel. All rights reserved.
//

#include "IntList.hpp"
#include <stdio.h>
#include <iostream>
#include <iomanip>

using namespace std;

void IntList::appendNode(int num)
{
    ListNode *newNode;
    ListNode *nodePtr;
    
    newNode = new ListNode;
    newNode->value = num;
    newNode->next = nullptr;
    newNode->previous = nullptr;
    
    if (!head)
    {
        head = newNode;
        head->next = nullptr;
        head->previous = nullptr;
    }
    else
    {
        nodePtr = head;
        
        while (nodePtr->next)
        {
            nodePtr = nodePtr->next;
        }
        
        nodePtr->next = newNode;
        newNode->next = nullptr;
        newNode->previous = nodePtr;
        
    }
}

void IntList::insertNode(int num)
{
    ListNode *newNode;
    ListNode *nodePtr;
    ListNode *previousNode = nullptr;

    newNode = new ListNode;
    newNode->value = num;
    
    if (!head)
    {
        head = newNode;
        newNode->next = nullptr;
        newNode->previous = nullptr;
    }
    else
    {
        nodePtr = head;
        
        previousNode = nullptr;
        
        while (nodePtr != nullptr && nodePtr->value < num)
        {
            previousNode = nodePtr;
            nodePtr = nodePtr->next;
        }
        
        if (nodePtr == nullptr)
        {
            nodePtr = newNode;
            previousNode->next = newNode;
            newNode->next = nullptr;
            nodePtr->next = nullptr;
            nodePtr->previous = previousNode;
            newNode->previous = previousNode;
        }
        else if (nodePtr == head)
        {
            head = newNode;
            nodePtr->previous = newNode;
            newNode->next = nodePtr;
            newNode->previous = nullptr;
        }
        else
        {
            nodePtr->previous = newNode;
            newNode->next = nodePtr;
            newNode->previous = previousNode;
            if (previousNode != nullptr)
            {
                previousNode->next = newNode;
            }
        }
    }
}

void IntList::deleteNode(int num)
{
    ListNode *nodePtr;
    ListNode *previousNode = nullptr;
    
    if(!head)
        return;
    
    if (head->value == num)
    {
        nodePtr = head->next;
        delete head;
        head = nodePtr;
    }
    else
    {
        nodePtr = head;
        
        while (nodePtr != nullptr && nodePtr->value != num)
        {
            previousNode = nodePtr;
            nodePtr = nodePtr->next;
        }
        
        if (nodePtr)
        {
            previousNode->next = nodePtr->next;
            previousNode = nodePtr;
            nodePtr = nodePtr->next;
            if (nodePtr != nullptr)
            {
                nodePtr->previous = previousNode->previous;
            }
            delete previousNode;
        }
        else
        {
            cout << "The number you are trying to delete is not part of the list." << endl;
        }
    }
}

void IntList::printListRecursively()
{
    ListNode *nodePtr;
    
    nodePtr = head;
    cout << "Recursive print of list, ";
    cout << dec << "head = " << hex << nodePtr << endl;
    
    printListRecursivelyMechanism(nodePtr);

    cout << dec << endl;
}

void IntList::printListRecursivelyMechanism(ListNode *nodePtr)
{
    if (nodePtr == nullptr)
    {
        
    }
    else
    {
        ListNode *currentPtr = nodePtr;
        cout << hex << currentPtr << dec << ":\tvalue = " << setw(5) << currentPtr->value;
        currentPtr = currentPtr->next;
        cout << " next = " << hex << currentPtr << endl;
        printListRecursivelyMechanism(currentPtr);
    }
}

void IntList::printListBackwards()
{
    ListNode *nodePtr = head;
    cout << "BACKWARDS recursive print of list, head = ";
    cout << hex << nodePtr << endl;
    while (nodePtr->next)
    {
        nodePtr = nodePtr->next;
    }
    printListBackwardsMechanism(nodePtr);
}

void IntList::printListBackwardsMechanism(ListNode *nodePtr)
{
    if (nodePtr == nullptr)
    {
        
    }
    else
    {
        cout << hex << nodePtr << dec << ":\tvalue = " << setw(5) << nodePtr->value;
        cout << " next = " << hex << nodePtr->next;
        cout << dec << "\t, previous = " << hex << nodePtr->previous << endl;
        nodePtr = nodePtr->previous;
        printListBackwardsMechanism(nodePtr);
    }
}

int IntList::countNodesRecursively()
{
    ListNode *nodePtr = head;
    cout << "Number of nodes in list, head = ";
    cout << hex << nodePtr;
    
    setSum(0);
    countNodes(nodePtr);
    return getSum();
}

void IntList::countNodes(ListNode *nodePtr)
{
    if (nodePtr != nullptr)
    {
        setSum(getSum() + 1);
        nodePtr = nodePtr->next;
        countNodes(nodePtr);
    }
}

int IntList::calculateTotalSumOfNodes()
{
    ListNode *nodePtr = head;
    cout << "Total of all value fields in list, head = ";
    cout << hex << nodePtr;
    
    setTotalSum(0);
    calculateTotalSumOfNodesMechanism(nodePtr);
    return getTotalSum();
}

void IntList::calculateTotalSumOfNodesMechanism(ListNode *nodePtr)
{
    if (nodePtr != nullptr)
    {
        int numHolder = nodePtr->value;
        setTotalSum(getTotalSum() + numHolder);
        nodePtr = nodePtr->next;
        calculateTotalSumOfNodesMechanism(nodePtr);
    }
}

void IntList::displayList() const
{
    ListNode *nodePtr;
    
    nodePtr = head;
    cout << dec << "head = " << hex << nodePtr << endl;
    while(nodePtr)
    {
        cout << hex << nodePtr << dec << ":\tvalue = " << setw(5) << nodePtr->value;
        
        cout << " next = " << hex << nodePtr->next;
        cout << dec << "\t, previous = " << hex << nodePtr->previous << endl;
        nodePtr = nodePtr->next;
    }
    cout << dec << endl;
}

IntList::~IntList()
{
    ListNode *nodePtr;
    ListNode *nextNode;
    
    nodePtr = head;
    
    while (nodePtr != nullptr)
    {
        
        nextNode = nodePtr->next;
        delete nodePtr;
        nodePtr = nextNode;
    }
}
