/*
 * Copyright (c) 2021-2021. Bernard Bou.
 */

package org.oewntk.grind.wndb2sql;

import org.oewntk.model.Model;
import org.oewntk.sql.out.NIDMaps;
import org.oewntk.wndb.in.Factory;

import java.io.File;
import java.io.IOException;

/**
 * Class that prints the NID maps
 */
public class Mapper
{
	/**
	 * Main entry point
	 *
	 * @param args command-line arguments yamlDir [outputDir]
	 * @throws IOException io exception
	 */
	static public void main(String[] args) throws IOException
	{
		File outDir = new File(args[2]);
		if (!outDir.isDirectory())
		{
			//noinspection ResultOfMethodCallIgnored
			outDir.mkdirs();
		}

		final Model model = Factory.makeModel(args);
		NIDMaps.printMaps(model, outDir);
	}
}
