
import geargrip
import geargripv2
import centerTest
import cv2
import numpy as np
import math
from networktables import NetworkTable


class NTClient():
	def __init__(self):
	 	ip = "roborio-1403-frc.local"
        	NetworkTable.setClientMode()
        	NetworkTable.setIPAddress(ip)
        	NetworkTable.initialize()
        	sd = NetworkTable.getTable("SmartDashboard")
		self.table = sd
	
	def publish(self, x, key) :
		self.table.putNumber(key,x)	

def main(nt, cam):
#       a = geargrip.GearTape()
#	cam =  cv2.VideoCapture("http://10.14.3.24/mjpg/video.mjpg")
	a = centerTest.centerTest()
	if cam.isOpened():
		print("CONNECTED")
	ret, frame = cam.read()
#	gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
        a.set_source0(frame)
	a.process()
        output = np.array(a.filter_contours_output)
	xavg = 0
	c = 0
	wid = 0
        for i in output :
#                print("NEW ARRAY ===================================================================")
#                print(i)
#                array = []
#                for coordinates in i :
#                        co = np.array(coordinates)[0]
#                        array.append(str(co))
#                print(array)
		x,y,w,h = cv2.boundingRect(i)
		xavg += x
		if c == output.shape[0] - 1 :
			xavg += w
			wid = w
		c += 1
#		nt.publish(array,"Array 6")
        print(output.shape)
	if output.shape[0] <= 0:
		mid = 0
		wid = 0
	elif output.shape[0] > 0:
		mid = xavg/output.shape[0]
		d = 2 * 160 / (2 * wid * math.tan(0.488692))
		print "distance"
		print d
	print(mid)
	diff = 80 - mid
	print diff
	nt.publish(diff, "difference")
        print "Hello"
	print "Width"
	print wid 
#	d = 2 * 160 / (2 * wid * math.tan(67/2))
#	print "distance " + d
	nt.publish(wid, "width")
#	cv2.imshow('image',frame)


if __name__ == '__main__' :
	nt = NTClient()
	cam = cv2.VideoCapture("http://10.14.3.24/mjpg/video.mjpg")
	while(1):
		main(nt, cam)
# System.out.println("Hello");
