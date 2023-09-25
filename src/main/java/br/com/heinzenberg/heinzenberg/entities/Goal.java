package br.com.heinzenberg.heinzenberg.entities;

import java.util.UUID;

public class Goal {
    private UUID id;
    private String name;
    private double range;
    private String type;
    private String description;


    public Goal(GoalRequest goalRequest) {
        this.name = goalRequest.name();
        this.range = goalRequest.ranger();
        this.type = goalRequest.type();
        this.description = goalRequest.description();
        this.id = UUID.randomUUID();
    }

    public Goal(String name, double range, String type, String description, String id) {
        this.name = name;
        this.range = range;
        this.type = type;
        this.description = description;
        this.id = UUID.fromString(id);
    }

    public Goal() {
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRange() {
        return range;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
