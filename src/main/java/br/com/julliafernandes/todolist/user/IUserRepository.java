package br.com.julliafernandes.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserModel, UUID>{ //o primeiro paramntro entre as '<>' de : JpaRepository<UserModel, UUID>, que saber qual a classe esse JpaReository esta representando, e o segundo parametro é qual o tipo de ID esse entidade tem
    UserModel findByUsername(String username);
}
