package io.classiccrew.user_service.service.impl;

import org.springframework.stereotype.Service;
import io.classiccrew.user_service.dto.AppUsersDto;
import io.classiccrew.user_service.entity.AppUsers;
import io.classiccrew.user_service.mapper.UsersMapper;
import io.classiccrew.user_service.repository.UsersRepository;
import io.classiccrew.user_service.service.IUsersService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements IUsersService {
    private UsersRepository usersRepository;

    @Override
    public void createUser(AppUsersDto dto) {
        AppUsers appUsers = new AppUsers();
        UsersMapper.toUsers(dto, appUsers);
        usersRepository.save(appUsers);
    }


}
