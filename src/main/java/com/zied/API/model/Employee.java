package com.zied.API.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data                           // @Data est une annotation Lombok. Nul besoin d’ajouter les getters et les setters. La librairie Lombok s’en charge.
@Entity                         // @Entity est une annotation qui indique que la classe correspond à une table de la base de données.
@Table(name = "employees")      // @Table(name=”employees”) indique le nom de la table associée.
public class Employee {

    @Id                                                     //  @Id : la clé primaire de la table
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // @GeneratedValue(strategy = GenerationType.IDENTITY) : id est auto-incrémenté
    private Long id;

    @Column(name="first_name")                              // pour faire le lien avec le nom du champ de la table.
    private String firstName;

    @Column(name="last_name")                               // pour faire le lien avec le nom du champ de la table.
    private String lastName;

    private String mail;

    private String password;

}