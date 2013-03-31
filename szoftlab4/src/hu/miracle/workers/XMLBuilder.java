package hu.miracle.workers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLBuilder {

	private JAXBContext context;

	public XMLBuilder() {

	}

	public void writeXML(Scene scene) throws JAXBException, IOException {

		// =============================================================================================================
		// Setup JAXB
		// =============================================================================================================

		// Create a JAXB context passing in the class of the object we want to
		// marshal/unmarshal

		// =============================================================================================================
		// Marshalling OBJECT to XML
		// =============================================================================================================

		context = JAXBContext.newInstance(Scene.class);

		// Create the marshaller, this is the nifty little thing that will
		// actually transform the object into XML
		final Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// Create a stringWriter to hold the XML
		final StringWriter stringWriter = new StringWriter();

		// Marshal the javaObject and write the XML to the stringWriter
		marshaller.marshal(scene, stringWriter);

		// Print out the contents of the stringWriter
		File XML = new File("scene.xml");
		BufferedWriter bw = new BufferedWriter(new FileWriter(XML));
		bw.write(stringWriter.toString());
		System.out.println(stringWriter.toString());
		bw.close();

	}

	public Scene readXML() throws FileNotFoundException, JAXBException {
		// =============================================================================================================
		// Unmarshalling XML to OBJECT
		// =============================================================================================================

		context = JAXBContext.newInstance(Scene.class);

		// Create the unmarshaller, this is the nifty little thing that will
		// actually transform the XML back into an object
		final Unmarshaller unmarshaller = context.createUnmarshaller();

		// Unmarshal the XML in the stringWriter back into an object
		final Scene scene = (Scene) unmarshaller.unmarshal(new FileInputStream("scene.xml"));

		// Print out the contents of the JavaObject we just unmarshalled from
		// the XML
		return scene;
	}

}
