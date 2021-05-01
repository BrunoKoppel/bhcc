#include "Admin.h"


Admin::Admin()
{

}

void Admin::addItemsFromInventoryList(std::string fileName, std::vector<Item> itemStack)
{
    std::ifstream inputStream(fileName);
    if (inputStream.fail()) {
        throw std::invalid_argument("File not found");
    }

    std::string temp;
    while (inputStream >> temp) {
        itemStack.push_back(Item(temp));
    }
    if (!inputStream.eof()) {
        throw std::runtime_error("Reached end of line");
    }
}

void Admin::createInvoiceFromInventory(std::string fileName, std::vector<Item> itemStack)
{
    std::ofstream outputStream(fileName);

    if (outputStream.fail()) {
        throw std::invalid_argument("File couldn't open");
    }


    for (const auto& element : itemStack) {
        outputStream << element.itemName << std::endl;
    }

    outputStream.close();
}

Admin::~Admin()
{
}
