#include "/home/stef/CBprojects/CVHomeView/include/MyCVFilter.h"

// constructeur
MyCVFilter::MyCVFilter(IplImage* in)
{
    /**Images allocations here**/
}

void MyCVFilter::execute(IplImage* in, IplImage* out)
{
	/**Your vision algorithm here**/
}

void MyCVFilter::setDebug(bool dbg)
{
    debug = dbg;
}


MyCVFilter::~MyCVFilter(){}
