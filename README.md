# Philly Crime Detector

![GIF](https://github.com/TierraSharae/Philly-Crime-Detector/blob/master/img/demo.gif)

Philly Crime Detector is a Java application that calculates the likelihood of crime for a user based on his or her location and the time of day using Philadelphia Police Department [crime incidents](https://www.opendataphilly.org/dataset/crime-incidents/resource/c57a9de2-e300-468a-9a20-3e64e5b9b2da) from 2017 onward. More than 228,000 crimes in the following categories are included in the analysis:
> Aggravated Assault Firearm, Arson, Burglary, Disorderly Conduct, DUI, Forgery and Counterfeiting, Homicide, Motor Vehicle Theft, Offenses Against Family and Children, Other Assaults, Other Sex Offenses, Public Drunkenness, Rape, Robbery, Theft from Vehicle, Thefts, Weapon Violation


## Getting Started
The following sections will guide you through the process of installing and running Philly Crime Detector.

### Installation and Setup
Please, ensure that you have the following:
* [Java](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
* [Eclipse IDE](https://www.eclipse.org/downloads/packages/release/2018-12/r/eclipse-ide-java-developers) or a comparable Java IDE
* Philly Crime Detector: Download the program’s [src](https://github.com/TierraSharae/PhillyCrimeDetector) folder. It contains five classes: CrimeIncident.java, IncidentAnalysis.java, IncidentReader.java, IncidentReporter.java, and the configuration class SecretFile.java. 
* Crime Data: Download the file ["data.csv"](https://github.com/TierraSharae/PhillyCrimeDetector) and ensure that it is stored in the same folder that contains the src folder. 
* [Java-json.jar](https://github.com/stleary/JSON-java) or a comparable JSON-java parser. In Eclipse, configure your build path with this file by doing the following:
```right click any class > Build Path > Configure Build Path. Under "Libraries," > Add External JARS... > select Java-json.jar > Apply and Close ```

### Configuration
Philly Crime Detector utilizes Google’s Geocoding API. In order to use this software, the user must first [obtain an API key](https://developers.google.com/maps/documentation/geocoding/start#get-a-key). In SecretFile.java, replace `“API KEY GOES HERE”` with the actual key. The developers’ key was omitted from the code for security reasons.

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

However, if a location is outside of or not specific to Philadelphia, you will see an error message such as the one below.

![](https://github.com/TierraSharae/PhillyCrimeDetector/blob/master/img/error1.png)

The following are examples of unacceptable locations:

* Penn
* Locust Street
* 1060 West Addison Street
* 68137
* Fresh Grocer

### 3. Entering Time
When prompted, enter a time, using the 24-hour clock (Military Time). Acceptable formats for input include hh and hh:mm. If the hours are greater than 23, you will see an error message such as the one below.

![](https://github.com/TierraSharae/PhillyCrimeDetector/blob/master/img/error2.png)

### 4. Understanding Results
The average percentage of crime across the entire dataset is roughly 10 percent. The highest percentage of crime across all times and zones is 42, and the lowest is 0. This range is the relative benchmark for criminal activity across the city. For instance, if the percentage is in the 30-40 range, Philly Crime Detector considers the likelihood of crime to be relatively high, whereas if the results are less than 5 percent, the zone and time are considered very safe relative to others.

*Now, you're ready to explore the City of Brotherly Love safely! Enjoy!*

## Developers
* Trixie Go
* Tamara Prabhakar
* [Tierra Sharae](https://tierrasharae.github.io/)

## Versions
Philly Crime Detector's initial release runs at the command line-level in an integrated development environment. Tierra is currently developing a graphical user interface for its second version! 
