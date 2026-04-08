package com.hospitalVM.atenciones.services;

import com.hospitalVM.atenciones.models.Medico;
import com.hospitalVM.atenciones.models.excepcions.MedicoInexistenteExcepcions;
import com.hospitalVM.atenciones.repositories.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoServicempl implements MedicoServices {
    @Autowired
    private MedicoRepository medicoRepository;
    @Transactional(readOnly = true)
    @Override
    public List<Medico> findAll() {
        return this.medicoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Medico findByid(Long id) {
        return this.medicoRepository.findById(id).orElseThrow(
                ()-> new MedicoInexistenteExcepcions("MEDICO non encontrado")
        );
    }
    @Transactional(readOnly = true)
    @Override
    public Medico findByRun(String run) {
        return this.medicoRepository.findByIdRun(run).orElseThrow(
                ()-> new MedicoInexistenteExcepcions("Run non encontrado")
        );
    }

    @Override
    public Medico save(Medico medico) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Medico updateById(Long id, Medico medico) {
        return null;
    }
}
