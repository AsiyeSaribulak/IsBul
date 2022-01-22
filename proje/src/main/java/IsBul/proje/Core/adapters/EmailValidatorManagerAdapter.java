package IsBul.proje.Core.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IsBul.proje.Core.services.EmailCheckService;
import IsBul.proje.EmailValidator.EmailValidatorManager;
import IsBul.proje.entities.concretes.users;

@Service
public class EmailValidatorManagerAdapter implements EmailCheckService{
	   private final EmailValidatorManager emailValidatorManager;

	    @Autowired
	    public EmailValidatorManagerAdapter(EmailValidatorManager emailValidatorManager) {
	        this.emailValidatorManager = emailValidatorManager;
	    }
	
	@Override
	public String emailValidator(users user) {
	    return this.emailValidatorManager.emailValidator(user);
	    }
}
