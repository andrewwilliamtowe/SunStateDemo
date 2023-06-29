# SunStateDemo
Hello and Welcome to Andrew Towe's Demonstration for Sustate Equipment
Details to note about this application: 
1. A Postgresql server is embedded in a docker container that runs on startup.
2. GraphQL can be used for viewing data. The link for while running the app is http://localhost:8080/graphiql?path=/graphql
3. The application manipulates the TemperatureEntry object, which has the following variables:
    1. id - Long: used to keep the entries straight in the database.
    2. time_stamp - Long: used to record the time the reading was taken
    3. fahrenheit_temp - Float: the recorded temperature in Fahrenheit
    4. (not an explicit variable, but stored in the table) celsius_temp - Float: the recorded temperature in Celsius
4. This application has the following endpoints:
    1. localhost:8080/TemperatureEntry/enterFahrenheit: This allows you to enter a number in Fahrenheit. It will save that information with a timestamp, convert the temperature into Celsius, store the TemperatureEntry in the database, then return the converted Celsius value. My method with Postman was to put the address in the URL bar, go to the body tab, select 'raw' and enter the temperature as a number. 
   2. localhost:8080/TemperatureEntry/enterCelsius:  This allows you to enter a number in Celsius. It will save that information with a timestamp, convert the temperature into Fahrenheit, store the TemperatureEntry in the database, then return the converted Fahrenheit value.
   3. localhost:8080/TemperatureEntry/saveTemperatureEntry: This allows you to enter a raw temperature entry (useful if you wanted to enter a temperature entry with a different time_stamp).
   4. localhost:8080/TemperatureEntry/getAllTempEntries: returns all TemperatureEntries.
   5. localhost:8080/TemperatureEntry/getAverageForLastWeek: gets all entries that have a timestamp within the last 7 days, averages the temperatures, and returns the averages in Fahrenheit and Celsius.
   6. localhost:8080/TemperatureEntry/getById/{id}: enter an id, and it will return to you the temperature entry.
   7. localhost:8080/TemperatureEntry/delete/{id}: enter an id, and it will delete the temperature entry.
