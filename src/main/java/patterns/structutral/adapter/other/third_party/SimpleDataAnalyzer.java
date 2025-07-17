package patterns.structutral.adapter.other.third_party;

import lombok.AllArgsConstructor;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class SimpleDataAnalyzer implements DataAnalyzer {
    private final List<JSONType> data = new ArrayList<>();
    {
        data.add(new JSONType(1,"ali",1032.3));
        data.add(new JSONType(2,"ahmad",3.1));
        data.add(new JSONType(3,"reza",87.8));
        data.add(new JSONType(4,"mohesn",14.98));
        data.add(new JSONType(5,"hossein",9011.2));
        data.add(new JSONType(6,"hassan",4.1));
        data.add(new JSONType(7,"qasem",6.35));
    }

    @Override
    public List<JSONType> getData() {
        return data;
    }

    @Override
    public void setMean() {
        JSONType mean = new JSONType(-2, "mean", data.stream()
                .map(JSONType::getJsonValue)
                .reduce(0.0, Double::sum) / data.size());
        System.out.println("mean set in third party");

    }

    @Override
    public void setMax() {
        JSONType max = new JSONType(-1, "max", data.stream()
                .map(JSONType::getJsonValue)
                .max(Double::compare)
                .get());
        System.out.println("max set in third party");

    }

    @Override
    public void setMin() {
        JSONType min = new JSONType(0, "min", data.stream()
                .map(JSONType::getJsonValue)
                .min(Double::compare)
                .get());
        System.out.println("min set in third party");
    }

    @Override
    public void refining() {
        SecureRandom random = new SecureRandom();
        StringBuffer buffer = new StringBuffer();
        while (buffer.length() != 5)
            buffer.append((char) random.nextInt(100));
        data.stream().peek(d -> d.setJsonName(buffer.toString()));
        System.out.println("refined!");
    }
}
