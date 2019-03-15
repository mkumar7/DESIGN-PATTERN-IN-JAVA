package genericCheckpointing.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor 
{
	private String file_r;
	private FileReader f_reader;
	private FileWriter f_writer;
	private BufferedReader b_reader;
	private BufferedWriter b_writer;
	private File fileName;
	
	
	public FileProcessor(String fileNameIn) 
	{
		file_r = fileNameIn;
		fileName = new File(fileNameIn);
	}

	public void createWriter() 
	{

		try 
		{
			f_writer = new FileWriter(fileName);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.exit(1);
		}
		b_writer = new BufferedWriter(f_writer);
	}
	
	public void createReader()
	{
		try 
		{
			f_reader = new FileReader(fileName);
		} catch (FileNotFoundException e) 
		{
			System.err.println(fileName + " File Not found");
			e.printStackTrace();
			System.exit(1);
		}
		b_reader = new BufferedReader(f_reader);
	}
	
	public void storeLine(String line)
	{
		try 
		{
			b_writer.write(line);
		} catch (IOException e) 
		{
			System.err.println(line + " can not be stored in the file");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public String readLineFromFile() 
	{
		try 
		{
			
			return b_reader.readLine();
		} 
		catch (IOException e) 
		{
			System.err.println("cannot read from input file, Please check");
			e.printStackTrace();
			System.exit(1);
		}
		finally
		{

		}
		return null;
	}
	
	public void closeWriter()
	{
		try 
		{
			b_writer.close();
			f_writer.close();
		} catch (IOException e) 
		{
			System.err.println("Problem in closing the file");
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	
	public void closeReader()
	{
		try 
		{
			b_reader.close();
			f_reader.close();
		} 
		catch (IOException e) 
		{
			System.err.println("Problem in closing the reading file");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
}
