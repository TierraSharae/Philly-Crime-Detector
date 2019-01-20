# PhillyCrimeDetector

![GIF](https://github.com/TierraSharae/Philly-Crime-Detector/blob/master/img/demo.gif)

Philly Crime Detector is a Java application that calculates the likelihood of crime for a user based on his or her location and the time of day using Philadelphia Police Department crime incidents from 2017 onward. More than 228,000 violent crimes were included in the analysis.

## Getting Started
The following sections will guide you through the process of installing and running Philly Crime Detector.

### Installation and Setup
Please, ensure that you have the following:
* Eclipse: Philly Crime Detector is optimized to run at the command line-level in the [Eclipse IDE](https://www.eclipse.org/downloads/packages/release/2018-12/r/eclipse-ide-java-developers). However, it can be run in other Java IDEs. 
* Java: Additionally, please ensure that you have [Java](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html) installed on your computer.
* Philly Crime Detector: Download the program’s src folder. It contains five classes: CrimeIncident.java, IncidentAnalysis.java, IncidentReader.java, IncidentReporter.java, and the configuration class SecretFile.java. 
* Crime Data: Download the file “data.csv” and ensure that it is stored in the same folder that contains the src folder. 
* Java-json.jar

### Configuration
Philly Crime Detector utilizes Google’s Geocoding API. In order to use this software, the user must first obtain an API key. In SecretFile.java, replace `“API KEY GOES HERE”` with the actual key. The developers’ key was omitted from the code for security reasons.

## Usage
Now, you are ready to run the program using the following instructions.

### 1. Running Program
Launch the program by pressing the green “run” button in the Eclipse IDE.

### 2. Entering Location
When prompted, enter your location. The location does not have to be a formal address; for instance, it can be a Philadelphia neighborhood, zip code, intersection or landmark.

The following are examples of acceptable locations:
* Upenn
* 32nd and Walnut
* Fishtown
* 19104
* Fresh Grocer Philly

However, if a location is outside of or not specific to Philadelphia, the user will see an error message.

The following are examples of unacceptable locations:

* Penn
* Locust Street
* 1060 West Addison Street
* 68137
* Fresh Grocer

### 3. Entering Time
When prompted, enter a time, using the 24-hour clock (Military Time). Acceptable formats for input include hh and hh:mm. If the hours are greater than 23, the user will see an error message.


### 4. Understanding Results
The average percentage of crime across the entire dataset is roughly 10 percent. The highest percentage of crime across all times and zones is 42, and the lowest is 0. This range is the relative benchmark for criminal activity across the city. For instance, if the percentage is in the 30-40 range, Philly Crime Detector considers the likelihood of crime to be relatively high, whereas if the results are less than 5 percent, the zone and time are considered very safe relative to others.

