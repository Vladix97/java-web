package vladix.blog.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vladix.blog.entities.Role;
import vladix.blog.entities.User;
import vladix.blog.models.bindingModels.UserRegisterModel;
import vladix.blog.models.viewModels.UserViewModel;
import vladix.blog.repositories.RoleRepository;
import vladix.blog.repositories.UserRepository;
import vladix.blog.services.UserService;
import vladix.blog.utils.parser.interfaces.ModelParser;

@Service
public class UserServiceImpl implements UserService {

    private final ModelParser modelParser;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(ModelParser modelParser, UserRepository userRepository, RoleRepository roleRepository) {
        this.modelParser = modelParser;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void create(UserRegisterModel userRegisterModel) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userRegisterModel.setPassword(bCryptPasswordEncoder.encode(userRegisterModel.getPassword()));

        User user = this.modelParser.convert(userRegisterModel, User.class);
        Role userRole = this.roleRepository.findByName("ROLE_USER");
        user.addRole(userRole);

        this.userRepository.saveAndFlush(user);
    }

    @Override
    public UserViewModel findByEmail(String email) {
        User byEmail = this.userRepository.findByEmail(email);

        if (byEmail == null) return null;

        UserViewModel userViewModel = this.modelParser.convert(byEmail, UserViewModel.class);
        return userViewModel;
    }
}
