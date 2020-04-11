package app.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "cars")
@Entity
public class Car {
    private int id;

    private String brand;

    private int year;

    private String engine;
    private String model;

    public Car(String brand, int year, String engine, String model) {
        this.brand = brand;
        this.year = year;
        this.engine = engine;
        this.model = model;
    }

    public Car() {
    }

    @Column
    @NotNull
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    @NotNull
    public String getBrand() {
        return brand;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column
    @NotNull
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}
