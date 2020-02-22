# Read Me
This was my first project using Spring/Spring Boot and while there was a lot of trial and error, I learned a lot

I wrote and tested the code using Eclipse on a Mac
To run the program:

* Open Eclipse
* Select File-Open File...
* Then find the folder, in this case it is the rest-test folder
* Select the file and click open
* The project should begin to load
* You can either select Run in the toolbar and select Run or click the green play icon near the top-left of the window

The project will run, displaying the total number of words in the json field "message" up to that point

It will not count the words in the "message" field if the "id" field is identical to a previous "id"

The project reads from the file data.json, which can be found in the highest level directory in the rest-test folder

Feel free to edit the data.json file to test other json data

It will then write to a new file result.json in json format in the same directory as data.json

