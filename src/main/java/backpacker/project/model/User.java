package backpacker.project.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class User {

    private int id;

    @NotNull(message = "Nome é obrigatório")
    @NotBlank(message = "Nome é obrigatório")
    @Pattern(regexp = "[a-z-A-Z]*", message = "O nome contem caracteres inválidos")
    private String username;

    @NotNull(message = "Password é obrigatório")
    @NotBlank(message = "Password é obrigatório")
    private String password;

    @NotNull(message = "Email é obrigatório")
    @NotBlank(message = "Email é obrigatório")
    @Pattern(regexp = "", message = "Email não é válido")
    private String email;

    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(int id, String username, String password, String email) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
