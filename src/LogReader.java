import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogReader {

    private String inputFilePath;
    private String outputFilePath;

    public LogReader(String inputFilePath, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }

    public void setOutputFilePath(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    public List<NinjaLog> parse(String filePath) throws Exception {
        Path path = Path.of(filePath);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(Files.newInputStream(path));

        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("log");
        List<NinjaLog> logs = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                String id = getTagValue("Id", element);
                String name = getTagValue("Charaktername", element);
                String rank = getTagValue("Stufe", element);
                String description = getTagValue("Beschreibung", element);
                String dateStr = getTagValue("Datum", element);
                String points = getTagValue("Kraftpunkte", element);

                Date date=dateFormat.parse(dateStr);


                NinjaLog log = new NinjaLog(
                        Integer.parseInt(id),
                        name,
                        Rank.valueOf(rank),
                        description,
                        date,
                        Double.parseDouble(points)

                );

                logs.add(log);
            }
        }

        return logs;
    }

    /**
     * Helper method to extract the value of a tag from an XML element.
     *
     * @param tag the tag name
     * @param element the XML element
     * @return the tag value
     */
    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}
