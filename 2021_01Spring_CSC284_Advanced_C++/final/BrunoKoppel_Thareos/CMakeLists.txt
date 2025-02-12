cmake_minimum_required(VERSION 3.5)

project(BrunoKoppel_Thareos LANGUAGES CXX)

set(CMAKE_INCLUDE_CURRENT_DIR ON)

set(CMAKE_AUTOUIC ON)
set(CMAKE_AUTOMOC ON)
set(CMAKE_AUTORCC ON)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# QtCreator supports the following variables for Android, which are identical to qmake Android variables.
# Check http://doc.qt.io/qt-5/deployment-android.html for more information.
# They need to be set before the find_package(Qt5 ...) call.

#if(ANDROID)
#    set(ANDROID_PACKAGE_SOURCE_DIR "${CMAKE_CURRENT_SOURCE_DIR}/android")
#    if (ANDROID_ABI STREQUAL "armeabi-v7a")
#        set(ANDROID_EXTRA_LIBS
#            ${CMAKE_CURRENT_SOURCE_DIR}/path/to/libcrypto.so
#            ${CMAKE_CURRENT_SOURCE_DIR}/path/to/libssl.so)
#    endif()
#endif()

find_package(QT NAMES Qt6 Qt5 COMPONENTS Widgets LinguistTools REQUIRED)
find_package(Qt${QT_VERSION_MAJOR} COMPONENTS Widgets LinguistTools REQUIRED)

set(TS_FILES BrunoKoppel_Thareos_en_US.ts)

set(PROJECT_SOURCES
        main.cpp
        checklistwindow.cpp
        checklistwindow.h
        checklistwindow.ui
        loginwindow.cpp
        loginwindow.h
        loginwindow.ui
        CreateNewAccountWindow.cpp
        CreateNewAccountWindow.h
        CreateNewAccountWindow.ui
        user.cpp
        user.h
        taskItem.cpp
        taskItem.h

        ${TS_FILES}
)

if(${QT_VERSION_MAJOR} GREATER_EQUAL 6)
    qt_add_executable(BrunoKoppel_Thareos
        ${PROJECT_SOURCES}
    )
else()
    if(ANDROID)
        add_library(BrunoKoppel_Thareos SHARED
            ${PROJECT_SOURCES}
        )
    else()
        add_executable(BrunoKoppel_Thareos
            ${PROJECT_SOURCES}
        )
    endif()
endif()

target_link_libraries(BrunoKoppel_Thareos PRIVATE Qt${QT_VERSION_MAJOR}::Widgets)
