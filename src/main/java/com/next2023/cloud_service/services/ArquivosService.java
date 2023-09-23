package com.next2023.cloud_service.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.next2023.cloud_service.entities.Arquivos;
import com.next2023.cloud_service.entities.Usuario;
import com.next2023.cloud_service.repositories.ArquivosRepoisitory;
import com.next2023.cloud_service.repositories.UsuarioRepository;
@Service
public class ArquivosService {

    @Inject
    private ArquivosRepoisitory arquivoRepository;
    @Inject
    private UsuarioRepository usuarioRepository;
    @Inject
    private UsuarioService usuarioService;
    @Inject
    private AwsConfigService awsConfigService;

    public Arquivos create(Arquivos arquivo){
        Long userId = arquivo.getUsuario().getId();
        Usuario usuario = usuarioRepository.findById(userId).get();
        List<Arquivos> listaArquivos = usuario.getArquivos();
        Long armazenamentoUtilizado = arquivo.getTamanhoArquivo();

        for (Arquivos arq : listaArquivos) {
            armazenamentoUtilizado = armazenamentoUtilizado + arq.getTamanhoArquivo();
        }

        boolean podeRealizarUpload = false;

        switch (usuario.getTipoPlano()){
            case "A":
                if ((usuario.getQtdeArquivosUtilizados()<20) &&
                      (armazenamentoUtilizado < 10000)){
                    podeRealizarUpload = true;
                }
                break;
            case "B":
                if ((usuario.getQtdeArquivosUtilizados()<100) &&
                      (armazenamentoUtilizado < 1000000)){
                    podeRealizarUpload = true;
                }
                break;
            case "C":
                podeRealizarUpload = true;
                break;
        }

        if (podeRealizarUpload){
            usuario.incrementarQtdeArquivosUtilizados();
            usuarioRepository.save(usuario);
            return arquivoRepository.save(arquivo);
        }else{
            return null;
        }

    }


    public List<Arquivos> getArquivos() {
        return arquivoRepository.findAll();
    }
    
}
