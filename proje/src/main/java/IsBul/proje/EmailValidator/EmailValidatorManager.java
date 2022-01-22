package IsBul.proje.EmailValidator;

import org.springframework.stereotype.Service;

import IsBul.proje.entities.concretes.users;

@Service
public class EmailValidatorManager {
	  public String emailValidator(users user) {
	        return "Doğrulama kodu " + user.getEmail() + " adresine gönderildi";
	    }
	}

