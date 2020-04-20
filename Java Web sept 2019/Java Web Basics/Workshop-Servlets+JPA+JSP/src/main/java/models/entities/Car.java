package models.entities;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car  extends BaseEntity{

    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private int year;

    @Column
    private String engine;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User  user;

    public Car() {
    }

    public Car(String brand, String model, int year, String engine) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engine = engine;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
