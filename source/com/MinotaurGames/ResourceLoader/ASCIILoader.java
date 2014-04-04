package com.MinotaurGames.ResourceLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ASCIILoader {
	/**
	 * Reads all lines from a file
	 * @return
	 * @throws IOException Thrown when something goes wrong with the file IO
	 */
	public String[] read(File file) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(file));
		int lineCnt = 0;
		while (br.readLine() != null) lineCnt++;
		br.close();
		br = new BufferedReader(new FileReader(file));
		String[] lines = new String[lineCnt];
		String line;
		int lineNum = 0;
		while ((line = br.readLine())!=null){
			lines[lineNum] = line;
			lineNum++;
		}
		return lines;
	}
}
