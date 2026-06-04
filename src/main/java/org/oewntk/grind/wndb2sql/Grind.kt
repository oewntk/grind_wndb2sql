/*
 * Copyright (c) 2021-2024. Bernard Bou.
 */
package org.oewntk.grind.wndb2sql

import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.default
import org.oewntk.sql.out.ModelConsumer
import org.oewntk.wndb.`in`.Factory
import java.io.File

/**
 * Main class that generates the WN database in the SQL format from the WNDB format
 *
 * @author Bernard Bou
 */
object Grind {

    /**
     * Main entry point
     *
     * @param args command-line arguments
     */
    @JvmStatic
    fun main(args: Array<String>) {
        val parser = ArgParser("wndb2sql")
        // Options (start with - or --)
        // @formatter:off
        val in1 by parser.argument(            ArgType.String,                                               description = "Input dir or file")
        val in2 by parser.argument(            ArgType.String,                                               description = "Extra input dir or file")
        val out by parser.argument(            ArgType.String,                                               description = "Output dir or file")
        val verbose by parser.option(          ArgType.Boolean,  shortName = "v",  fullName = "verbose",     description = "Verbose output")            .default(false)

        val traceTime by parser.option(        ArgType.Boolean,  shortName = "tt", fullName = "trace:time",  description = "trace time")                .default(false)
        val traceHeap by parser.option(        ArgType.Boolean,  shortName = "th", fullName = "trace:heap",  description = "trace heap")                .default(false)
        // @formatter:on
        parser.parse(args)

        // Tracing
        Tracing.traceTime = traceTime
        Tracing.traceHeap = traceHeap

        val startTime = Tracing.start()

        // Input
        val inDir = File(in1)
        Tracing.psInfo.println("[Input] " + inDir.absolutePath)

        // Input2
        val inDir2 = File(in2)
        Tracing.psInfo.println("[Input2] " + inDir2.absolutePath)

        // Output
        val outDir = File(out)
        if (!outDir.exists()) {
            outDir.mkdirs()
        }
        Tracing.psInfo.println("[Output] " + outDir.absolutePath)

        // Supply model
        Tracing.progress("before model is supplied,", startTime)
        val model = Factory(inDir, inDir2, verbose = verbose).get()
        Tracing.progress("after model is supplied,", startTime)

        // Consume model
        Tracing.progress("before model is consumed,", startTime)
        ModelConsumer(outDir, verbose = verbose).accept(model!!)
        Tracing.progress("after model is consumed,", startTime)

        // End
        Tracing.progress("total,", startTime)
    }
}
