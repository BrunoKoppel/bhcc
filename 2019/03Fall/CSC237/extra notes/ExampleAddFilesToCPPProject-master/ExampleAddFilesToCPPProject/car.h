//
//  car.h
//  ClassExample
//
//  Created by cj on 9/17/14.
//  Copyright (c) 2014 KickinEspresso. All rights reserved.
//

#ifndef __ClassExample__car__
#define __ClassExample__car__

#include <iostream>
#include <string>
#include "engine.h"

using namespace std;
class Car {
    
private:
    string manufacturer;
    int numDoors;
    int numWheels;
    Engine* engine;
    
    
public:
    
    Car(string manufacturer, int numDoors, int numWheels, Engine* engine); //Constructor with Params
    ~Car(); //Deconstructor
    
    //Setters
    void setManufacturer(string manufacturer);
    void setNumDoors(int numDoors);
    void setNumWheels(int numWheels);
    void setEngine(Engine* engine);
    
    //Getters
    string getManufacturer();
    int getNumDoors();
    int getNumWheels();
    Engine* getEngine();
    
};

#endif /* defined(__SueClassExample__car__) */
