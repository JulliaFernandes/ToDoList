package br.com.julliafernandes.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data //Coloca os getters e setters automatico, teve de adicionar as linhas 44 a 49 no arquivo pom.xml
//Se quiser add so getters coloca so @Gettes e se for so so setter @Setters, ao fazer isso vai para todos os membros da classe

@Entity(name = "tb_users") //Ao usar isso o bacno de dados ja entende direto que a coluna vai ter o nome dos privates la em baixo
public class UserModel {
    
    @Id
    @GeneratedValue(generator = "UUID") //É para gerar o ID de forma automatica, define o tipo de gerrador é do tipo UUID
    private UUID id;

    @Column(unique = true)
    private String username;
    private String name;
    private String password;

    @CreationTimestamp//Para mostrar quando o dado for gerado de forma automatica 
    private LocalDateTime createdAt;

    //Se quiser colocar so em atributos especificos coloca em cima dele o @Getter e @Setter 
    /** Exemplo:
     * @Getter
     * @Setter
     * private String username;
     */
    //getters e setters 
}
