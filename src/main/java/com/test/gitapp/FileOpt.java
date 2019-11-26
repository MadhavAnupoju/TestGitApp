package com.test.gitapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileOpt {
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public static final String DEST = "C:\\hibernate\\DestFile.txt";
	public static final String SRC = "C:\\hibernate\\Test.txt";

	public static void main(String[] args) {
		File destFile = new File(DEST);
		FileOutputStream outStream = null;
		try {
			outStream = new FileOutputStream(destFile);
			returnFile(SRC, outStream);
			LOGGER.log(Level.INFO, "Success");

		} catch (Exception e) {

			LOGGER.log(Level.SEVERE, "some error");
		}

		LOGGER.log(Level.INFO, "Success");

	}

	public static boolean returnFile(String filename, OutputStream outStream) throws IOException {
		boolean status = false;
		try (FileInputStream fis = new FileInputStream(filename)) {
			byte[] buffer = new byte[4 * 1024]; // 4K buffer
			int bytesRead;
			while ((bytesRead = fis.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
			status = true;
		} catch (Exception e) {
			status = false;
			LOGGER.log(Level.SEVERE, "some error");
		}
		return status;
	}

}
