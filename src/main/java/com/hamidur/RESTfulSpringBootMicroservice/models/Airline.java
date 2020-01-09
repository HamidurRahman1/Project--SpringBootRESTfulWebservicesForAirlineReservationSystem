package com.hamidur.RESTfulSpringBootMicroservice.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "airlines")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Airline
{
    @Id
    @Column(name = "airline_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer airlineId;
    @Column(name = "airline_name")
    private String airlineName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "airline")
    private Set<Airplane> airplanes;
}
