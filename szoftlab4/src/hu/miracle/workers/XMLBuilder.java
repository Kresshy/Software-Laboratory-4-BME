package hu.miracle.workers;

import java.awt.Point;
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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

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
		final Scene scene = (Scene) unmarshaller.unmarshal(new FileInputStream(
				"scene.xml"));

		// Print out the contents of the JavaObject we just unmarshalled from
		// the XML
		return scene;
	}

	public Scene readXML(String path) throws SAXException, IOException, ParserConfigurationException {

		// AZ XML FÁJL FELDOLGOZÁSA

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new InputSource(new FileInputStream(new File(path))));
		doc.getDocumentElement().normalize();
		
		NodeList sceneRootElement = doc.getElementsByTagName("scene");
		
		Element creaturesElement = (Element) sceneRootElement.item(0); 
		Element obstaclesElement = (Element) sceneRootElement.item(1);
		Element storagesElement = (Element) sceneRootElement.item(2);

		NodeList creature = creaturesElement.getElementsByTagName("anteater");
		NodeList obstacle = obstaclesElement.getElementsByTagName("obstacle");
		NodeList antsinker = obstaclesElement.getElementsByTagName("anthill");
		NodeList foodstrg = storagesElement.getElementsByTagName("foodstorage");
		NodeList anthill = storagesElement.getElementsByTagName("anthill");
		
		Scene scene = new Scene();
		
		for(int i = 0; i < creature.getLength(); i++) {
		
			Element element = (Element) creature.item(i);
			int x = Integer.parseInt(((Element) element.getElementsByTagName("position").item(0)).getAttribute("x"));
			int y = Integer.parseInt(((Element) element.getElementsByTagName("position").item(0)).getAttribute("y"));
			Point point = new Point(x, y);
			AntEater ae = new AntEater(point, scene);
			int hunger = Integer.parseInt(((Element) element.getElementsByTagName("hunger").item(0)).getNodeValue());
			int wait = Integer.parseInt(((Element) element.getElementsByTagName("wait").item(0)).getNodeValue());
			ae.setHunger(hunger);
			ae.setWait(wait);
			scene.getCreatures().add(ae);
			
		}
		
		for(int i = 0; i < obstacle.getLength(); i++) {
			
		}
		
		for(int i = 0; i < antsinker.getLength(); i++) {
			
		}
		
		for(int i = 0; i < foodstrg.getLength(); i++) {
			
		}
		
		for(int i = 0; i < anthill.getLength(); i++) {
			
		}
		
		
		return scene;
	}

}
