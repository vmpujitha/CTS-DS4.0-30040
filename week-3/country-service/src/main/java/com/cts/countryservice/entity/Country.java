package com.cts.countryservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @Column(name = "co_code", length = 2)
    private String code;

    @Column(name = "co_name", nullable = false)
    private String name;
}
