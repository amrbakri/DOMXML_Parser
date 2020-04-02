package xmlParser02;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class xmlParser02 {

	public static void main(String argv[]) {
		try {
			File fXmlFile = new File("D:\\workspace01\\xmlParser02\\lamp-example01.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("document");
		 
			System.out.println("----------------------------");
			System.out.println(nList.getLength());
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				System.out.println("\n"+nList.getLength());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					if(eElement.getElementsByTagName("place") != null){
                        System.out.println("x:" + eElement.getAttributeNode("group").getTextContent());
                        System.out.println("place : " + eElement.getElementsByTagName("place").item(0).getTextContent());
                        //System.out.println("x : " + eElement.getElementsByTagName("x").item(0).getTextContent());
                        System.out.println("group : " + eElement.getElementsByTagName("group").item(0).getTextContent());
				
			}// end if
			}// end if
				
				/*if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("Staff id : " + eElement.getAttribute("id"));
					System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
				}*/// end if
			}
	       } catch (Exception e) {
		e.printStackTrace();
		}
	}
}
