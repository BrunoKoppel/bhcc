//
//  engine.h
//  ClassExample
//
//  Created by cj on 10/14/14.
//  Copyright (c) 2014 KickinEspresso. All rights reserved.
//

#ifndef __ClassExample__engine__
#define __ClassExample__engine__


#include <iostream>
#include <string>

using namespace std;

class Engine{
    
private:
    
    int numCyclinders;
    int horsePower;
    float liters;
    float milesPerGallon;
    
public:
    
    Engine();
    Engine(int numCyclinders, int horsePower, float liters, float milesPerGallon);
    ~Engine();
    
    //setters
    void setNumCyclinders(int numCyclinders);
    void setHorsePower(int horsePower);
    void setLiters(float liters);
    void setMilesPerGallon(float milesPerGallon);
    
    //getters
    int getNumCyclinders();
    int getHorsePower();
    float getLiters();
    float getMilesPerGallon();
    
    
};

#endif /* defined(__SueClassExample__engine__) */
