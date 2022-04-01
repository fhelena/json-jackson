import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Atleta;
import model.Time;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class TimeAtleta {

    public static void execute() throws JsonGenerationException, JsonMappingException, IOException {

        Atleta a1 = new Atleta(1, "Vampeta", 31, "Football", "Attacker");
        Atleta a2 = new Atleta(2, "Nikolas Cagezinho", 35, "Football", "Goalkeeper");

        List<Atleta> atletas = new ArrayList<>();
        atletas.add(a1);
        atletas.add(a2);

        Time time = new Time(1, "Pipoca FC", atletas);

        String json = serialize(time);
        System.out.println(json);

    }

    private static String serialize(Time time) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        //serializing team data
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, time);

        return writer.toString();
    }

}
