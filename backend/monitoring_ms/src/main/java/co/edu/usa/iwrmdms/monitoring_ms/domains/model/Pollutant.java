package co.edu.usa.iwrmdms.monitoring_ms.domains.model;

public class Pollutant {
    private Integer pollutantId;
    private String name;
    private Float load;

    public Integer getPollutantId() {
        return pollutantId;
    }

    public void setPollutantId(Integer pollutantId) {
        this.pollutantId = pollutantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getLoad() {
        return load;
    }

    public void setLoad(Float load) {
        this.load = load;
    }
}
