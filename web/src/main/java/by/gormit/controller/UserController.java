package by.gormit.controller;

import by.gormit.Service;
import by.gormit.constance.Constance;
import by.gormit.pojos.User;
import com.mysql.jdbc.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Gormit on 26.08.2015.
 * Controller with pagination and sort
 * Perhaps it is no good idea to send request every time in DB,
 * all pagination and sorting operation can do in UI,
 * but I don't have skills for that, YET.
 */
@WebServlet("/users")
@MultipartConfig
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserController() {
        super();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        int page = 1;
        int countRows = 3;
        StringBuilder buffer = new StringBuilder();
        String sort = "";
        Service service = new Service();
        int lastPage;
        if (service.getCount() % countRows == 0){
            lastPage = service.getCount() / countRows;
        } else {
            lastPage = service.getCount() / countRows + 1;
        }

        if (null != request.getParameter("page")) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        if (!StringUtils.isNullOrEmpty(request.getParameter("sortId"))) {
            buffer.append("id " + request.getParameter("sortId") + ", ");
            request.setAttribute("sortId", request.getParameter("sortId"));
        }
        if (!StringUtils.isNullOrEmpty(request.getParameter("sortName"))) {
            buffer.append("name " + request.getParameter("sortName") + ", ");
            request.setAttribute("sortName", request.getParameter("sortName"));
        }
        if (!StringUtils.isNullOrEmpty(request.getParameter("sortSurname"))) {
            buffer.append("surname " + request.getParameter("sortSurname") + ", ");
            request.setAttribute("sortSurname", request.getParameter("sortSurname"));
        }
        if (!StringUtils.isNullOrEmpty(request.getParameter("sortLogin"))) {
            buffer.append("login " + request.getParameter("sortLogin") + ", ");
            request.setAttribute("sortLogin", request.getParameter("sortLogin"));
        }
        if (!StringUtils.isNullOrEmpty(request.getParameter("sortMail"))) {
            buffer.append("mail " + request.getParameter("sortMail") + ", ");
            request.setAttribute("sortMail", request.getParameter("sortMail"));
        }
        if (!StringUtils.isNullOrEmpty(request.getParameter("sortPhone"))) {
            buffer.append("phone " + request.getParameter("sortPhone") + ", ");
            request.setAttribute("sortPhone", request.getParameter("sortPhone"));
        }
        if (buffer.length() > 0) {
            buffer.insert(0, "ORDER BY ");
            sort = buffer.substring(0, buffer.length()-2);
        }

        List<User> users = service.getList(page, countRows, sort);

        request.setAttribute("users", users);
        request.setAttribute("lastPage", lastPage);
        request.setAttribute("currentPage", page);
        RequestDispatcher dispatcher = request.getRequestDispatcher(Constance.WEB_PATH_LIST_OF_USERS_PAGE);
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Part filePart = request.getPart("file");
        InputStream fileContent = filePart.getInputStream();
        new Service().save(fileContent);

        doGet(request, response);
    }

}
