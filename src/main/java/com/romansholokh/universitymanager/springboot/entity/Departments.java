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
@Table(name = "departments")
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "head_of_department_id", referencedColumnName = "id")
    private Lectors headOfDepartmentId;

    @ManyToMany
    @JoinTable(name = "departments_lectors",
            joinColumns = @JoinColumn(name = "departments_id"),
            inverseJoinColumns = @JoinColumn(name = "lectors_id"))
    @ToString.Exclude
    Set<Lectors> lectors;

}
