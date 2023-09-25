package com.next2023.cloud_service.services;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    public Arquivos registrarArquivo(Long idUsuario,MultipartFile arquivo){
        Usuario usuario = usuarioRepository.findById(idUsuario).get();
        List<Arquivos> listaArquivos = usuario.getArquivos();
        Long armazenamentoUtilizado = (arquivo.getSize())/1024;
        String nomeArquivo = idUsuario + "_" + arquivo.getOriginalFilename();

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

        List<Arquivos> arquivosLista = arquivoRepository.findAll();
        for (Arquivos item : arquivosLista) {
            if (item.getNomeArquivo().equals(nomeArquivo)){
                podeRealizarUpload = false;
            }
        }

        if (podeRealizarUpload){
            usuario.incrementarQtdeArquivosUtilizados();
            usuarioRepository.save(usuario);
            
            Arquivos arquivoInfo = new Arquivos();
            arquivoInfo.setNomeArquivo(nomeArquivo);
            arquivoInfo.setTamanhoArquivo(arquivo.getSize()/1024);
            arquivoInfo.setUsuario(usuario);

            return arquivoRepository.save(arquivoInfo);
        }else{
            return null;
        }

    }


    public List<Arquivos> getArquivos() {
        return arquivoRepository.findAll();
    }


    /**
     * @param idArquivo
     * @return
     */
    public void delete(Long idArquivo) {
        Arquivos arquivoInfo = arquivoRepository.findById(idArquivo).get();
        Usuario usuario = usuarioRepository.findById(arquivoInfo.getUsuario().getId()).get();
        usuario.decrementarQtdeArquivosUtilizados();

        usuarioRepository.save(usuario);
        arquivoRepository.deleteById(idArquivo);
        
    }


    public boolean arquivoExiste(long idArquivo) {
        return arquivoRepository.existsById(idArquivo);
    }


    public Arquivos getArquivoById(long idArquivo) {
        return arquivoRepository.findById(idArquivo).get();
    }
    
}
