package pack.epp.resources;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Scanner;
import java.io.*;

public class compiler 
{
@SuppressWarnings("deprecation")
public  String compile(String filepath)throws Exception 
{
String x = filepath; 
 File myObj = new File(x);
		   String last = "";
		   if(myObj.getName().contains(".epp"))
		   {
		   //scanner for file 
			   Scanner myReader = new Scanner(myObj);
	       //for like while loop to go in each line and change it
		   //to java
		   String data = myReader.nextLine();
		   String idk = "";
		   String packages = "";
		   String ifcase = "";
		   String objneed = "";
		   while (myReader.hasNextLine()) {
		          
					
				//all conditions of the programming lang/syntax
		       
			   //the classic printing 
			   if(data.contains("printE"))
		       {
		    	   data = data.replaceAll("printE", "System.out.println");
		       }
		       
		       //taking user input 
		       if(data.contains("input")) {
		    	   String varname = data.substring(data.indexOf("input") + 5 , data.length());
		    	   String vartype = data.substring(0, data.indexOf("input"));
		    	   if(!packages.contains("import java.util.Scanner;")) {
		    	   packages += "\n" + "import java.util.Scanner;";
		    	   }
		    	   if(!objneed.contains("Scanner s = new Scanner(System.in);")) {
		    		   objneed += "\n" +  "Scanner s = new Scanner(System.in);";
		    	   }
		    	   
		    	   data =  vartype +  varname + "=" + "s.nextLine()";
		    	   
		    	   
		       
		       
		       }
		       //if condition
		       if(data.contains("if"))
		       {
		    	   String condition = data.replaceAll("if", "");
                   if(condition.contains("{"))
                   {
		    	   String preparedif = "(" + condition.replace("{", "") + ")";
		    	   String lastif =  "if" + preparedif + "{";
		    	   data = lastif;
                   }
                   else
                   {
                	   String lastif =  "if" + "(" + condition + ")";
    		    	  data = lastif;
    		    	  
                   }
		    	  
		       
		       }
		       //while loop
		       if(data.contains("while"))
		       {
		    	   String condition = data.replaceAll("while", "");
                   if(condition.contains("{"))
                   {
		    	   String preparedwhile = "(" + condition.replace("{", "") + ")";
		    	   String lastwhile =  "while" + preparedwhile + "{";
		    	   data = lastwhile;
                   }
                   else
                   {
                	   String lastwhile =  "while" + "(" + condition + ")";
    		    	  data = lastwhile;
    		    	  
                   }
		       }
		       //for loops
		       if(data.contains("for"))
		       {
		    	   String condition1 = data.replaceAll("for", "");
                   String condition = condition1.replaceAll(",", ";");
		    	   if(condition.contains("{"))
                   {
		    	   String preparedfor = "(" + condition.replace("{", "") + ")";
		    	   String lastfor =  "for" + preparedfor + "{";
		    	   data = lastfor;
                   }
                   else
                   {
                	   String lastfor =  "for" + "(" + condition + ")";
    		    	  data = lastfor;
    		    	  
                   }
		       }
		       
		       //arrays syntax 
		       if(data.contains("Array"))
		       {
		    	   String type = "";
		    	   int count = data.indexOf("[");
		    	   
		    	   while(data.charAt(count) != ']' )
		    	   {
		    		   type+=data.charAt(count);
		    		   count+=1;
		    	   }
		    	   String realtype = type.replace("[", "");
		    	   String value =(data.substring(data.indexOf("="))).replaceAll("Array[" + realtype + "]", "").replaceAll("=","");
		    	   String[] name = data.split(realtype);
		    	   String arrname = name[1].replaceAll(value, "").replaceAll("=", "").replaceAll("]", "");
		    	   String finalarr = realtype + "[] " + arrname + " = {" + value + "}" ;
		    	   data=finalarr + ";";
		    	   
		   
		       }
		       //adding random into language
		       //it is an array function ofc
		      
		    	  if(data.contains(".getRandom()"))
		    	  {
		    	   String arrname = "";
		    	   int count = data.indexOf(".") - 1;
		    	   while(data.charAt(count) != ' ')
		    	   {
		    		   arrname = data.charAt(count) + arrname ;
		    		   count -=1;
		    	   }
		    	   if(!packages.contains("import java.util.Random; ")) {
			    	   packages += "\n" + "import java.util.Random; ";
			    	   }
			    	   if(!objneed.contains("Random rnd = new Random();")) {
			    		   objneed += "\n" + "Random rnd = new Random();";
			    	   }
			    	   data = data.replace(arrname+".getRandom()","")+ arrname+"[rnd.nextInt("+arrname+".length)]";	    	   
		      }
		      //importing java libs and epp libs and epp community libs
		    	  if(data.contains("import"))
		      { 
		        String pack = data.replaceAll("import ", "");
		        //building the packs
		        if(pack.contains("epp."))
		        {
		        	String packname = pack.replace("epp.", "pack.epp.");
		        	
		        	packages += "import " + packname + ";";
		        	data = "";
		        }
		        if(pack.contains("com."))
		        {
		        	String packname = pack.replace("com.", "pack.com.");
		        	packages += "import " + packname + ";";
		        	data = "";
		        }
		        if(!pack.contains("com.") && !pack.contains("epp."))
		        {
		    	packages += data + ";";
		        data = "";
		        }
		      
		      }
		       //creating objects(would also work for java packages)
		    //new Button(parms) i	  
		    if(data.contains("new"))
		    {
		    	String classname =  data.substring(0, data.indexOf("(")).replaceAll("new ", "");
		    	int count = data.indexOf(classname + "(");
		    	String parameters = "";;
		    	while(data.charAt(count) != ')')
		    	{
		    		parameters += data.charAt(count);
		    		count ++;
		    	}
		    	String parameters2 = parameters.replace(classname + "(", "");
		    	
		    	
		    	String objname = data.replace("new "+classname + "(" + parameters2 + ")","" );
		    	
		    	
		    	data = classname + " " + objname + "= new " + classname + "(" + parameters2 + ")"  ;
		
		    	
		    }
		       
		       //or and statements
		       /*if(data.contains("or"))
		       {
		    	   data = data.replaceAll("or", "||");
		       }
		       if(data.contains("and"))
		       {
		    	   data = data.replaceAll("and", "&&");
		       }*/
		       
		       //adding the line to the full code
		       if(data !="" && !data.contains("if")&&!data.contains("{")&&!data.contains("}")&&!data.contains("while")&&!data.contains("else")&&!data.contains("for"))
		       {
		       idk+=data + ";";
		       }
		       else
		       {
		    	   idk+= data;
		       }
		       if(data.contains("Array"))
		       {
		    	   idk+=data+";";
		       }
		       
		       data = myReader.nextLine();
		       
		      }
		   String classname = "";
		   int haha = x.length() - 1;
		   while(x.charAt(haha)!='/')
		   {
			   classname = x.charAt(haha) + classname;
			   haha -=1;
		   }
		
		   last = packages + "class "+ classname.replaceAll(".epp", "") +   "{ public static void main(String agrs[]){" +objneed+ idk + "}}";
                    
		

}
else {
			   System.out.println("File isnt in the e++ programming language format aka .epp");
		   }
return last;
}
//building the packages



public void execute(String filepath,String CompiledCode)throws Exception
{
        String x = filepath;
        //creating the compiled epp to  java file
        
        File compiled = new File(x.replace(".epp", ".java"));
        
        
             compiled.createNewFile();
             compiled.canWrite();
             //writing the java file with its compiled text
             FileWriter fw = new FileWriter(compiled);
             fw.write(CompiledCode);
             fw.flush();
             //running it and making a new terminal window using xterm
		     ProcessBuilder pb = new ProcessBuilder("/usr/bin/xterm","-hold","-e"," java " + compiled.getName());		     
		     pb.directory(new File(compiled.getPath().replaceAll("/"+compiled.getName(), "")));
		     pb.start();
		     
        
		    
}  

}


