package com.example.findnumber;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "findNum", value = "/find-number")
public class FindNumServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String str = req.getParameter("input");
        String str2[] = str.split("");
        String nums[] = new String[str2.length];
        int c = 0;

        for (int i = 0; i < str.length(); i++) {
            try {
                int num = Integer.parseInt(str2[i]);
                nums[c] = String.valueOf(num);
                out.print(nums[c++]);
            }catch (NumberFormatException e){

            }
        }
    }
}
