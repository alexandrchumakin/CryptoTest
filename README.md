# CryptoTest
Selenium test for verifying Bitcoin profit per month calculation https://www.cryptocompare.com/mining/calculator/btc. 
Generates random unit, hashing power, power consumption and cost per KW/h. Gets current bitcoin calculation rate from web form.

# Requirements
 - Java 1.8
   - Download latest jdk-8 and install to any path
   - Set JAVA_HOME environment variable to this folder
   - Add %JAVA_HOME%\bin to PATH environment variable
 - Mozilla Firefox version up to 54.0
 - Maven
   - Download binary zip archive from https://maven.apache.org/download.cgi and unpack to any folder
   - Set M3_HOME environment variable to this folder
   - Add %M3_HOME%\bin to PATH environment variable
 
# Quick start
 - Download repository to any folder
 - Switch to this repo location from command line
 - Execute command "mvn clean test" (without quotes)
