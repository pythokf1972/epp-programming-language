package pack.epp.resources;

import java.io.File;
import java.util.Scanner;
//this is the packagemanager used to manage and install epp packages
public class PackageManager {
	@SuppressWarnings("deprecation")
public void build(String filepath)
{
try
{
		File f = new File(filepath);
		Scanner s = new Scanner(f);
		String line = s.nextLine();
		while(true)
		{
			if(line.contains("import"))
			{
				String packtype = line.replace("import ", "");
				if(packtype.contains("epp."))
				{
					String packpath  = packtype.replace("epp.", "/lib/epp/pack/epp/").replace('.','/'); 
					String spath = f.getPath().replace('/' + f.getName(), "");
					Runtime r = Runtime.getRuntime();
					r.exec("mkdir " + spath + "/pack");
					r.exec("mkdir " + spath + "/pack/epp");
					
					
					r.exec("cp -r " + packpath + " " + spath + "/pack/epp" );
				}
				if(packtype.contains("com."))
				{
					String packpath  = packtype.replace("com.", "/lib/epp/pack/com/").replace('.','/'); 
					String spath = f.getPath().replace('/' + f.getName(), "");
					System.out.println(packpath);
					Runtime r = Runtime.getRuntime();
					r.exec("xterm -hold -e mkdir " + spath + "/pack");
					r.exec("xterm -hold -e mkdir " + spath + "/pack/com");
					
					
					r.exec("xterm -hold -e cp -r " + packpath + " " + spath + "/pack/com" );
					
				}
				
			}
			line = s.nextLine();
			
			if(!s.hasNextLine())
			{
				break;
			}
		}
		}
		catch(Exception e)
		{
			System.out.println("No file found,make sure u typed the path correctly");
		}
		
	}



@SuppressWarnings("deprecation")
public void installPackage(String pack)throws Exception
{
	//name will come like following: creator name/package name
	
	Runtime r = Runtime.getRuntime();
	//finding the package/repo actual name
	String packname = pack.substring(pack.indexOf("/") + 1 , pack.length());
	 //making a folder in /lib/epp/com for the package
	//we fucking need su permission goodluck soldier
	r.exec("mkdir /lib/epp/pack/com/" + packname );
	//installing the gihub repo into /lib/epp/pack/com folder since there belongs the community packages
	String url = "https://github.com/"+pack ; 
	r.exec("xterm -hold -e git clone "+url + " /lib/epp/pack/com/" + packname ) ;
} 




}


