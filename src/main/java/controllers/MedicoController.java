package controllers;


import com.hospitalVM.atenciones.models.Medico;
import com.hospitalVM.atenciones.services.MedicoServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicos")
public class MedicoController {
    @Autowired
    private MedicoServices medicoServices

    @GetMapping
    public ResponseEntity<List<Medico>> findAll() {


            return ResponseEntity.status(HttpStatus.OK).body(this.medicoServices.findAll());
    }
    @PostMapping
    public ResponseEntity<Medico> save(@Valid @RequestBody Medico medico){
        return new ResponseEntity.status(HttpStatus.OK).body(this.medicoServices.save(medico));
    }
}
