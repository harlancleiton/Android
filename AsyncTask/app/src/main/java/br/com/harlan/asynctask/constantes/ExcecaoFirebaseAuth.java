package br.com.harlan.asynctask.constantes;

public interface ExcecaoFirebaseAuth {
    String FIREBASE_AUTH_CREATE_USER_SUCCESS = "Usuário cadastrado com sucesso.";
    String FIREBASE_AUTH_INVALID_CREDENTIALS_EXCEPTION = "O e-mail digitado é inválido, digite um novo e-mail.";
    String FIREBASE_AUTH_WEAK_PASSWORD_EXCEPTION = "Digite uma senha mais forte, contendo mais caracteres e com letras e números.";
    String FIREBASE_AUTH_USER_COLLISION_EXCEPTION = "Esse e-mail já está em uso.";
    String FIREBASE_AUTH_EXCEPTION = "Erro ao cadastrar usuário.";
}
