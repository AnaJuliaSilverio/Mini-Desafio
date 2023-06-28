package Model;

import br.com.caelum.stella.validation.CPFValidator;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.Scanner;

public class VerificaInputs {
    public static boolean verificarCpf(String cpf) {
        try{
            CPFValidator cpfValidator = new CPFValidator();
            cpfValidator.assertValid(cpf);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public static boolean verificarEmail(String email) {
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
            return true;
        } catch (AddressException ex) {
            return false;
        }
    }
    public static void verificaNome(String nome){
        if (!nome.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Valor informado não é uma string, digite seu nome com uma String valida e sem espaço!");
        }
    }
    public static String verificaBufferScaner(String entrada){
        if (entrada.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            entrada = sc.nextLine();
        }
        return entrada;
    }
}

