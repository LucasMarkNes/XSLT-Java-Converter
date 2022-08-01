import com.lowagie.text.DocumentException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class Main {

    private static final String XML = "src\\main\\java\\nfe.xml";
    private static final String XSLT = "src\\main\\java\\Template.xslt";

    public static void main(String...args) throws DocumentException, IOException {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();

        try(InputStream is = new FileInputStream(XML)){
            DocumentBuilder db = docFactory.newDocumentBuilder();
            Document doc = db.parse(is);

            try(FileOutputStream output = new FileOutputStream("src\\main\\java\\nfe.html")){
                transform(doc, output);
            }
        } catch (IOException | ParserConfigurationException| SAXException | TransformerException e){
            e.printStackTrace();
        }

        //Converter html para PDF
        String htmlFile ="src\\main\\java\\nfe.html";
        String pdfFIle ="src\\main\\java\\nfe.pdf";

        ConversorPDF conversorPDF = new ConversorPDF();
        conversorPDF.conversorHTML_PDF(htmlFile, pdfFIle);


    }

    private static void transform(Document doc, OutputStream output)throws  TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        Transformer transformer = transformerFactory.newTransformer(
                new StreamSource(new File(XSLT)));

        transformer.transform(new DOMSource(doc), new StreamResult(output));
    }
}
