package com.hospitalVM.atenciones.models.excepcions;

import com.hospitalVM.atenciones.repositories.MedicoRepository;

public class MedicoInexistenteExcepcions extends RuntimeException{
    public MedicoInexistenteExcepcions(String menssage){
        super(menssage);
    }
}
