# -*- coding: utf-8 -*-
"""
Created on Mon Jan 22 07:47:43 2024

@author: chua nguyen
"""






from math import sqrt
 
 
a = float(input("nhap a : "))
b = float(input("nhap b : "))
c = float(input("nhap c : "))
  
if a ==  0 :
      if b == 0 :
         if c == 0:
             print ( "phuong trinh vo so nghiem : ")
             
         else :
             print ( "phuong trinh vo nghiem : ")
                    
      if c == 0:
          print ( "phuong trinh co 1 nghiem x = 0 ")
          
      else :
          print ( "phuong trinh co 1  nghiem :x= ",-c/b)
          
else :
      delta = b **2 -4*a*c
      if delta < 0 :
          print ( "phuong trinh vo nghiem : ")
      elif delta == 0 :
          print ( "phuong trinh co 1  nghiem :x= ",-b/(2*a))
      else :
          print ("phuong trinh co 2 nghiem phan biet")
      print (" x1 = ", float ((-b-sqrt(delta)) / ( 2*a)))
      print (" x2 = ", float ((-b+sqrt(delta)) / ( 2*a)))
          