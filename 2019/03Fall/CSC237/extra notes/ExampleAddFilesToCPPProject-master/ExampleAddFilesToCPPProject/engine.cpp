//
//  engine.cpp
//  ClassExample
//
//  Created by cj on 10/14/14.
//  Copyright (c) 2014 KickinEspresso. All rights reserved.
//

#include "engine.h"


Engine::Engine(){
    //Defaults
    this->numCyclinders = 0;
}

Engine::Engine(int numCyclinders, int horsePower, float liters, float milesPerGallon){
    this->numCyclinders = numCyclinders;
    this->horsePower = horsePower;
    this->liters = liters;
    this->milesPerGallon = milesPerGallon;
}
Engine::~Engine(){
}

//setters
void Engine::setNumCyclinders(int numCyclinders){
    this->numCyclinders = numCyclinders;
}
void Engine::setHorsePower(int horsePower){
    this->horsePower = horsePower;
}
    
void Engine::setLiters(float liters){
    this->liters = liters;
}
void Engine::setMilesPerGallon(float milesPerGallon){
    this->milesPerGallon = milesPerGallon;
}

//getters
int Engine::getNumCyclinders(){
    return this->numCyclinders;

}
int Engine::getHorsePower(){
    return this->horsePower;
}
float Engine::getLiters(){
    return this->liters;

}
float Engine::getMilesPerGallon(){
    return this->milesPerGallon;
}
