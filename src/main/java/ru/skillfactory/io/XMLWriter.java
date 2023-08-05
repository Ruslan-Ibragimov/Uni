package ru.skillfactory.io;

import ru.skillfactory.auxiliary.FullInfo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XMLWriter {

    private static final Logger logger = Logger.getLogger(XMLWriter.class.getName());

    private XMLWriter() {
    }

    public static void generateXmlReq(FullInfo fullInfo, String xmlPath, String fileName) {

        try {
            logger.log(Level.INFO, "XML marshalling started");

            JAXBContext jaxbContext = JAXBContext.newInstance(FullInfo.class);

            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            try {
                Files.createDirectory(Paths.get(xmlPath));
                logger.log(Level.INFO, "Directory is successfully created");
            } catch (IOException ioEx) {
                logger.log(Level.FINE, "Directory is already created", ioEx);
            }
            File requestFile = new File(xmlPath + "/" + fileName + new Date().getTime() + ".xml");

            marshaller.marshal(fullInfo, requestFile);
        } catch (JAXBException jaxbEx) {
            logger.log(Level.SEVERE, "XML marshalling failed", jaxbEx);
            return;
        }

        logger.log(Level.INFO, "XML marshalling is successfully finished");
    }
}
