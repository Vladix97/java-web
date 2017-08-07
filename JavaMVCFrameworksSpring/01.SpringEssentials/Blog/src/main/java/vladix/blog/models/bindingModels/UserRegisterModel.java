package vladix.blog.models.bindingModels;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterModel {

    private String email;

    private String fullName;

    private String password;

    private String confirmPassword;

    public UserRegisterModel() { }

    public UserRegisterModel(String email, String fullName, String password, String confirmPassword) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    @NotNull
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull
    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @NotNull
    @Size(min = 8, max = 60)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull
    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
