
import geargrip
import cv2
import numpy as np
from networktables import NetworkTable


cam = cv2.VideoCapture("http://10.14.3.24/mjpg/video/mjpg")
if cam.isOpened():
	print("yes")
ret, frame = cam.read()
gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

cam.release()


