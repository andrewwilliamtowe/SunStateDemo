# SunStateDemo
Hello and Welcome to Andrew Towe's Demonstration for Sustate Equipment
Details to note about this application: 
1. A postgresql server is embeded in a docker container that runs on startup
2. GraphQL can be used for viewing data. The link for while running the app is http://localhost:8080/graphiql?path=/graphql
3. The application manipulates the TemperatureEntry object, which has the following variables:
    a. id - Long: used to keep the entries straight in the database.
    b. time_stamp - Long: used to record the time the reading was taken
    c. fahrenheit_temp - Float: the recorded temperature in Fahrenheit
    d. (not an exlicit vairable, but stored in the table) celsius_temp - Float: the recorded temperature in celsius
4. This application has the following endpoints
    a.localhost:8080/TemperatureEntry/enterFahrenheit: This allows you to enter a number in fahrenheit. It will save that information with a timestamp, convert the temperature into celsius, store the TemperatureEntry in the database, then return the converted celsius value. My method with Postman was to put in the address in the url bar, go do the body tab, select 'raw' and enter the temperature as a number. 
    b.localhost:8080/TemperatureEntry/enterCelsius:  This allows you to enter a number in celsius. It will save that information with a timestamp, convert the temperature into fahrenheit, store the TemperatureEntry in the database, then return the converted fahrenheit value.
    c. localhost:8080/TemperatureEntry/saveTemperatureEntry: This allows you to enter a raw temperature entry (useful if you wanted to enter a temperature entry with a different time_stamp).
    d. localhost:8080/TemperatureEntry/getAllTempEntries: returns all TemperatureEntries.
    e. localhost:8080/TemperatureEntry/getAverageForLastWeek: gets all entries that have a timestamp within the last 7 days, averages the temperatures, and returns the averages in fahrenheit and celsius.
    f. localhost:8080/TemperatureEntry/getById/{id}: enter an id, and it will return to you the temperature entry.
    g. localhost:8080/TemperatureEntry/delete/{id}: enter an id, and it will delete the temperature entry.
