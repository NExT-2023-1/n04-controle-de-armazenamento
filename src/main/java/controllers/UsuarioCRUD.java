package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.next2023.cloud_service.entities.Usuario;

public class UsuarioCRUD {
    public static void main(String[] args) {
        // Configuração do Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Cadastrar um novo usuário
        Usuario usuario = new Usuario();
        usuario.setCpf("12345678900");
        usuario.setEndereco("Rua 2, Boa Vista, Recife");
        usuario.setNome("Joao");
        usuario.setQtdeArquivosUtilizados(2);
        usuario.setTipoPlano("A");


        


        //   aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        // Inserir usuário no banco de dados
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(usuario);
        tx.commit();
        session.close();

        /*  Ler usuário do banco de dados
        session = sessionFactory.openSession();
        Usuario usuarioLido = session.get(Usuario.class, 1); // Supondo que o ID do usuário seja 1
        System.out.println("Nome do usuário lido: " + usuarioLido.getNome());

        // Atualizar usuário no banco de dados
        usuarioLido.setEmail("novo_email@example.com");
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.update(usuarioLido);
        tx.commit();
        session.close();

        // Deletar usuário do banco de dados
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.delete(usuarioLido);
        tx.commit();
        session.close();
        */
        // Fechar a fábrica de sessões do Hibernate
        sessionFactory.close();
    }
}