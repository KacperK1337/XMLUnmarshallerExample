# XML Unmarshaller Example
Simple example of unmarshalling an xml file to extract data from it.
___
### General
Program performs unmarshalling on file "popular_baby_names.xml" stored in directory "xmldata" which contains data about newborn babies. 
Each child has name, gender, ethnicity and year in which they were born.
Every child is stored in class "Child", all children are stored in class "Children".
After unmarshalling, program corrects the received data, because there are spelling errors in the xml file (details in the "Corrector" class).
Next, it collects all most common children's names, ethnicities and years of birth and divide them by gender.
Finally project can print collected data with a user-set limits.

### Feedback
If you have any questions or comments regarding the code i prowided, please place them in Discussion panel or contact me directly.
