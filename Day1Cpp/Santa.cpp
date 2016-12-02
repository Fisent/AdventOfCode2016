//
// Created by lukasz on 2016-12-01.
//

#include "Santa.h"
#include <sstream>

string Santa::toString()
{
    ostringstream ss;
    ss << "x: " << x << ", y: " << y << ", dir: " + direction << endl;
    return ss.str();
}

Santa::Santa()
{
    x = 0;
    y = 0;
    direction = N;
}

int Santa::getDistance()
{
    return abs(x) + abs(y);
}
