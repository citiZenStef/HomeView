#include </usr/include/opencv/cv.h>
#include </usr/include/opencv/highgui.h>
#include <stdio.h>
#include <assert.h>
#include <QApplication>
#include <QWidget>
#include <QVBoxLayout>
#include <QPushButton>
#include "include/Window.moc"
#include "include/QOpenCVWidget.h"


int main(int argc, char **argv) {
	CvCapture* camera = cvCreateCameraCapture(-1);
    assert(camera);
    IplImage* image=cvQueryFrame(camera);
    assert(image);

	QApplication app(argc,argv);

	Window window(camera,image);

    window.show();
	int retval = app.exec();

	cvReleaseCapture(&camera);
	cvReleaseImage(&image);

	return retval;
}
