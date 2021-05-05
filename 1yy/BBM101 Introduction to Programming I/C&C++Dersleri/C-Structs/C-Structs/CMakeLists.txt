cmake_minimum_required(VERSION 3.6)
project(C_Structs)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp struct-list.cpp nestedstruct.cpp scopes.cpp scopes.cpp)
add_executable(C_Structs ${SOURCE_FILES} struct-list.cpp nestedstruct.cpp scopes.cpp)