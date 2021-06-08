//
//  car.cpp
//  ClassExample
//
//  Created by cj on 9/17/14.
//  Copyright (c) 2014 KickinEspresso. All rights reserved.
//

#include "car.h"


//Constructor with Params
Car::Car(string manufacturer, int numDoors, int numWheels, Engine* engine){
    
    this->manufacturer = manufacturer;
    this->numDoors = numDoors;
    this->numWheels = numWheels;
    this->engine = engine;
}
//Deconstructor
Car::~Car(){
    
}


//Setters
void Car::setManufacturer(string manufacturer){
    this->manufacturer = manufacturer;
}
void Car::setNumDoors(int numDoors){
    this->numDoors = numDoors;
}
void Car::setNumWheels(int numWheels){
    this->numWheels = numWheels;
}
void Car::setEngine(Engine* engine){
    this->engine = engine;
}

//Getters
string Car::getManufacturer(){
    return this->manufacturer;
}
int Car::getNumDoors(){
    return this->numDoors;
}
int Car::getNumWheels(){
    return this->numWheels;
}
Engine* Car::getEngine(){
    return this->engine;
}
