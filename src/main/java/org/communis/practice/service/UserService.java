package org.communis.practice.service;

import org.communis.practice.dto.UserWrapper;
import org.communis.practice.dto.filters.UserFilterWrapper;
import org.communis.practice.entity.User;
import org.communis.practice.exception.ServerException;
import org.communis.practice.exception.error.ErrorCodeConstants;
import org.communis.practice.exception.error.ErrorInformationBuilder;
import org.communis.practice.repository.UserRepository;
import org.communis.practice.repository.specifications.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService{
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getById(Long id) {
        return userRepository.findById(id);
    }

    public void add(UserWrapper userWrapper) {
        User user = new User();
        userWrapper.fromWrapper(user);
        userRepository.save(user);
    }

    public void edit(UserWrapper userWrapper) throws ServerException {
        try {
            User user = getById(userWrapper.getId());
            userWrapper.fromWrapper(user);
            userRepository.save(user);

        } catch (Exception ex) {
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_UPDATE_ERROR), ex);
        }
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Page getPageByFilter(Pageable pageable, UserFilterWrapper filterUserWrapper) throws ServerException {
        try {
            return userRepository.findAll(UserSpecification.build(filterUserWrapper), pageable)
                    .map(UserWrapper::new);
        } catch (Exception ex) {
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_LIST_ERROR), ex);
        }
    }
}
