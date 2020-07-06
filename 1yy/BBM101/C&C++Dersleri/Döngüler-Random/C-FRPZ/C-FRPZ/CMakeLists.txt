cmake_minimum_required(VERSION 3.6)
project(C_FRPZ)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp do-while.cpp For.cpp foradvanced.cpp)
add_executable(C_FRPZ ${SOURCE_FILES} do-while.cpp For.cpp foradvanced.cpp)