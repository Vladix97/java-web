package vladix.blog.models.viewModels;

public class UserViewModel {

    private String email;

    private String fullName;

    public UserViewModel() { }

    public UserViewModel(String email, String fullName) {
        this.email = email;
        this.fullName = fullName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
