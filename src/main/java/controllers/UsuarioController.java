package controllers;




import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.next2023.cloud_service.entities.Usuario;
import com.next2023.cloud_service.services.AwsConfigService;
import com.next2023.cloud_service.util.AwsConfig;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

@Inject
    public AwsConfigService awsConfigService; // usado para teste. remover

    @GetMapping
    public ResponseEntity<List<Usuario>> listAll(){
        List<Usuario> listUsuarios = new ArrayList<Usuario>();
        awsConfigService.listBuckets();
        return new ResponseEntity<List<Usuario>>(listUsuarios, HttpStatus.OK);
    }

/* 
    @GetMapping
    public ResponseEntity<List<Usuario>> listAll(){
        List<Usuario> listUsuarios = this.usuarioService.listAll();
        return new ResponseEntity<List<Usuario>>(listUsuarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody @Valid UsuarioDTO usuarioDTO){ //Necessário criar DTO
    Usuario usuario = usuarioService.create(usuarioDTO); //criar pasta de SERVICO
    return new ResponseEntity<>(usuario, HttpStatus.CREATED);

    }


    @GetMapping("/{id}")
    public ResponseEntity<Usuario>getById (@PathVariable long id) {
        Usuario usuario = this.usuarioService.getById(id);
        if (usuario != null){
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable long id, @RequestBody @Valid UsuarioDTO usuarioDTO){
       Usuario usuario = usuarioService.update(id, usuarioDTO);
       if (usuario != null){
        return new ResponseEntity<>(usuario, HttpStatus.OK);
       } 
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        if (usuarioService.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    */
}
