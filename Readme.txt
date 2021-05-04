The program expects to provide the to and from locations from the command line.
After calculating the cost for one route the program asks if you want to calculate the cost for another route.
If yes, type Y or y and the programs asks for the locations.
If no, then type any other letter and the program exits.

How to run the programs:
1. Add the dependency jars to class path i.e json-simple-1.1.1.jar.
2. Compile the project.
3. Run the program using the following command "java TripCalculator".
4. Provide the From Location in command line.
5. Provide the To Location in command line.
6. Enter Y if you want to reclacluate.


How to run unit tests
1.Add the dependency jars to class path i.e hamcrest-core-1.3.jar and Junit4.jar.
2.java org.junit.runner.JUnitCore TestTollCalculator
