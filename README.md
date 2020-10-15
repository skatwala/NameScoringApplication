"# NameScoringApplication" 


Input

The full path to the names file will be specified as a command line argument. The names file will contain a single line of quoted, comma-separated names. A small sample of data can be found at the end of this document and a full sample file (names.txt) is attached.

processing:

To score a list of names, you must sort it alphabetically and sum the individual scores for all the names. To score a name, sum the alphabetical value of each letter (A=1, B=2, C=3, etc...) and multiply the sum by the name’s position in the list (1-based).
For example, when the sample data below is sorted into alphabetical order, LINDA, which is worth 12 + 9 + 14 + 4 + 1 = 40, is the 4th name in the list. So, LINDA would obtain a score of 40 x 4 = 160. 

The correct score for the entire list is 3194. The correct score for the attached names.txt file is 871198282.

This has been verified by 2 files which are in /src/main/resources folder, the output matches above values


The following data is used for unit tests and returns the expectation of 3194

Sample names file data:
"MARY","PATRICIA","LINDA","BARBARA","VINCENZO","SHON","LYNWOOD","JERE","HAI"
