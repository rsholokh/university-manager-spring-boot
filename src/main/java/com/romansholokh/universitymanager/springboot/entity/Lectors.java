package com.romansholokh.universitymanager.springboot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "lectors")
public class Lectors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Basic
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Basic
    @Column(name = "degree", nullable = false)
    private String degree;

    @Basic
    @Column(name = "salary", nullable = false)
    private int salary;

    @ManyToMany
    @JoinTable(name = "departments_lectors",
            joinColumns = @JoinColumn(name = "lectors_id"),
            inverseJoinColumns = @JoinColumn(name = "departments_id"))
    @ToString.Exclude
    Set<Departments> departments;

}
