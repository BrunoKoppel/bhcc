#include "Item.h"

Item::Item()
{
	this->itemName = "";
}

Item::Item(std::string newItemName)
{
	this->itemName = newItemName;
}

Item::~Item()
{
	delete this;
}


std::string Item::toString()
{
	return "Item => " + this->itemName;
}
