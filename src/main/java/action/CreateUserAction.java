package action;



import dao.ExceptionDao;
import dao.GenericDao;
import dao.FactoryDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.UserDao;
import entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by DiZi on 07.12.2015.
 */
public class CreateUserAction implements Strategy {

    private static final Logger log = LoggerFactory.getLogger(CreateUserAction.class);

    //TODO вынести в проперти?!
    private static final String USER_LOGIN = "login";
    private static final String USER_PASSWORD = "password";
    private static final String DIRECTORY = "directory";

    /**
     * Create a new user
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        log.info("Begin to create a new user");
        String directory = request.getParameter(DIRECTORY);
        String moveDirectory = "/WEB-INF/" + directory + ".jsp";
        String login = request.getParameter(USER_LOGIN);
        String password= request.getParameter(USER_PASSWORD);
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        log.debug("Fields are filled");
        FactoryDao factoryDao = FactoryDao.getInstance();
        GenericDao genericDao = factoryDao.getDao(UserDao.class);
        factoryDao.beginTransaction();
        try{
            log.debug("Query execution");
            genericDao.create(user);
        } catch (ExceptionDao e){
            log.error("Unable to execute query");
            factoryDao.rollback();
        }
        factoryDao.commit();
        log.info("Create user completed");
        try {
            request.getRequestDispatcher(moveDirectory).forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
