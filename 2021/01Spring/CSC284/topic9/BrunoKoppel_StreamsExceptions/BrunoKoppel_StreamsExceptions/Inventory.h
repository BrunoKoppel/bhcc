#pragma once

#include "Item.h"


class Inventory
{
public:
	Inventory();

	std::vector <Item> itemStack;

	void addItemToInventory(Item newItem);
};

