cmake_minimum_required(VERSION 3.6)
project(C___Class)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp Classlar.cpp Referanslar.cpp)
add_executable(C___Class ${SOURCE_FILES} Classlar.cpp Referanslar.cpp)