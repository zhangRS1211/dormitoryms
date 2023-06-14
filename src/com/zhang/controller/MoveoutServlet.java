package com.zhang.controller;

import com.zhang.entity.Moveout;
import com.zhang.service.MoveoutService;
import com.zhang.service.StudentService;
import com.zhang.service.impl.MoveoutServiceImpl;
import com.zhang.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @BelongsProject: dormitoryms
 * @BelongsPackage: com.zhang.controller
 * @Author: 敲码的猴子
 * @CreateTime: 2022-10-19  17:34
 * @Description: TODO
 * @Version: 1.0
 */
@WebServlet("/moveout")
public class MoveoutServlet extends HttpServlet {

    private StudentService studentService = new StudentServiceImpl();
    private MoveoutService moveoutService = new MoveoutServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        switch(method){
            case "list":
                req.setAttribute("list",this.studentService.moveoutList());
                req.getRequestDispatcher("moveoutregister.jsp").forward(req,resp);
                break;
            case "moveout":
                String studentIdStr = req.getParameter("studentId");
                Integer studentId = Integer.parseInt(studentIdStr);
                String dormitoryIdStr = req.getParameter("dormitoryId");
                Integer dormitoryId = Integer.parseInt(dormitoryIdStr);
                String reason = req.getParameter("reason");
                this.moveoutService.save(new Moveout(studentId,dormitoryId,reason));
                resp.sendRedirect("/moveout?method=list");
                break;
            case "search":
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                req.setAttribute("list",this.studentService.SearchForMoveout(key,value));
                req.getRequestDispatcher("moveoutregister.jsp").forward(req, resp);
                break;
            case "record":
                req.setAttribute("list",this.moveoutService.list());
                req.getRequestDispatcher("moveoutrecord.jsp").forward(req, resp);
                break;
            case "recordSearch":
                key = req.getParameter("key");
                value = req.getParameter("value");
                req.setAttribute("list",this.moveoutService.search(key,value));
                req.getRequestDispatcher("moveoutrecord.jsp").forward(req, resp);
                break;
        }
    }
}
