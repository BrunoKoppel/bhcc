#include "Admin.h"


Admin::Admin()
{

}

std::vector<Item> Admin::addItemsFromInventoryList(std::string path, std::string fileName)
{
    std::ifstream inputStream(path + "\\" + fileName);
    if (inputStream.fail()) {
        throw std::invalid_argument("File not found");
    }

    std::cout << "Loading items" << std::endl;

    int x = 0;
    std::vector<Item> items;
    std::string temp;
    while (std::getline(inputStream, temp)) {
        items.push_back(Item(temp));
        std::cout << items.at(x).toString() << std::endl;
        x++;
    }
    if (!inputStream.eof()) {
        throw std::runtime_error("Reached end of line");
    }

    return items;
}

void Admin::createInvoiceFromInventory(std::string path, std::string fileName, std::vector<Item> itemStack)
{
    std::ofstream outputStream(path + "\\" + fileName, std::ofstream::app);

    if (outputStream.fail()) {
        throw std::invalid_argument("File couldn't open");
    }

    std::cout << "Writing invoice " << static_cast<int>(itemStack.size()) << std::endl;

    for (int x = 0; x < itemStack.size(); x++) {
        outputStream << itemStack.at(x).itemName << std::endl;
        outputStream.flush();
        std::cout << itemStack.at(x).itemName << std::endl;
    }

    
    outputStream.close();
}

Admin::~Admin()
{
}
