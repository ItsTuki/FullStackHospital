package com.hospitalVM.atenciones.models;

import jakarta.persistence.Embeddable;

public class Medico {
    @Embeddable
    private Audit audit = new Audit();
}
