package com.hospitalVM.atenciones.services;

import com.hospitalVM.atenciones.models.Medico;

import java.util.List;

public interface MedicoServices {
    List<Medico> findAll();
    Medico findByid(Long id);
    Medico findByRun(String run);
    Medico save(Medico medico);
    void deleteById(Long id);
        Medico updateById(Long id, Medico medico);
}
