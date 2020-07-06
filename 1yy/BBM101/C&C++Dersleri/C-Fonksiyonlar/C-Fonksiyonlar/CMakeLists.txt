cmake_minimum_required(VERSION 3.6)
project(C_Fonksiyonlar)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp ilginctoplama.cpp birlestir.cpp faktoryel.cpp cppio.cpp)
add_executable(C_Fonksiyonlar ${SOURCE_FILES} ilginctoplama.cpp birlestir.cpp faktoryel.cpp cppio.cpp)