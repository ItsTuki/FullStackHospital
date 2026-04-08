package com.hospitalVM.atenciones.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "medicos")
@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medico_id")
    private long medicoId;

    @Embeddable
    private Audit audit = new Audit();
}
