//
//  MyClass.cpp
//  ExampleAddFilesToCPPProject
//
//  Created by cj on 9/9/17.
//  Copyright © 2017 KickinEspresso. All rights reserved.
//

#include <iostream>
#include "MyClass.hpp"

MyClass::MyClass(){
    std::cout << "Constructor has run\n";
}

MyClass::~MyClass(){
    std::cout << "Deconstructor has run\n";
}

void MyClass::someFunction(){
    std::cout << "Some Function was called\n";
    this->somePrivateFunction();
}

void MyClass::somePrivateFunction(){
    std::cout << "Some Private Function was called\n";
}
