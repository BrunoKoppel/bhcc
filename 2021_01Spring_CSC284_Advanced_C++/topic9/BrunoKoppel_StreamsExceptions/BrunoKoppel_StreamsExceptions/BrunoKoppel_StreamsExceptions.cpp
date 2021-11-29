// BrunoKoppel_StreamsExceptions.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <Windows.h>
#include <clocale>
#include <locale>
#include "Inventory.h"
#include "Item.h"
#include "Admin.h"

std::wstring ExePath() {
    TCHAR buffer[MAX_PATH] = { 0 };
    GetModuleFileName(NULL, buffer, MAX_PATH);
    std::wstring::size_type pos = std::wstring(buffer).find_last_of(L"\\/");
    return std::wstring(buffer).substr(0, pos);
}

int main()
{
    //TCHAR pwd[MAX_PATH];
    //GetCurrentDirectory(MAX_PATH, pwd);
    //MessageBox(NULL, pwd, pwd, 0);

    std::setlocale(LC_ALL, "");
    const std::wstring ws = ExePath();
    const std::locale locale("");
    typedef std::codecvt<wchar_t, char, std::mbstate_t> converter_type;
    const converter_type& converter = std::use_facet<converter_type>(locale);
    std::vector<char> to(ws.length() * converter.max_length());
    std::mbstate_t state;
    const wchar_t* from_next;
    char* to_next;
    const converter_type::result result = converter.out(state, ws.data(), ws.data() + ws.length(), from_next, &to[0], &to[0] + to.size(), to_next);
    const std::string path(&to[0], to_next);
    std::cout << path << std::endl;

    const std::string inputFileName = "InventoryList.txt";
    const std::string outputFileName = "Invoice.txt";
    std::vector<Item> itemStack;
    Admin administrator;
    
    try {
        itemStack = administrator.addItemsFromInventoryList(path, inputFileName);
    }
    catch (const std::invalid_argument& e) {
        std::cout << "Unable to open file " << inputFileName << std::endl;
        std::cout << e.what() << std::endl;
        return 1;
    }
    catch (const std::runtime_error& e) {
        std::cout << "Error reading file " << inputFileName << std::endl;
        std::cout << e.what() << std::endl;
        return 1;
    }

    try {
        administrator.createInvoiceFromInventory(path, outputFileName, itemStack);
        
    }
    catch (const std::invalid_argument& e) {
        std::cout << "Unable to open file " << outputFileName << std::endl;

        return 1;
    }
        
    return 0;
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
