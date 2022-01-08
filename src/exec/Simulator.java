package exec;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constants;
import input.loader.Input;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class Simulator {
    private Input input;

    public Simulator(final String inputFileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        input = mapper.readValue(Paths.get(inputFileName).toFile(), Input.class);
    }

    /**
     * Method used for parsing the input and processing it
     * Used in the main class as the entry point
     * @throws IOException in case the classes are not organised for parsing json into Java objects
     */
    public static void execute() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        for (int i = 1; i <= Constants.TESTS_NUMBER; i++) {
            String inputFile = String.format("./tests/test%d.json", i);
            String outputFile = String.format("./output/out_%d.json", i);
            Simulator simulator = new Simulator(inputFile);
            Database.getInstance().fetchData(simulator.getInput());
            String outputFileContent = mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(Database.getInstance());
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(outputFileContent);
            writer.close();
            Database.clear();
        }
    }

    /**
     * @return Getter for parsed input from JSON
     */
    public Input getInput() {
        return input;
    }
}
