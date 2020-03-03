package entities.hospital;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="patients")
public class Patient {
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private LocalDateTime birthDate;
    private String image;//string e ,zashtoto e po dobre da se pazi link kum snimkata,koqto se namira na drug survur
    private boolean isMedicalInsured;
    private Set<Visitation> visitations;
    private Set<Diagnoses>diagnoses;
    private Set<PrescribedMedicaments> medicaments;

    public Patient() {
    }

    public Patient(String firstName, String last_name, String address, LocalDateTime birthDate, String image, boolean isMedicalInsured, Set<Visitation> visitations, Set<Diagnoses> diagnoses, Set<PrescribedMedicaments> medicaments) {
        this.firstName = firstName;
        this.lastName = last_name;
        this.address = address;
        this.birthDate = birthDate;
        this.image = image;
        this.isMedicalInsured = isMedicalInsured;
        this.visitations = visitations;
        this.diagnoses = diagnoses;
        this.medicaments = medicaments;
    }

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(name="uuid-string",strategy = "org.hibernate.id.UUIDGenerator")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name="first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }
    @Column(name="address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Column(name="birthdate")
    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }
    @Column(name="image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    @Column(name="is_medicalInsured")
    public boolean isMedicalInsured() {
        return isMedicalInsured;
    }

    public void setMedicalInsured(boolean medicalInsured) {
        isMedicalInsured = medicalInsured;
    }


    @OneToMany(mappedBy = "patient",targetEntity = Visitation.class)
    public Set<Visitation> getVisitations() {
        return visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }
    @OneToMany(mappedBy = "patient",targetEntity = Diagnoses.class)
    public Set<Diagnoses> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnoses> diagnoses) {
        this.diagnoses = diagnoses;
    }
    @OneToMany(mappedBy = "patient",targetEntity = PrescribedMedicaments.class)
    public Set<PrescribedMedicaments> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(Set<PrescribedMedicaments> medicaments) {
        this.medicaments = medicaments;
    }
}
