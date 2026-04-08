package com.hospitalVM.atenciones.services;

import com.hospitalVM.atenciones.models.Medico;
import com.hospitalVM.atenciones.models.excepcions.MedicoExistenteExepcion;
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

    @Transactional
    @Override
    public Medico save(Medico medico) {
        if(this.medicoRepository.findByIdRun(medico.getRun()).isPresent()){
            throw new MedicoInexistenteExcepcions("medico lol")
        }
        return this.medicoRepository.save(medico);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        this.medicoRepository.deleteById(id);

    }


    @Override
    public Medico updateById(Long id, Medico medico) {
        return this.medicoRepository.findById(id).map(element ->{
            element.setJefeTurno(medico.getJefeTurno());
            element.setNombrecompleto(medico.getNombrecompleto());
            return this.medicoRepository.save(element);

        }).orElseThrow()-> new MedicoInexistenteExcepcions("medico non encontrado");
    }
}
