# this script implements a GUI to be used to run the programs in this assignment
# AccessAVLApp button returns printAllStudents method
# printStudent method not demonstrated here
# if test trials is selected a new window opens and user is prompted to enter a number
# this number (n) is a subset that is passed as an argument to testTrials.py

import PySimpleGUI as sg
import os
import testTrials


layout= [ [sg.Text('Select a program')],
            [sg.Button('AccessAVLApp')],
            [sg.Button('Test Trials')]]
                  
window = sg.Window('Window Title', layout)

event, values= window.read()

if event=='AccessAVLApp':
      layout = [ [sg.Text('Print all students in subset or print one student name given their ID')],
                  [sg.Button('All students')],
                  [sg.Button('Select one student')] ]
      
      window=sg.Window('Window Title', layout)
      event, values =window.read()
      
      if event=='All students':            
            os.system('java AccessAVLApp')
            window.close()
      if event== 'Select one student':
            layout= [ [sg.Text('Enter a student ID')],
                        [sg.Input()],
                        [sg.Button('Ok')] ]
            
            window= sg.Window('Window Title', layout)
            event, values= window.read()
            os.system('java AccessAVLApp ' +values[0])
            window.close()
                  
if event=='Test Trials':
      layout = [ [sg.Text('Select number(n) from 1 to 5000 to test a particular subset')],
                  [sg.Input()],
                  [sg.Button('OK')] ]
                  
      window = sg.Window('Window Title', layout)
      event, values= window.read()
      os.system('python3 testTrials.py ' + values[0])
      window.close()
      
window.close()