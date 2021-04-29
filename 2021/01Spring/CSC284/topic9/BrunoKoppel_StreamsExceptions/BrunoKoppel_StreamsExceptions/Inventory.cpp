#include "Inventory.h"

Inventory::Inventory()
{

}

void Inventory::addItemToInventory(Item newItem)
{
	itemStack.push_back(newItem);
}
