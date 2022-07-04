package demo.animalshelter.service;

import javax.print.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Printer {
    public static void print(String text) throws PrintException {
        DocFlavor flavor = DocFlavor.INPUT_STREAM.TEXT_PLAIN_UTF_8;
        PrintService[] services = PrintServiceLookup.lookupPrintServices(flavor, null);
        InputStream targetStream = new ByteArrayInputStream(text.getBytes());
        Doc doc = new SimpleDoc(targetStream, flavor, null);
        if (services.length > 0) {
            DocPrintJob job = services[0].createPrintJob();
            job.print(doc, null);
        }
    }
}
