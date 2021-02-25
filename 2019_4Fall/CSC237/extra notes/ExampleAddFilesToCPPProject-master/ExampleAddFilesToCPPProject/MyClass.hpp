//
//  MyClass.hpp
//  ExampleAddFilesToCPPProject
//
//  Created by cj on 9/9/17.
//  Copyright © 2017 KickinEspresso. All rights reserved.
//

#ifndef MyClass_hpp
#define MyClass_hpp

#include <stdio.h>

class MyClass{
    
public:
    
    int myAttribute;
    MyClass();
    ~MyClass();
    
    void someFunction();
    
private:
    
    void somePrivateFunction();
    
};

#endif /* MyClass_hpp */
