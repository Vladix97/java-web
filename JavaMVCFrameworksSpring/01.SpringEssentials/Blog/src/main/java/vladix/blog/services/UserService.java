package vladix.blog.services;

import vladix.blog.models.bindingModels.UserRegisterModel;
import vladix.blog.models.viewModels.UserViewModel;

public interface UserService {

    void create(UserRegisterModel userRegisterModel);

    UserViewModel findByEmail(String email);
}
