package file;

import automata.turing.TuringMachine;
import file.xml.TMTransducer;
import file.xml.Transducer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLCodecTest {

    @Test
    public void testDecodeTM() {
        final File file = new File("src/test/resources/iatlc-8.10.jff");
        Assertions.assertNotNull(loadTM(file));
    }

    public static TuringMachine loadTM(File file) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            // SKIP JOptionPane
//            Transducer transducer = TransducerFactory.getTransducer(doc);
            Transducer transducer = new TMTransducer(); // or TMBBTransducer
            return (TuringMachine) transducer.fromDOM(doc);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
