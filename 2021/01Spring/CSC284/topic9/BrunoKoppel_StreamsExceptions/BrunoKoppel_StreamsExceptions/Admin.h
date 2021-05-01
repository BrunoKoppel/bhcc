#pragma once
#include "Item.h"
#include <iostream>
#include <fstream>
#include <stdexcept>

class Admin
{
public:
	Admin();
	void addItemsFromInventoryList(std::string, std::vector<Item>);
	void createInvoiceFromInventory(std::string, std::vector<Item>);
	~Admin();
};