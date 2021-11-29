#pragma once
#include "Item.h"
#include <iostream>
#include <fstream>
#include <stdexcept>

class Admin
{
public:
	Admin();
	std::vector<Item> addItemsFromInventoryList(std::string, std::string);
	void createInvoiceFromInventory(std::string, std::string, std::vector<Item>);
	~Admin();
};