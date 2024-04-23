# Traffic Queues
## Developed with ♥ by Diego Rodriguez and Steven León (C124 Studios)
Traffic Queues is a project designed to visually demonstrate the workings of a queue in a simple and enjoyable manner. It aims to illustrate the logic behind a FIFO (First In, First Out) model and the appropriate way to implement it using Java.

#### Specifications: 
- Port: 8080 (example:http://localhost:8080/)
- Java version: java 17
- Operating systems tested: Windows 10
#### Architecture used: RESTful API


# Files
## Model folder
Inside of this folder we can find the objects necessary to make the app work
- **Car**.java
	This class has 3 attributes:	
	- **color (int[]):** The color array saves three random integer values, destined to be an rbg color later into **CarsService**.java.
	- **position (int):** This attribute establish the position of the car into the queue.
	- **colorHEX (String):** This String is just a parse of **color(int[])** from rgb to HEX format.
    
	The constructor, that just verifies that there were not more than three values into **color(int[])**:	
    ```java
    public  Car(int[]  color)  {
		this.position  =  0;
		if  (color.length  !=  3)  {
			throw  new  IllegalArgumentException("Only three values allowed");
		}
		this.color  = color;
	}
	```
	And a **toString()** method to visualize the object car in console
## Service folder
Inside of this folder we can find the services, and inside of them is the logic of the project.
- **CarsService**.java
	This class is meant to manage the logic of the project, there we can find 2 attributes:
	- **queue (LinkedList<Car\>):** This attribute is basically the core of the project, because it manages the queue of cars that are curently running.
	- **defaultMove (int):** The value of this integer is extracted from the **application.properties** file, it establish how much every car should move.
    
    The constructor, this method extracts the defaultMove value from the properties file:	
    ```java
    public  CarsService(@Value("${movement_queue}")  int  defaultMove)  {
		this.defaultMove  = defaultMove;
		this.queue  =  new  LinkedList<Car>();
	}
	```
We are going to give a table with the methods, the returns, and a short explanation about the functionality of each one.

| Method         | Return| Functionality|
|----------------|---------------|-------------------------------------------|
| fillQueue(int numCars)     | LinkedList<Car\>  | This method is used to create a given number of cars, give them color and add them to the **queue (LinkedList<Car\>)**    |
| initCarsPosition()     | LinkedList<Car\>  | This method accommodates the position of the cars into the **queue (LinkedList<Car\>)**   |
| addCar()     | void  | This method just adds a new car to the    **queue (LinkedList<Car\>)**|
| deleteFirstCar()     | LinkedList<Car\>  | This method validates that **queue (LinkedList<Car\>)** is not empty, if it is not empty, deletes the first car|

## Controller folder
Inside of this folder we can find the controllers, and inside of them are the endpoints.
- **CarsController**.java
	This class is meant to manage the end-points of the project, there we can find 2 attributes:
	- **carsService (CarsService) :** This attribute is an instance of the **CarsService** class.
	- **carsQueue (LinkedList<Car\>):** This LinkedList is a representation of **queue**, from the **CarsService** class.
  
We are going to give a table with the endpoints, the returns, and a short explanation about the functionality of each one.

| Method         | Return| Functionality|
|----------------|---------------|-------------------------------------------|
| index()     | ModelAndView  | This endpoint is used to show the graphic interface to the user, also uploads **carsQueue** to the view. Its end-point is the root (example: http://localhost:8080/)  |
| addCar(int amount) | String  | This endpoint adds a new car to the **queue (LinkedList<Car\>)** and refreshes the page. Its end-point is "/add"    |
| deleteCar()     | String  | This endpoint deletes the first car from the **queue (LinkedList<Car\>)** and refreshes the page. Its end-point is "/del"|

______
