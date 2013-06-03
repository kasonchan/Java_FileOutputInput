Java_FileOutputInput
====================

####This FileOI class provides the join and split functions to join and split files.

*  The join function reads the data files line by line and then use the delimiter that the user provided to join the files and written to a new file. The user need to provide a output file name, a delimiter, and the data files that your want to join.
*  The split function read the data file line by line and then use the delimiter that the user provided to split the line and written to the files. The user need to provide a input file name, a delimiter, and the data files that your want to split to.

####Instructions to compile and execute the program.

To compile the program, enter:
```
make FileOI FileOIDemo
```
To clean up the class file, enter:
```
make clean
```
To execute the program, enter:
*  java FileOIDemo &lt;keyword&gt; &lt;delimiter&gt; &lt;input/output filename&gt; &lt;output/input filenames&gt;
  *  &lt;keyword&gt;: join or split only
  *  &lt;delimiter&gt;: any delimiter you want to use
  *  &lt;input/output filename&gt;: the filename that you want to join or split from
  *  &lt;output/input filenames&gt;: the filenames that you want to join or split to

As shown in the typescript file below,
```
java FileOIDemo join "" Output Number.txt Grades.txt Name.txt
```
is used to join ```Number.txt``` ```Grades.txt``` ```Name.txt``` and write it to the ```Output``` file with the delimiter ```""```.
```
java FileOIDemo split "" Output Number.txt Grades.txt Name.txt
```
is used to split the line using the delimiter ```""``` from the ```Output``` file and written the results to ```Number.txt``` ```Grades.txt``` ```Name.txt```.
