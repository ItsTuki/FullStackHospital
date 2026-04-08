package com.hospitalVM.atenciones.models.excepcions;
import com.hospitalVM.atenciones.repositories.MedicoRepository;
public class MedicoExistenteExepcion extends RuntimeException {
    public MedicoExistenteExepcion(String menssage) {
        super(menssage);
    }
}
