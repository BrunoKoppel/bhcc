// This class has overloaded constructors.
#ifndef INVENTORYITEM_H
#define INVENTORYITEM_H
#include <string>
#include <sstream>
#include <iostream>
#include <iomanip>
using namespace std;

/*
*****************************************************************************
*                                                                           *
* Class functions were not altered as I saw that there was not need for it  *
*                                                                           *
*****************************************************************************
*/

class InventoryItem
{
private:
   string description; // The item description
   double cost;        // The item cost
   int units;          // Number of units on hand
public:
    
    
   // Constructor #1
   InventoryItem()
      { // Initialize description, cost, and units.
		description = "";
        cost = 0.0;
        units = 0; }

   // Constructor #2
   InventoryItem(string desc)
      { // Assign the value to description.
        description = desc;
        
        // Initialize cost and units.
        cost = 0.0;
        units = 0; }
        
   // Constructor #3
   InventoryItem(string desc, double c, int u)
      { // Assign values to description, cost, and units.
		description = desc;
        cost = c;
        units = u; }

    string printDetails()
    {
        stringstream info;
        info << setw(40) << left << getDescription() << setw(10) << getCost() << setw(10) << getUnits() << endl;
        return info.str();
    }
    
   // Mutator functions
   void setDescription(string d) 
      { description = d; }

   void setCost(double c)
      { cost = c; }
      
   void setUnits(int u)
      { units = u; }

   // Accessor functions
   string getDescription() const
      { return description; }
         
   double getCost() const
      { return cost; }

   int getUnits() const
      { return units; }
    
    
};
#endif
