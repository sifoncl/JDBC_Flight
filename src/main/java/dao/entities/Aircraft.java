package dao.entities;

import java.util.Objects;

public class Aircraft {
    private int id;
    private String model;


    public Aircraft() {
    }

    public Aircraft(int id, String model) {
        this.id = id;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return id == aircraft.id && Objects.equals(model, aircraft.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model);
    }

    @Override
    public String toString() {
        return "Aircraft{" +
               "id=" + id +
               ", model='" + model + '\'' +
               '}';
    }
}
