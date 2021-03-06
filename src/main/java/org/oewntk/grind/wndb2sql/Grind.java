/*
 * Copyright (c) 2021-2021. Bernard Bou.
 */

package org.oewntk.grind.wndb2sql;

import org.oewntk.model.Model;
import org.oewntk.sql.out.ModelConsumer;
import org.oewntk.wndb.in.Factory;

import java.io.File;

/**
 * Main class that generates the WN database in the SQL format from the WNDB format
 *
 * @author Bernard Bou
 */
public class Grind
{
	/**
	 * Main entry point
	 *
	 * @param args command-line arguments
	 */
	public static void main(String[] args)
	{
		int iArg = 0;

		// Tracing
		final long startTime = Tracing.start();

		// Input
		File inDir = new File(args[iArg]);
		Tracing.psInfo.println("[Input] " + inDir.getAbsolutePath());

		// Input2
		File inDir2 = new File(args[iArg + 1]);
		Tracing.psInfo.println("[Input2] " + inDir2.getAbsolutePath());

		// Output
		File outDir = new File(args[iArg + 2]);
		if (!outDir.exists())
		{
			//noinspection ResultOfMethodCallIgnored
			outDir.mkdirs();
		}
		Tracing.psInfo.println("[Output] " + outDir.getAbsolutePath());

		// Supply model
		Tracing.progress("before model is supplied,", startTime);
		Model model = new Factory(inDir, inDir2).get();
		//Tracing.psInfo.printf("[Model] %s%n%s%n%n", Arrays.toString(model.getSources()), model.info());
		Tracing.progress("after model is supplied,", startTime);

		// Consume model
		Tracing.progress("before model is consumed,", startTime);
		new ModelConsumer(outDir).accept(model);
		Tracing.progress("after model is consumed,", startTime);

		// End
		Tracing.progress("total,", startTime);
	}
}
