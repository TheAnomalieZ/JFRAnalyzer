package com.taz.jfrparser;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import oracle.jrockit.jfr.parser.*;

public class JDKParserTest {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws IOException {
        File recordingFile = new File("/home/suve/old.jfr");
        Parser parser = new Parser(recordingFile);
        int count = 0;
        Iterator<ChunkParser> chunkIter = parser.iterator();
        while (chunkIter.hasNext()) {
            ChunkParser chunkParser = chunkIter.next();
            for (FLREvent event : chunkParser) {
                count++;
                System.out.println(event.toString());
            }
        }
        parser.close();
        System.out.println("Found " + count + " events");
    }
}
