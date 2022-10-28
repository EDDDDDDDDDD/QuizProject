package com.example.personalproject.service;

import com.example.personalproject.dao.CommentDao;
import com.example.personalproject.dao.UserDao;
import com.example.personalproject.domain.Comment;
import com.example.personalproject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private UserDao userDao;
    private CommentDao commentDao;

    @Autowired
    public UserService(@Qualifier("userDaoHibernate") UserDao userDao,
                       @Qualifier("commentDaoHibernate") CommentDao commentDao) {
        this.userDao = userDao;
        this.commentDao = commentDao;
    }

    public User getUserByID(int userID) { return  userDao.getUserByID(userID); }
    public List<User> getAllUser() { return userDao.getAllUser(); }
    public Optional<User> validateLogin(User user) {
        return userDao.validateLogin(user);
    }
    public void createNewUser(User user) { userDao.createNewUser(user); }
    public void createNewComment(Comment comment) { commentDao.createNewComment(comment); }
    public void updateUser(User user) { userDao.updateUser(user); }
    public void deleteUser(int userID) { userDao.deleteUser(userID); }
}
