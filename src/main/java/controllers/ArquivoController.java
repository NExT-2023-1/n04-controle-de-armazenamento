package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.next2023.cloud_service.entities.Arquivos;
import com.next2023.cloud_service.entities.Arquivos;
import com.next2023.cloud_service.services.ArquivosService;
import com.next2023.cloud_service.services.ArquivosService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/arquivos")
public class ArquivoController {

    @Inject
    private ArquivosService arquivosService;

    @GetMapping
    public ResponseEntity<List<Arquivos>> listAll(){
        List<Arquivos> listArquivos = arquivosService.getArquivos();
        
        return new ResponseEntity<List<Arquivos>>(listArquivos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Arquivos> create(@RequestBody @Valid Arquivos arquivo){ //Necessário criar DTO
        Arquivos arquivoCriado = arquivosService.create(arquivo); //criar pasta de SERVICO

        if(arquivoCriado == null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(arquivoCriado, HttpStatus.CREATED);
    }


/* 
    //private final ArquivosService usuarioService; // Falta criar diretório de servico

     @GetMapping
    public ResponseEntity<List<Arquivos>> listAll(){
        List<Arquivos> listArquivos = this.arquivosService.listAll();
        return new ResponseEntity<List<Arquivos>>(listArquivos, HttpStatus.OK);
    }
*/




    /*

    @GetMapping("/{id}")
    public ResponseEntity<Arquivos>getById (@PathVariable long id) {
       Arquivos arquivos = this.arquivosService.getById(id);
        if (arquivos != null){
            return new ResponseEntity<>(arquivos, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Arquivos> update(@PathVariable long id, @RequestBody @Valid ArquivosDTO arquivosDTO){
       Arquivos arquivos = arquivosService.update(id, arquivosDTO);
       if (usuario != null){
        return new ResponseEntity<>(arquivos, HttpStatus.OK);
       } 
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        if (arquivosService.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
*/

}
