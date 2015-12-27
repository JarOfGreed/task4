package action;



import dao.factory.GenericDao;
import dao.factory.DaoFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.factory.UserDao;
import entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by DiZi on 07.12.2015.
 */
public class CreateUser implements Strategy {

    private static final Logger log = LoggerFactory.getLogger(CreateUser.class);

    public static final String USER_LOGIN = "login";

    public static final String USER_PASSWORD = "password";

    /**
     * Add user
     *
     * @param request
     * @param response
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter(USER_LOGIN);
        String password= request.getParameter(USER_PASSWORD);
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        DaoFactory daoFactory = DaoFactory.getInstance();
        daoFactory.beginTransaction();
        GenericDao genericDao = daoFactory.getDao(UserDao.class);
        genericDao.create(user);
        daoFactory.commit();
        try {
            response.sendRedirect("/list-created.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
