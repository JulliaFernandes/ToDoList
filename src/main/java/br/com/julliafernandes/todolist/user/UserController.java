package br.com.julliafernandes.todolist.user;

// import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;


//@Controller //é utlizada quando qureremos criar uma estrutura que tenha somente paginas, se quisermos ter uma flexibilidade maior de rotornar nao so objetos utliza essa
@RestController //é quando contruimos uma API e utlizamos o conceito de Rest para entregar uma API, é a q vamos utlizar, vamo contruir uma API usando SpringBost
@RequestMapping("/users") //colcando na rota
//http://loclahost:9080/..... (essa é rota)


    /**
     * ----METODOS DE ACESSO DO HTTP PARA FAZER AS REQUISIÇÕES----
     *GET - Buscar uma informação
     *POST - Adicionar uma dado/informação dentro da aplicação
     *PUT - Alterar uma informação/dado
     *DELETE - Remover um dado/informação
     *PATCH - Alterar so uma parte da informação/dado
     */

    //Metodo para acessar a o nosso metodo do Springboot 'primeiraMensaegm'
    //METODO DE UMA CLASSE(FUNCIONALIDADE DE UMA CLASSE)
    //@GetMapping("/primeiroMetodo")//Rota para chmar esse metodo abaixo
public class UserController {

    @Autowired
    private IUserRepository userRepository; //chamando a interface
    /**
     * String(texto)
     * Integer(int) numers inteiros
     * Double
     * Float
     * char
     * Date(data)
     * void
     */
        //Ao colcoar o @RequestBody é pq oq estou recebendo vem dentro do Body que o Springboot ja entende que vem das anotacions
    @PostMapping("/")
        public ResponseEntity create(@RequestBody UserModel userModel){
        //System.out.println(userModel.getUsername());
        var user = this.userRepository.findByUsername(userModel.getUsername());
        
        if(user != null){
           //Precisa retornar mensagem de erro e o Status code
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        }

        var passwordHashred = BCrypt.withDefaults()
        .hashToString(12, userModel.getPassword().toCharArray());
        
        userModel.setPassword(passwordHashred);
        
        var userCreated = this.userRepository.save(userModel);
        
        //ao fazer:'this.userRepository.' nos abre um tanto de metodo que sao do JpaRepository, isso se da devido ao usarmos a palavra extended
        return ResponseEntity.status(HttpStatus.OK).body(userCreated);
    }
}
