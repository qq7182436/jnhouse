package com.jnhouse.app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileRecord {

	/**
     * @param args
     */
    /*public static void main(String[] args) {
        String strFileSrc = "E:/WAV1/";
        String strFileDes = "F:/WAV2/";
         
        File fileSrc = new File(strFileSrc);
        File fileDes = new File(strFileDes);
         
        FileRecord obj = new FileRecord();
 
        System.out.println("开始");
         
        obj.copyFolder(fileSrc, fileDes);
         
        System.out.println("结束");
    }
     
      private void copyFolder(File src, File dest){
        if (src.isDirectory()) {
            if (!dest.exists()) {
                dest.mkdir();
            }
            String files[] = src.list();
            for (String file : files) {
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                // 递归复制
                copyFolder(srcFile, destFile);
            }
        } else {
            try {
                InputStream in = new FileInputStream(src);
                OutputStream out = new FileOutputStream(dest);
 
                byte[] buffer = new byte[1024];
 
                int length;
                 
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
                in.close();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch(IOException e2){
                e2.printStackTrace();
            }
             
        }
    }*/
	public void copyFolder(File fileName) {
		if (fileName.isDirectory()) {
			if (!fileName.exists()) {
				fileName.mkdir();
			}

			String files[] = fileName.list();
			for (String file : files) {
				File srcFile = new File(fileName, file);

				// 递归复制
				copyFolder(srcFile);
			}
		} else {
			try {

				// InputStream in = new FileInputStream(fileName1);
				OutputStream out = new FileOutputStream(fileName);

				byte[] buffer = new byte[1024];

				out.write(buffer);

				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}

		}
	}
}
