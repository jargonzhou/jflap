package automata.turing;

import file.XMLCodecTest;
import gui.environment.Universe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class TMSimulatorTest {

    @Test
    public void testSimulate() {
        final File file = new File("src/test/resources/iatlc-8.10.jff");
        TuringMachine tm = XMLCodecTest.loadTM(file);

        Universe.curProfile.setAcceptByFinalState(true);
        Universe.curProfile.setAcceptByHalting(true);
        Universe.curProfile.setDebugOutput(true);

        TMSimulator simulator = new TMSimulator(tm);
        Assertions.assertTrue(simulator.simulateInput("000111"));

        simulator = new TMSimulator(tm);
        Assertions.assertFalse(simulator.simulateInput("000101"));
    }
}

