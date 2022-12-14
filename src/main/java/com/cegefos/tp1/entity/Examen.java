package com.cegefos.tp1.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "examens")
public class Examen implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6958515320559275010L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer examenId;

    @Column
    private Date dateExam;

    @ManyToMany(mappedBy = "examens")
    private Set<Etudiant> etudiants = new HashSet<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "surveillant_id")
    private Surveillant surveillant;

    public Examen(Date dateExam, Matiere matiere, Salle salle, Surveillant surveillant) {
        super();
        this.dateExam = dateExam;
        this.matiere = matiere;
        this.salle = salle;
        this.surveillant = surveillant;
    }


    @Override
    public String toString() {
        return "Examen{" +
                "examenId=" + examenId +
                ", dateExam=" + dateExam +
                ", matiere=" + matiere +
                ", salle=" + salle +
                ", sureillant=" + surveillant +
                '}';
    }
}
