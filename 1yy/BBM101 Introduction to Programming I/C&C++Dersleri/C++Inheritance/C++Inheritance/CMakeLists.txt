cmake_minimum_required(VERSION 3.6)
project(C__Inheritance)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp Inheritance.cpp)
add_executable(C__Inheritance ${SOURCE_FILES} Inheritance.cpp)