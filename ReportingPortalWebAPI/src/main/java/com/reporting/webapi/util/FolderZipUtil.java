package com.reporting.webapi.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class FolderZipUtil {
	
	private final Logger logger = Logger.getLogger(FolderZipUtil.class);

	public void zipIt(String zipFile, String sourceFolderPath, List<String> fileList, String folderNameTimeStampString) {
		
        byte[] buffer = new byte[1024];
        String source = new File(sourceFolderPath).getName();
        
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        
        try {
            fos = new FileOutputStream(zipFile);
            zos = new ZipOutputStream(fos);

            logger.info("Output to Zip : " + zipFile);
            
            FileInputStream in = null;

            for (String file: fileList) {
            	
            	logger.info("File Added : " + file);
                
                ZipEntry ze = new ZipEntry(source+File.separator+file);
                zos.putNextEntry(ze);	
                
                try {
                    in = new FileInputStream(sourceFolderPath + File.separator + file);
                    int len;
                    while ((len = in .read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                    }
                } finally {
                    in.close();
                }
            }

            zos.closeEntry();
            
            logger.info("Folder successfully compressed");

        } catch (IOException ex) {
            // ex.printStackTrace();
        	logger.error("FolderZipUtil : zipIt :: Error while performing ZIP for the Reports Folder : " + sourceFolderPath + " : Message : " + ex.getMessage());
        } catch (Exception e) {
        	logger.error("FolderZipUtil : zipIt :: Error while performing ZIP for the Reports Folder : " + sourceFolderPath + " : Message : " + e.getMessage());
        } finally {
            try {
                zos.close();
            } catch (IOException e) {
                // e.printStackTrace();
            	logger.error("FolderZipUtil : zipIt :: Error while closing the  ZipOutputStream : " + sourceFolderPath + " : Message : " + e.getMessage());
            }
        }
    }
	
}
