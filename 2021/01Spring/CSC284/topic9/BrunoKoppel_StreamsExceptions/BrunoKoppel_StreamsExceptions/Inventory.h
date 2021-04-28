#pragma once

#include "Item.h"

class Inventory
{
public:
	Inventory();

	Item* itemStack;

	void addItemToInventory(Item newItem);
};

