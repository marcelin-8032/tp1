package com.cegefos.tp1.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.cegefos.tp1.enums.Classe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "etudiants")
public class Etudiant implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1478410950907668609L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer etudiantId;

    @Column
    private String nom;

    @Enumerated(EnumType.STRING)
    @Column
    private Classe classe;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "etudiants_examens", joinColumns = {@JoinColumn(name = "examen_id")}, inverseJoinColumns = {
            @JoinColumn(name = "etudiant_id")})
    private Set<Examen> examens = new HashSet<>();

    public Etudiant(String nom, Classe classe) {
        super();
        this.nom = nom;
        this.classe = classe;
    }

    public Etudiant(String nom, Classe classe, Set<Examen> examens) {
        super();
        this.nom = nom;
        this.classe = classe;
        this.examens = examens;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "etudiantId=" + etudiantId +
                ", nom='" + nom + '\'' +
                ", classe=" + classe +
                '}';
    }
}
