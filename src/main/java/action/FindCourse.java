package action;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.factory.CourseDao;
import dao.factory.DaoFactory;
import dao.factory.GenericDao;
import entity.OptionalCourse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by DiZi on 10.12.2015.
 */
public class FindCourse implements Strategy {

    /**
     *
     */
    private static final Logger log = LoggerFactory.getLogger(FindCourse.class);

    /**
     *
     */
    public static final String ID = "id";

    /**
     * Find course by id
     *
     * @param request
     * @param response
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter(ID));

        DaoFactory daoFactory = DaoFactory.getInstance();
        daoFactory.beginTransaction();
        GenericDao genericDao = daoFactory.getDao(CourseDao.class);
        OptionalCourse optionalCourse = (OptionalCourse) genericDao.find(id);
        daoFactory.commit();

        request.setAttribute("createdcourses", optionalCourse);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/created-courses.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
