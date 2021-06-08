//
//  IntList.cpp
//  Lab18LinkedList
//
//  Created by Bruno Koppel on 12/3/19.
//  Copyright © 2019 Bruno Koppel. All rights reserved.
//
#include "IntList.h"
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
    
    if (!head)
    {
        head = newNode;
    }
    else
    {
        nodePtr = head;
        
        while (nodePtr->next)
            nodePtr = nodePtr->next;
        
        nodePtr->next = newNode;
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
        
        if (previousNode == nullptr)
        {
            head = newNode;
            newNode->next = nodePtr;
        }
        else
        {
            previousNode->next = newNode;
            newNode->next = nodePtr;
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
            delete nodePtr;
        }
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
        nodePtr = nodePtr->next;
        cout << " next = " << hex << nodePtr << endl;
        
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
