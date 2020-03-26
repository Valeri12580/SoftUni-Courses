package softuni.exam.domain.dtos.importDtos;


import com.google.gson.annotations.Expose;
import softuni.exam.domain.Positions;

import java.math.BigDecimal;

public class ImportPlayerDto {
    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private BigDecimal salary;

    @Expose
    private int number;

    @Expose
    private Positions position;

    @Expose
    private ImportPictureDto picture;

    @Expose
    private TeamImportDto team;

    public ImportPlayerDto(String firstName, String lastName, BigDecimal salary, int number, Positions position, ImportPictureDto picture, TeamImportDto team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.number = number;
        this.position = position;
        this.picture = picture;
        this.team = team;
    }

    public ImportPlayerDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }

    public ImportPictureDto getPicture() {
        return picture;
    }

    public void setPicture(ImportPictureDto picture) {
        this.picture = picture;
    }

    public TeamImportDto getTeam() {
        return team;
    }

    public void setTeam(TeamImportDto team) {
        this.team = team;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
