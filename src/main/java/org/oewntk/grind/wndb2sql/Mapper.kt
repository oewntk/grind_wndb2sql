/*
 * Copyright (c) 2021-2024. Bernard Bou.
 */
package org.oewntk.grind.wndb2sql

import org.oewntk.model.NIDs.printNIDs
import org.oewntk.model.SerializeNIDs.serializeNIDs
import org.oewntk.wndb.`in`.Factory.Companion.makeModel
import java.io.File
import java.io.IOException

/**
 * Class that prints the NID maps
 */
object Mapper {

    /**
     * Main entry point
     *
     * @param args command-line arguments
     * ```
     * yamlDir [outputDir]
     * ```
     * @throws IOException io exception
     */
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val outDir = File(args[2])
        if (!outDir.isDirectory) {
            outDir.mkdirs()
        }
        val model = makeModel(args)
        printNIDs(model!!, outDir)
        serializeNIDs(model, outDir)
    }
}
