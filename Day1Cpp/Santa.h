//
// Created by lukasz on 2016-12-01.
//

#ifndef DAY1CPP_SANTA_H
#define DAY1CPP_SANTA_H

#include <string>

using namespace std;

const string N = "north";
const string S = "south";
const string E = "east";
const string W = "west";

class Santa
{
private:
    int x;
    int y;
    string direction;
public:
    Santa();
    ~Santa();
    string toString();
    void move(string instr);
    int getDistance();
};


#endif //DAY1CPP_SANTA_H
