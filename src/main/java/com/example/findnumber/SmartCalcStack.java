package com.example.findnumber;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;

@WebServlet(name = "smartCalc", value = "/calc")
public class SmartCalcStack extends HttpServlet {

    Stack<String> stack = new Stack<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String str = req.getParameter("exp").replace(" ", "");
        String str2[] = str.split("");

        String inorder[] = new String[str2.length]; // 중위 표기법
        String postorder[] = new String[str2.length]; // 후위 표기법
        String num = "";
        String result = "";
        int n = 0;
        int c = 0;

      //  try{
            for (int i = 0; i < str.length(); i++) {
                try {
                    Integer.parseInt(str2[i]);
                    num = num + str2[i];
                }catch (NumberFormatException e) {
                    if (num != "") {
                        inorder[n++] = num;
                        num = "";
                    }
                    /*if (str2[i].equals("-")) {
                        num = "-";
                        inorder[n++] = "+";
                        continue;
                    }
                     */
                    inorder[n++] = str2[i];
                }
                inorder[n] = num;
            }



            for (int i = 0; i < inorder.length; i++) {
                try {
                    if (inorder[i] == null) break;
                    Integer.parseInt(inorder[i]);
                    postorder[c++] = inorder[i];
                }catch (NumberFormatException e) {
                    if(!stack.isEmpty()){
                        if (stack.peek().equals("*") | stack.peek().equals("/")) {
                            postorder[c++] = stack.pop();
                        }
                    }
                    stack.push(inorder[i]);
                    if (stack.peek().equals(")")) {
                        stack.pop();
                        while (!stack.peek().equals("(")) {
                            postorder[c++] = stack.pop();
                        }
                        stack.pop();
                    }
                }
            }

            while(!stack.isEmpty())
                postorder[c++] = stack.pop();



            for (int i = 0; i < postorder.length; i++) {
                try{
                    if (postorder[i] == null) break;
                    Integer.parseInt(postorder[i]);
                    stack.push(postorder[i]);

                }catch (NumberFormatException e){

                    int num2 = Integer.parseInt(stack.pop());
                    int num1 = Integer.parseInt(stack.pop());

                    switch (postorder[i]) {
                        case "+":
                            stack.push(String.valueOf(num1 + num2));
                            break;
                        case "-":
                            stack.push(String.valueOf(num1 - num2));
                            break;
                        case "*":
                            stack.push(String.valueOf(num1 * num2));
                            break;
                        case "/":
                            stack.push(String.valueOf(num1 / num2));
                            break;
                    }
                }
            }
            result = stack.pop();
            req.setAttribute("result", result);

        /*}catch (Exception e){
            result = "올바른 표현식이 아닙니다.";
            req.setAttribute("result", result);
        }*/

        RequestDispatcher rd = req.getRequestDispatcher("calc.jsp");
        rd.forward(req, resp);



    }
}
