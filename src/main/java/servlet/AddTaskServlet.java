package servlet;

import Objects.Task;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/tasks/add")  // Ensure this matches the cURL request path
public class AddTaskServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        if (getServletContext().getAttribute("taskList") == null) {
            getServletContext().setAttribute("taskList", new ArrayList<Task>());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("request.getParameter(\"title\")");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String deadline = request.getParameter("deadline");

        response.setContentType("text/xml");
        List<Task> tasks = (List<Task>) getServletContext().getAttribute("taskList");
        System.out.println(title);
        Task newTask = new Task(title, description, deadline);
        tasks.add(newTask);

        getServletContext().setAttribute("taskList", tasks);

        response.getWriter().println("Task added successfully!");
    }
}