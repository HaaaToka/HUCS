cmake_minimum_required(VERSION 3.6)
project(C_giris)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES deneme.c)
add_executable(C_giris ${SOURCE_FILES})