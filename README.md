epp-programming-language

ah yes a start of an adventure


note:i have stopped working on this langauge for a while a big while been like 3 months so,iam uploading it to github to see if anyone would like to work on it or even code with it,ik it still has a lot of unfinished thing and lots of bugs,so enjoy the documentation.


Installation:

so first off ofc we have to clone this github repo
before u do that if u dont have git install it by using 
`sudo apt install git`

After that we navigate to the epp directory using the cd command

After that we go ahead and run the installation file to install the packages as root

`sudo bash install.sh`


after that run setup.sh also using root

`sudo bash setup.sh`

this will ask for the path for the cloned github repo so if u dont know what the path is and u are there run the pwd command to geth the path and then paste it

finally u go ahaid and run these two commands after each other
`echo "alias epp='sudo java -cp /lib/epp main'" >> ~/.bashrc`
`source ~/.bashrc`

and last but not least run the epp command to test it out


CLI commands tutorial:

So we have some cli commands:

epp:runs the main java file that shows a cli that accepts commands with the file path that itself has commands which are:
set path:sets path for the epp script, so that whenever u run any of the commands u wont have to type it again(accepts the full path for the script)
run: this obviously runs the epp script
install: installs a community package, this accepts the github username and password as following(pythokf1972/epp-programming-langauge)
build: builds the packages required for the script to run(copies them to current directory)


We also have the arguements ran when running the command which are the same as the above but without running  the cli tool:
epp -install
epp -run
epp -build
all of these accept full script path

epp -help








Epp tutorial:

ah here we come the fun part(i dont think it is lol)

anyways so epps syntax is really simple:

from the background that u are coming from java epp does the main funtion for u(like python) and the class name is the same as the script file name

here is a hell world program example:


`printE("hello world")`
this simply print hello world


taking user input:

this is also simple we can achieve this by the following code example


`printE("Enter ur name")
String input name
`

so first off we specify the data type then the keyword input then the variable name


if,else conditions:

well thats simple too here is a code example

`if name == "gigchad"{
  printE("ur a chad man")

}`
so we specify the if keyword then our conditions andi nside colly brackets what happens if the condition is true

`else
{
printE("ur not a chad")
}`


while,for loop:

this is the same as the if else condition, here is an example:

`while true
{
 whathappens()
}`
`for int i,i<=5,i++{

whathappense()
}`




creating objects:

creating objects in epp is pretty simple here is an example

`new Button(args) B`



arrays:

creating arrays in epp changes to java but has the same functions:

`Array[datatype] arr = [1,2,3,4,5]`
ur can still call the arr.length(function for example)
and there is a custom function which is the ".getRandom()" function which returns a random elemnt from the array that has the arrays datatype


importing libraries:

in epp u can import both epp community libraries,epp libraries and java libararies all by using one keyword

import community packages:
`import com.thepackage`

importing epp packages:
`epp.thapackage`

importing java packages:

`import java.util.Scanner`


and thats it, there is a lot to work on ik, i hope u enjoy this langauge even tho its still unfinished!







EPP devs documentation:

and this is for the devs that would like to work on the epp langauge itself
the PackageManager and installer and the compiler are part of the epp package u can import it inside an epp script using
import `epp.resources`

and also if u want to work on the langauge and develop it more,u can find the scripts in the src folder.


enjoy!!!


if u need anything regarding this project or any other u can send me an email on andrewkfoury3@gmail.com
