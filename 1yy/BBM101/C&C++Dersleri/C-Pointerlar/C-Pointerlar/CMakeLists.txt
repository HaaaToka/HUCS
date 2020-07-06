cmake_minimum_required(VERSION 3.6)
project(C_Pointerlar)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp pointerdizi.cpp Pointer-Struct.cpp Pointer-Functions.cpp LinkedList.cpp)
add_executable(C_Pointerlar ${SOURCE_FILES} pointerdizi.cpp Pointer-Struct.cpp Pointer-Functions.cpp LinkedList.cpp)