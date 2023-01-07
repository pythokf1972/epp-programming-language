import pack.epp.resources.compiler;
import java.util.Scanner;
import pack.epp.resources.PackageManager;
public class main{

@SuppressWarnings("deprecation")
public static void main(String[] args) throws Exception {	
	String x = "";
	compiler c = new compiler();
	PackageManager pm = new PackageManager();	   
	
	//every if condition for the arguements passed on when running the compiler 
if(args.length!=0)
{	
	if(args[0].contains("-run"))
	{
	   String path = args[1];
	   c.execute(path,c.compile(path));
	}	   
	if(args[0].contains("-build"))
	{
	   String path = args[1];
	   pm.build(path);
	}
	if(args[0].contains("-install"))
	{
	  String pack = args[1];
	  pm.installPackage(pack);
	}
	if(args[0].contains("-help"))
	{
	  System.out.println("command : epp : used to open the epp compiler and compile epp files \n\n options: \n -run filepath: to compile and run epp file \n -build filepath: used to build epp packages/ get the file of the imported packages \n -install packname: to install an epp community package from github the package name should bbe like following: devgithubname/reponame \n -help: to display avialable options");
	
	}
}	
	
	if(args.length == 0)
	{	   
		   
		   Scanner s = new Scanner(System.in);
		   System.out.print("e++ programming language compiler version 1.0 ");
		   System.out.println("\n"
		   		+ "███████╗░░░░░░░░░░░░░░\n"
		   		+ "██╔════╝░░██╗░░░░██╗░░\n"
		   		+ "█████╗░░██████╗██████╗\n"
		   		+ "██╔══╝░░╚═██╔═╝╚═██╔═╝\n"
		   		+ "███████╗░░╚═╝░░░░╚═╝░░\n"
		   		+ "╚══════╝░░░░░░░░░░░░░░\n");
		   while(true)
		   {
		   System.out.print(">>>");
		   String input = s.nextLine();
		   
		   //the run command in order to run files
		   if(input.contains("run"))
		   {
             if(x=="")
             {
			    x = input.replaceAll("run ", "");
             }
			
		   String compiled = c.compile(x);
		   System.out.println(compiled);
		   c.execute(x, compiled);
		   }
		   
		   //set path command used to set a file path in order to always run
		   //great for working on a project like for running and testing without always having to put the path
		   if(input.contains("set path"))
		   {
			   x = input.replaceAll("set path ", "");
		   }
		   //finally yes,a community package manager for github repos
		   if(input.contains("install"))
		   {
			  
			   pm.installPackage(input.replace("install ",""));
			   
		   }
		   //the build command to build packages
		   if(input.contains("build"))
		   {
			   if(x=="")
	             {
				    x = input.replaceAll("build ", "");
	             }
			   pm.build(x);
			   
			   
		   }
	}
	}
}
}
