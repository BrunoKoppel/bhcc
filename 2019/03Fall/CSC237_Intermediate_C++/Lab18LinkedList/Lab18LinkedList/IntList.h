//
//  IntList.h
//  Lab18LinkedList
//
//  Created by Bruno Koppel on 12/3/19.
//  Copyright © 2019 Bruno Koppel. All rights reserved.
//

#ifndef IntList_h
#define IntList_h

class IntList
{
private:
    
    struct ListNode
    {
        int value;
        struct ListNode *next;
    };
    
    ListNode *head;
    
public:
    IntList()
    {
        head = nullptr;
    }
    
    ~IntList();
    
    void appendNode(int);
    void insertNode(int);
    void deleteNode(int);
    void displayList() const;
};

#endif /* IntList_h */
