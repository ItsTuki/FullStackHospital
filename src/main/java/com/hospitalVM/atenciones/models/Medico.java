package com.hospitalVM.atenciones.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

    @Column(unique = true,nullable = false)
    @NotBlank(message = "el campo no puede estar vacio bro")
    @Pattern(regexp = "\\d(1,8)-[\\dKk]",message = "formato erroneo fomato xxxxxx-x")
    private String run;

    @Column(name ="nombre_completo",nullable = false )
    @NotBlank(message = "no puedes dejar el campo vacio")
    private String nombrecompleto;

    @Column(name = "jefe_turno",nullable = false)
    private Boolean jefeTurno;

    @Embeddable
    private Audit audit = new Audit();
}
