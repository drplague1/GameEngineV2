package com.raycaster.IO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface IFileIO {
	/**
	 * Opens an input file
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public InputStream readFile(String filename) throws IOException;

	/**
	 * Opens an output file
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public OutputStream writeFile(String filename) throws IOException;
}
