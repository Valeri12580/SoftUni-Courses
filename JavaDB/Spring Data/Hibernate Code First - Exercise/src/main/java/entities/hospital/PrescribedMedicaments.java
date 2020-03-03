package entities.hospital;

import javax.persistence.*;

@Entity
@Table(name="prescribed_medicaments")
public class PrescribedMedicaments {
    private int id;
    private String name;
    private Patient patient;

    public PrescribedMedicaments() {
    }

    public PrescribedMedicaments(String name) {
        this.name = name;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @ManyToOne
    @JoinColumn(name="patient_id",referencedColumnName = "id")
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
