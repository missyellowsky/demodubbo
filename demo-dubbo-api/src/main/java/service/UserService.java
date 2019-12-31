package service;

import domain.UserDO;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

public interface UserService {

    UserDO findById(@NotBlank Long id);

    List<UserDO> listUser();

    List<Map<String, Object>> countGnqmcTotal();
}
