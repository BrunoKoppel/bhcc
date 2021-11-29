#pragma once

#include <string>
#include <vector>

class Item
{
public:
	Item();
	Item(std::string newItemName);
	~Item();

	std::string itemName;

	std::string toString();
};

