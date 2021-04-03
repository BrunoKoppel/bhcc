//
//  main.cpp
//  ExampleAddFilesToCPPProject
//
//  Created by cj on 9/9/17.
//  Copyright © 2017 KickinEspresso. All rights reserved.
//

#include <iostream>
#include "MyClass.hpp"
#include "engine.h"
#include "car.h"

int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    
    MyClass* myClass = new MyClass();
    myClass->someFunction();
    
    //myClass->somePrivateFunction();
    
    Engine* chevyEngine = new Engine(1, 2, 3.0, 4.0);
    std::cout << "liters: " << chevyEngine->getLiters() << std::endl;
    Car* chevy = new Car("Totally Not Chevy", 2, 3, chevyEngine);
    
    string manufacturer = chevy->getManufacturer();
    std::cout << "manuf: " << manufacturer<< std::endl;
    
    
    Engine* myengine  = chevy->getEngine();
    std::cout << "mpg: " << myengine->getMilesPerGallon() << std::endl;
    
    
    std::cout << "Ending\n";
    
    return 0;
}
