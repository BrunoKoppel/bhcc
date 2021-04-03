/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualproject1brunokoppel;

/**
 * Individual Project #1 Calculates the maximum, minimum, and average temperatures in 3 cities, over the period of 31 days, and output the results per day.
 *
 * @author brunokoppel
 */

import java.util.Scanner;

public class IndividualProject1BrunoKoppel {
    
    /**
     * @param ANSI_RESET is a reset code for the Command Line Output. This variable resets the color and background for out System.out methods.
     * @param ANSI_HOT this is a code for the Command Line Output. This variable changes the color of our output to red letters, with no background.
     * @param ANSI_AVE this is a code for the Command Line Output. This variable changes the color of our output to green letters, with no background.
     * @param ANSI_COLD this is a code for the Command Line Output. This variable changes the color of our output to blue letters, with no background.
     * 
     */
    static Scanner input = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_HOT = "\u001B[31m";
    public static final String ANSI_AVE = "\u001B[32m";
    public static final String ANSI_COLD = "\u001B[34m";
    
    /**
     * 
     * Command Line based menu to guides us through the execution of our project.
     * 
     * @param args string given to the program as a command, this is in case it needs to run from the command line.
     */
    public static void main(String[] args) {
        
        /**
        * 
        * Explanation of the different variables in the main method.
        * 
        * @param machineState will be the state of our program
        * @param hardCodedCities is an array with the cities given on the zip files, the sole use of this is for when the user does not want to type in the data.
        * @param hardCodedTemperatureTable  is an array with the temperature data for the cities, the purpose of this is also in case the user does not want to type in the data.
        * @param temperatureTable is the array where our user input temperature values will be stored.
        * @param cities is the array where our user input city names will be stored.
        * 
        * @param printProgramCommands prints the list of commands that work for this program in specific.
        * 
        * The program runs in a loop that works as if it was a command line tool, you may also notice the '~$' in the command.
        * 
        */
        boolean machineState = true;
        String hardCodedCities[] = {"Paris", "Boston", "Orly"};
        int hardCodedTemperatureTable[][] = {{48, 50, 52, 49, 45, 54, 52, 52, 51, 43, 44, 40, 46, 42, 43, 47, 47, 45, 46, 44, 38, 38, 44, 43, 42, 45, 41, 41, 40, 42, 42},
                                             {24, 20,  6, 10, 29, 44, 21, 13, 23, 25, 43, 48, 40, 47, 43, 37, 39, 35, 33, 35, 20, 12, 12, 13, 24, 22, 31, 19, 20, 22, 30},
                                             {47, 49, 51, 48, 44, 53, 52, 52, 50, 42, 42, 39, 46, 41, 42, 47, 46, 44, 44, 42, 36, 37, 42, 41, 41, 43, 40, 40, 40, 41, 40}};

        int[][] temperatureTable = new int[3][31];
        String[] cities = new String[3];

        System.out.println("Hello Professor Miller. Welcome to the Temperature Report!!");
        printProgramCommands();

        
        while (machineState) {

            System.out.printf("\nTemperatureReport@EnterYourCommand:~$ ");
            String command = input.nextLine();

            if (command.equals("Run") || command.equals("run") || command.equals("R") || command.equals("r") || command.equals("Miller")) {
                
                // populateCitiesArray and populateTemperatureTable get called within the processTemperatureData in case the user chooses to enter their own data.
                
                populateCitiesArray(cities);
                populateTemperatureTable(cities, temperatureTable);
                processTemperatureDataForTheDay(cities, temperatureTable);
                processTemperatureDataForTheCity(cities, temperatureTable);
                printProgramCommands();
                
                
            } else if (command.equals("-D") || command.equals("-d") || command.equals("debug") || command.equals("Debug")) {
                
                // If the user chooses to use hard coded data, the the hardCodedCities and hardCodedTemperatureTable will be passed to the same function, processTemperatureData.
                
                processTemperatureDataForTheDay(hardCodedCities, hardCodedTemperatureTable);
                processTemperatureDataForTheCity(hardCodedCities, hardCodedTemperatureTable);
                printProgramCommands();
                
                
            } else if (command.equals("-H") || command.equals("-h") || command.equals("help")) {
                
                // help program to print the commands that are recognized by the program.
                
                printProgramCommands();
                
                
            } else if (command.equals("-Q") || command.equals("-q")) {
                
                // the quit command
                
                System.out.println("\nGoodbye my friend :(\n");
                machineState = false;
            } else if (command.equals("my name is bko") || command.equals("My name is bko")) {
                printSecretCommand();
            }

            command = "";
        }
    }

    
    
    
    
    
    
    /**
     * 
     * Takes in an empty string of names, and asks the user to input the data for the array.
     * 
     * 
     * @param cities is the array which will be populated with the city names.
     * @return the cities array so that it can be saved back into the cities array of the function that called it.
     * 
     */
    public static String[] populateCitiesArray(String[] cities) {
        System.out.println("\nWe only have memory for 3 cities! Please enter the name for the 3 cities, starting with:");

        for (int cityIndex = 0; cityIndex < 3; cityIndex++) {
            System.out.printf("\nCity #%d: ", cityIndex + 1);
            cities[cityIndex] = input.nextLine();
            while (cities[cityIndex].equals("")) {
                System.out.printf("\nSorry I didn't catch that, try again: ");
                cities[cityIndex] = input.nextLine();
            }
        }
        return cities;
    }

    
    
    
    
    
    /**
     * 
     * Takes in the cities array and an empty temperature table, it will print the name of the city and ask for the temperature data for each day of the month and said city.
     * 
     * 
     * @param cities the already populated array of cities.
     * @param temperatureTable an empty array for each day of the month for each of the cities
     * @return the temperatureTable array so that it can be saved back into the temperatureTable array of the function that called it.
     * 
     */
    public static int[][] populateTemperatureTable(String[] cities, int[][] temperatureTable) {
        System.out.println("\nAlso... we only support 31 days for each city :/ , maybe next week we may have more memory...");
        System.out.println("\nPlease enter the data for 31 days at each city, starting with:");
        
        for (int cityIndex = 0; cityIndex < 3; cityIndex++) {
            System.out.printf("\nCity #%d: %s", cityIndex + 1, cities[cityIndex]);
            for (int dayIndex = 0; dayIndex < 31; dayIndex++) {
                System.out.printf("\n\tDay #%d:", dayIndex + 1);
                temperatureTable[cityIndex][dayIndex] = input.nextInt();
            }
        }
        return temperatureTable;
    }

    
    
    
    
    
    /**
     * 
     * Takes in the cities array and the temperatureTable array so that it can process them. 
     * 
     * 
     * @param cities has already been populated at the moment this processTemperatureData function gets called.
     * @param temperatureTable has already been populated at the moment this processTemperatureData function gets called.
     * 
     */
    public static void processTemperatureDataForTheDay(String[] cities, int[][] temperatureTable) {

        for (int dayIndex = 0; dayIndex < 31; dayIndex++) {

            /**
             * 
             * @param maximumTemperatureForTheDay holds the value for the highest temperature for the day across all cities
             * @param minimumTemperatureForTheDay holds the value for the lowest temperature for the day across all cities
             * @param totalSumOfTemperaturesForTheDay holds the total sum of all temperatures so as to calculate the average at the end of the for loop
             * 
             */
            int maximumTemperatureForTheDay, minimumTemperatureForTheDay, totalSumOfTemperaturesForTheDay = 0;
            maximumTemperatureForTheDay = minimumTemperatureForTheDay = temperatureTable[0][dayIndex];

            for (int cityIndex = 0; cityIndex < 3; cityIndex++) {
                maximumTemperatureForTheDay = computeMaximumTemperature(maximumTemperatureForTheDay, temperatureTable[cityIndex][dayIndex]);

                minimumTemperatureForTheDay = computeMinimumTemperature(minimumTemperatureForTheDay, temperatureTable[cityIndex][dayIndex]);

                totalSumOfTemperaturesForTheDay = totalSumOfTemperaturesForTheDay + temperatureTable[cityIndex][dayIndex];
            }

            /**
             * 
             * @param printTemperatureResultsForTheDay the method that will take the process data and create a report for each day across all cities.
             * 
             */
            printTemperatureResultsForTheDay(   cities, 
                                                temperatureTable, 
                                                maximumTemperatureForTheDay, 
                                                minimumTemperatureForTheDay, 
                                                computeAverageTemperature(totalSumOfTemperaturesForTheDay, cities.length), 
                                                dayIndex);
        }

        System.out.println("\n\n\t\tEND OF OVERALL REPORT");
    }
    
    

    
    
    
    /**
     * 
     * Takes in 6 variables in total so that it can output the results for a specific day across all cities. When this method is called, it's sole purpose is to output a well formatted string display information about the day that has just been process.
     * 
     * 
     * @param cities the array with cities names.
     * @param temperatureTable the array with temperature values
     * @param maximumTemperature the highest temperature found in one day across all cities.
     * @param minimumTemperature the lowest temperature found in one day across all cities.
     * @param averageTemperature the average temperature in one day across all cities.
     * @param dayIndex the day index 
     * 
     */
    public static void printTemperatureResultsForTheDay(String[] cities, int[][] temperatureTable, int maximumTemperature,
            int minimumTemperature, double averageTemperature, int dayIndex) {

        
        
        /**
         * 
         * @param stringOfCitiesWithMaximumTemperature as the name entails, this string will hold the names of the cities with the highest temperatures
         * @param stringOfCitiesWithMinimumTemperature as the name entails, this string will hold the names of the cities with the lowest temperatures
         * 
         */
        
        String stringOfCitiesWithMaximumTemperature = "";
        String stringOfCitiesWithMinimumTemperature = "";

        
        /**
         * 
         * This For loop iterates through the temperatures in each city and populates the strings initialized above with data for the output
         * 
         */
        
        for (int cityIndex = 0; cityIndex < 3; cityIndex++) {
            if (temperatureTable[cityIndex][dayIndex] == maximumTemperature) {
                
                if (stringOfCitiesWithMaximumTemperature.equals("")) {
                    
                    stringOfCitiesWithMaximumTemperature = cities[cityIndex] + " city";
                    
                } else {
                    
                    stringOfCitiesWithMaximumTemperature = stringOfCitiesWithMaximumTemperature + " , and " + cities[cityIndex] + " city";
                    
                }
            }

            if (temperatureTable[cityIndex][dayIndex] == minimumTemperature) {
                
                if (stringOfCitiesWithMinimumTemperature.equals("")) {
                    
                    stringOfCitiesWithMinimumTemperature = cities[cityIndex] + " city";
                    
                } else {
                    
                    stringOfCitiesWithMinimumTemperature = stringOfCitiesWithMinimumTemperature + " , and " + cities[cityIndex] + " city";
                    
                }
            }
        }

        /**
         * 
         * This prints the results for the day, using all the data passed to the method.
         * 
         */  
        
        System.out.printf("\nDay %d: \n\tMaximum temperature of %d degrees (%s), \n\tMinimum temperature of %d degrees (%s), \n\tAverage temperature is %.2f degrees.",
                dayIndex + 1, maximumTemperature, stringOfCitiesWithMaximumTemperature, minimumTemperature, stringOfCitiesWithMinimumTemperature, averageTemperature);
    }

    
    
    
    
    
    /**
     * 
     * Takes in the cities array and the temperatureTable array so that it can process them. 
     * 
     * 
     * @param cities has already been populated at the moment this processTemperatureData function gets called.
     * @param temperatureTable has already been populated at the moment this processTemperatureData function gets called.
     * 
     */
    public static void processTemperatureDataForTheCity(String[] cities, int[][] temperatureTable) {
        
        for (int cityIndex = 0; cityIndex < 3; cityIndex++) {

            /**
             * 
             * @param maximumTemperatureForTheCity holds the value for the highest temperature for the city across all days
             * @param minimumTemperatureForTheCity holds the value for the lowest temperature for the city across all days
             * @param totalSumOfTemperaturesForTheCity holds the total sum of all temperatures so as to calculate the average at the end of the for loop
             * 
             */
            int maximumTemperatureForTheCity, minimumTemperatureForTheCity, totalSumOfTemperaturesForTheCity = 0;
            maximumTemperatureForTheCity = minimumTemperatureForTheCity = temperatureTable[cityIndex][0];

            for (int dayIndex = 0; dayIndex < 31; dayIndex++) {
                
                maximumTemperatureForTheCity = computeMaximumTemperature( maximumTemperatureForTheCity, temperatureTable[cityIndex][dayIndex] );

                minimumTemperatureForTheCity = computeMinimumTemperature( minimumTemperatureForTheCity, temperatureTable[cityIndex][dayIndex] );

                totalSumOfTemperaturesForTheCity = totalSumOfTemperaturesForTheCity + temperatureTable[cityIndex][dayIndex];
                
            }

            /**
             * 
             * @param printTemperatureResultsForTheCity the method that will take the process data for each city and create a report for each city across all days.
             * 
             */
            printTemperatureResultsForTheCity(  cities, 
                                                temperatureTable, 
                                                maximumTemperatureForTheCity, 
                                                minimumTemperatureForTheCity, 
                                                computeAverageTemperature(totalSumOfTemperaturesForTheCity, temperatureTable[cityIndex].length),
                                                cityIndex);
            
            System.out.println("\n\n\t\tEND OF TEMPERATURE REPORT FOR " + cities[cityIndex]);
        }
        
    }
    
    
    
    
    
    
    /**
     * 
     * Takes in 6 parameters in total so that it can output the results for a specific city across all days. When this method is called, it's sole purpose is to output a well formatted string display information about the city that has just been process.
     * 
     * 
     * @param cities the array with cities names.
     * @param temperatureTable the array with temperature values
     * @param maximumTemperature the highest temperature found in one city across all days.
     * @param minimumTemperature the lowest temperature found in one city across all days.
     * @param averageTemperature the average temperature in one city across all days.
     * @param cityIndex the city index, so that the method knows what data is being used in this iteration.
     * 
     */
    public static void printTemperatureResultsForTheCity(String[] cities, int[][] temperatureTable, int maximumTemperature,
            int minimumTemperature, double averageTemperature, int cityIndex) {

        int daysAboveAverageTemperature = 0;
        int daysBelowAverageTemperature = 0;
        String cityMaximumTemperatureReport = "";
        String cityMinimumTemperatureReport = "";
        
        System.out.printf("\nTemperature Report for the city #%d (%s) where the average temperature was %.2f",cityIndex + 1,cities[cityIndex], averageTemperature);
        System.out.println("\n\n\tDay by day breakdown:\n");
        
        /**
         * 
         * This For loop compares the temperature for each day to make sure if it is above, below, or about average.
         * It also checks for the maximum and minimum temperature and displays when it happened.
         * 
         */
        
        for (int dayIndex = 0; dayIndex < 31; dayIndex++) {
            
            System.out.printf("Day #%2d: Temperature was ", dayIndex + 1);
            
            // In case the temperature was the maximum
            
            if (temperatureTable[cityIndex][dayIndex] == maximumTemperature) {
                
                System.out.println(ANSI_HOT + temperatureTable[cityIndex][dayIndex] + ", THE HIGHEST OF THE MONTH!!!!!!!!!!" + ANSI_RESET);
                daysAboveAverageTemperature++;
                
                if (cityMaximumTemperatureReport.equals(""))
                {
                    cityMaximumTemperatureReport = "day #" + String.valueOf(dayIndex + 1);
                }
                else 
                {
                    cityMaximumTemperatureReport = cityMaximumTemperatureReport + ", and day #" + String.valueOf(dayIndex + 1);
                }
            }
            
            // In case the temperature was the minimum
            
            else if (temperatureTable[cityIndex][dayIndex] == minimumTemperature) {
                
                System.out.println(ANSI_COLD + temperatureTable[cityIndex][dayIndex] + ", THE LOWEST OF THE MONTH!!!!!!!!!!" + ANSI_RESET);
                daysBelowAverageTemperature++;
                
                if (cityMinimumTemperatureReport.equals(""))
                {
                    cityMinimumTemperatureReport = "day #" + String.valueOf(dayIndex + 1);
                }
                else 
                {
                    cityMinimumTemperatureReport = cityMinimumTemperatureReport + ", and day #" + String.valueOf(dayIndex + 1);
                }
                
            }
            
            // In case the temperature is equal to the average
            
            else if (temperatureTable[cityIndex][dayIndex] == averageTemperature) {
                
                System.out.println(ANSI_AVE + temperatureTable[cityIndex][dayIndex] + ", same as the average of the month" + ANSI_RESET);
                
            }
            
            // In case the temperature is above the average
            
            else if (temperatureTable[cityIndex][dayIndex] > averageTemperature) {
                
                System.out.println(ANSI_HOT + temperatureTable[cityIndex][dayIndex] + ", above the average of the month" + ANSI_RESET);
                daysAboveAverageTemperature++;
            }
            
            // In case the temperature is below the average
            
            else if (temperatureTable[cityIndex][dayIndex] < averageTemperature) {
                
                System.out.println(ANSI_COLD + temperatureTable[cityIndex][dayIndex] + ", below the average of the month" + ANSI_RESET);
                daysBelowAverageTemperature++;
                
            }
        }

        /**
         * 
         * In here we create the footer of the day by day breakdown, showing the days with the maximum and minimum temperature.
         * We also display how many days had temperature above and below average.
         * 
         */
        System.out.printf("\nThe maximum temperature was %d and occurred on the %s\n", maximumTemperature, cityMaximumTemperatureReport);
        System.out.printf("The minimum temperature was %d and occurred on the %s\n", minimumTemperature, cityMinimumTemperatureReport);
        System.out.printf("For an average temperature of %.2f\n", averageTemperature);
        System.out.println(ANSI_HOT + "\tThere were " + daysAboveAverageTemperature + " days with temperature above the average" + ANSI_RESET);
        System.out.println(ANSI_COLD + "\tThere were " + daysBelowAverageTemperature + " days with temperature below the average" + ANSI_RESET);
    }
    
    
    
    
    
    
    /**
     * 
     * Takes in the current maximum value and the new value that has to be compared.
     * 
     * 
     * @param currentMax the maximum temperature in a day.
     * @param newNumber the new temperature registered in a day.
     * @return the highest number of the two, which will be assigned to the current maximum from the method it got called from.
     * 
     */
    public static int computeMaximumTemperature(int currentMax, int newNumber) {
        if (currentMax < newNumber) {
            return newNumber;
        } else {
            return currentMax;
        }
    }

    
    
    
    
    
    /**
     * 
     * Takes in the current minimum value and the new value that has to be compared.
     * 
     * 
     * @param currentMin the minimum temperature in a day.
     * @param newNumber the new temperature registered in a day.
     * @return the lowest number of the two, which will be assigned to the current minimum from the method it got called from.
     * 
     */
    public static int computeMinimumTemperature(int currentMin, int newNumber) {
        if (currentMin > newNumber) {
            return newNumber;
        } else {
            return currentMin;
        }
    }

    
    
    
    
    
    /**
     * 
     * Takes the total sum of the temperature in a day and the total amount of cities entered.
     * 
     * 
     * @param totalSumOfTemperatures the total sum of temperatures in a the given day.
     * @param totalAmountOfNumbers the amount of cities.
     * @return the average computed from the total sum and the amount of cities.
     * 
     */
    public static double computeAverageTemperature(int totalSumOfTemperatures, int totalAmountOfNumbers) {
        return (Double.valueOf(totalSumOfTemperatures) / Double.valueOf(totalAmountOfNumbers));
    }

    
    
    
    
    
    /**
     * 
     * Prints the commands that are recognizable by the program.
     * 
     */
    public static void printProgramCommands() {
        System.out.println("\n\tEnter \'Run\' , \'run\' , \'R\' , \'r\' , or \'Miller\' to enter your own data (if you are professor Miller, then this is for YOU! :D)");
        System.out.println("\tEnter \'-D\' , \'-d\' , \'Debug\' , or \'debug\' to use HardCoded data");
        System.out.println("\tEnter \'-H\' , \'-h\' , or \'help\' for help about commands");
        System.out.println("\tEnter \'-Q\' or \'-q\' to exit.");
    }

    
    
    
    
    /**
     * Just a secret command :) 
     */
    private static void printSecretCommand() {
        System.out.println("easter bugs and secrets make me roll over like a cat... meow! :3");
        System.out.println("- -- .-.");
        System.out.println("- - /  |                - - /|_/|      .-------------------.");
        System.out.println("   /   |  - _______________| @.@|     /    Bruno Köppel     )");
        System.out.println("- |    |-- (______         >\\_C/< ---/                     /");
        System.out.println("  |    |  -  -   / ______  _/____)  (   Brunokoppel.com   /");
        System.out.println("-- \\   | -  -   / /\\ \\   \\ \\         `-------------------'");
        System.out.println(" -  \\  |     - (_/  \\_) - \\_)");
        System.out.println("- -  | |\n\n");
    }
}

