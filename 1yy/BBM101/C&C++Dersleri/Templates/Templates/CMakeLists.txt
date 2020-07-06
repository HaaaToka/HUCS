cmake_minimum_required(VERSION 3.6)
project(Templates)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp TemplateClass.cpp)
add_executable(Templates ${SOURCE_FILES} TemplateClass.cpp)