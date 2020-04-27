package org.ndhit.bp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BoilerPlateFileIO {

	
public static void bpFileIORun() {
	
	//where are we executing
	final String dir = System.getProperty("user.dir");
    System.out.println("current dir = " + dir);
    
    //do some binary file I/O
	binaryFileIO();
	
	//do some character file I/O
	//characterFileIO();
	
	//do some character line I/O
	//characterLineFileIO();
	
}
/*
 * Reads from a binary file and writes to a binary file.  Uses TWR - Try-With-Resource to ensure resources are closed.
 * Entire contents are read and written from memory.
 */
public static void binaryFileIO() {

	String binaryIn = ".\\src\\assets\\imageIn.png";
	String binaryOut = ".\\src\\assets\\imageOut.png";

	
	try (InputStream imageFileIn = Files.newInputStream(Paths.get(binaryIn), StandardOpenOption.READ)
			;OutputStream imageFileOut = Files.newOutputStream(Paths.get(binaryOut), StandardOpenOption.CREATE))
	{
		System.out.println("About to read from: " + binaryIn);
	
		byte[] buffer = new byte[4096];
		int bytesread = 0;
		while (bytesread != -1) {
			bytesread = imageFileIn.read(buffer, 0, buffer.length);
			if(bytesread > 0) {
				imageFileOut.write(buffer, 0, bytesread);
			}
		}
	}
	catch (IOException ex) {
		System.err.println(ex);
	}


}

public static void characterFileIO() {
	
}

/*
 * Read lines of text from a text file.  Write them back to a text file.
 */
public static void characterLineFileIO() {

	Path fileIn = Paths.get(".\\src\\assets\\textIn.txt");
	Path fileOut = Paths.get(".\\src\\assets\\textOut.txt");
	try (InputStream in = Files.newInputStream(fileIn, StandardOpenOption.READ);
			BufferedReader reader =
					new BufferedReader(new InputStreamReader(in));
			OutputStream out = Files.newOutputStream(fileOut, StandardOpenOption.CREATE);
			PrintWriter writer = new PrintWriter(out);) 
	{
		String line = null;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
			writer.println(line);
		}
	} catch (IOException x) {
		System.err.println(x);
	}
}

}
