Version 1.0

#Original Question: 
The code will process an input file. Each line in the input file will start with a command. There are two possible commands. The first command is Driver, which will register a new Driver in the app. Example: Driver Dan
The second command is Trip, which will record a trip attributed to a driver. The line will be space delimited with the following fields: the command (Trip), driver name, start time, stop time, miles driven. Times will be given in the format of hours:minutes. We'll use a 24-hour clock and will assume that drivers never drive past midnight (the start time will always be before the end time). Example: Trip Dan 07:15 07:45 17.3
Discard any trips that average a speed of less than 5 mph or greater than 100 mph.
Generate a report containing each driver with total miles driven and average speed. Sort the output by most miles driven to least. Round miles and miles per hour to the nearest integer.
Example input: Driver Dan\nDriver Alex\nDriver Bob\nTrip Dan 07:15 07:45 17.3\nTrip Dan 06:12 06:32 21.8\nTrip Alex 12:01 13:16 42.0\n
Expected output: Alex: 42 miles @ 34 mph\nDan: 39 miles @ 47 mph\nBob: 0 miles

#Overview
Several object-oriented programming design patterns, techniques and principles have been considered in this solution, such as composition, overloading, and singleton. 

Two classes Driver and Trip are designed to record the inputs. The static methods in FileReader reads the TXT input and processes it. Driver or Trip class instances are then constructed. DriverManager is a singleton class which serves as the 'database' of this project. The sequence is the following.
Input TXT file --> FileReader --> construct Driver/Trip classes <--> DriverManager
We also make extensive effort to treat an input file with incorrect lines (bad formats, etc), with two customized exceptions. 


#Data
The Data class stores time, mileage and name. The Driver and Trip classes share the same core data (time, mileage, name). Thus composition is made to include Data class in Driver and Trip classes. 


#Driver
The takeTrip method handles a trip by the driver.


#Trip
Two constructors (overloading) are provided. One is standard which records name, mileage and time. The other's argument is a String in the format of "Trip Name Start_time Stop_time Mileage", such as "Trip Dan 07:15 07:45 17.3". If this string fails to construct a Trip class instance, a customized exception "BadInputLine" is thrown.


#DriverManager
The DriverManager is a singleton class that stores all the Driver class instances. Singleton is chosen because there should be only one 'database' to store all the drivers' information. The Driver class instances are stored in an ArrayList. A HashMap from String to Driver provides indexing from Driver's name to the corresponding Driver class instance. One could argue that in future development a relational database could replace the singleton DriverManager. 

In the addDriver method, if a duplicate driver is found, no new Driver will be added and the addDriver method returns false (otherwise, returns true). The sort method sorts the ArrayList in any desired order and an iterator of the ArrayList is passed out.


#FileReader
The readTxtFile method reads a TXT file line by line, with each line converted to a String. This method is independent of the Driver/Trip question and can be reused in other situations. The String is processed by the stringPasing method, which determines whether it is a Driver line or a Trip line. In either case, a constructor of Driver or Trip class is called. 

The input file is read and processed line by line in one pass. This choice was made because potentially the input file is very large and is stored on a slow hard drive. 


#Exceptions
Two customized exceptions are made. "BadInputLine" means a line in the input TXT file is not in the correct format. "NoSuchDriverFound" means a trip line in the input TXT file does not have a valid driver previously recorded.


#Input File Format
The name must not contain any space. For example, "Dan_K" is a valid name whereas "Dan K" is not. Only one space is allowed between inputs. The name is case-sensitive, i.e, "Jerry" and "jerry" are two different drivers. 


#Test File (driver.txt)
This is a TXT file for testing. It includes various valid and invalid lines.