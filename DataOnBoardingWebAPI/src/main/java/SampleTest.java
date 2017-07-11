public class SampleTest {
	
	public static void main(String[] args) {
		//getPath();
		//String routePath = this.getClass().getClassLoader().getResource(File.separator).getPath(); 
		//System.out.println(routePath);
		
		
		/*File currDir = new File(".");
	    String path = currDir.getAbsolutePath();
	    path = path.substring(0, path.length()-1);
	    
	    
	    String reportsPath = path+"\\src\\main\\webapp\\reportsData";
	    System.out.println(path);
		File reportsDirectory = new File(reportsPath);
		System.out.println("reportsDirectory======"+reportsDirectory);
		if(!reportsDirectory.exists()){
			try{
				reportsDirectory.mkdirs();
		    } 
		    catch(SecurityException se){
		    	se.printStackTrace();
		        //logger.error(" processExcelContent :: Error while creating the required Directory : ", se);
		    }      
		}*/
		
		
		/*for finding the path*/ 
		/*String newLine = System.getProperty("line.separator"); 
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(routePath+File.separator+".."+File.separator+"backup.txt"), true)); */
		/*file name is backup.txt and this is*/
	}
	
	/*public static String getPath() throws UnsupportedEncodingException {
		String path = this.getClass().getClassLoader().getResource("").getPath();
		String fullPath = URLDecoder.decode(path, "UTF-8");
		String pathArr[] = fullPath.split("/WEB-INF/classes/");
		System.out.println(fullPath);
		System.out.println(pathArr[0]);
		fullPath = pathArr[0];
		String reponsePath = "";
		// to read a file from webcontent
		reponsePath = new File(fullPath).getPath() + File.separatorChar + "newfile.txt";
		return reponsePath;
		}*/

}
