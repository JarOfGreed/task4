package action;

import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by DiZi on 02.12.2015.
 */
public class Action {

    private static final Logger log = LoggerFactory.getLogger(Action.class);

        //TODO переименовать, имя не подхожящее
    private Strategy strategy;

    private Map map = new HashMap<String, Strategy>();


    /**
     * Заполнение мапы
     */
    private void any () {

        //TODO переименуй, чтобы было более систематизировано
        // тут всё на нашей совести, осторожно

        map.put("create-course", new ConcreteStrategyAdd());
        map.put("create-lecturer", new CreateLecturerStrategy());
        map.put("create-student", new CreateStudentStrategy());
        map.put("participiant-list-create", new PatricipiantListCreateStrategy());
        map.put("registration", new CreateUser());
        map.put("course-created", new FindCourse());

        map.put("update-course", new UpdateCourse());
        map.put("update-user", new UpdateUser());
        map.put("update-lecturer", new UpdateLecturer());
        map.put("update-student", new UpdateStudent());
        map.put("update-list", new UpdatePatricipiantList());

        map.put("delete-user", new DeleteUser());
        map.put("delete-list", new DeletePatricipiantList());
        map.put("delete-student", new DeleteStudent());
        map.put("delete-lecturer", new DeleteLecturer());
        map.put("course-delete", new DeleteCourse());

        map.put("find-lecturer", new FindLecturer());
        map.put("find-user", new FindUser());
        map.put("find-student", new FindStudent());
        map.put("find-list", new FindPatricipiantList());
        map.put("find-course", new FindCourse());

        map.put("find-by-login", new FindByStringAction());

        map.put("find-all-courses", new FindAllCourseAction());
        map.put("find-all-user", new FindAllUserAction());
        map.put("find-all-lecturer", new FindAllLecturer());
        map.put("find-all-students", new FindAllStudent());

    }

    /**
     *
     */
    public Action() {
        any();
    }

    /**
     *
     * @param actionName
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public void setStrategy(String actionName) throws IllegalAccessException, InstantiationException {
        this.strategy = (Strategy) map.get(actionName);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void executeStrategy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        strategy.execute(request, response);
    }
}