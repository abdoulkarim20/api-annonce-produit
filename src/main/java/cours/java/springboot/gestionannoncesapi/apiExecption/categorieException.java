package cours.java.springboot.gestionannoncesapi.apiExecption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class categorieException extends RuntimeException {
    public  categorieException(String message){
        super(message);
    }
}
