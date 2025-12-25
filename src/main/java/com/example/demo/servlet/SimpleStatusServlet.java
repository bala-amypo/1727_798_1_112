// package com.example.demo.servlet;

// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import java.io.IOException;

// public class SimpleStatusServlet extends HttpServlet {

//     @Override
//     protected void doGet(HttpServletRequest request, HttpServletResponse response)
//             throws IOException {

//         response.setContentType("text/plain");
//         response.getWriter().write("Status OK");
//     }
// }
package com.example.demo.servlet;

import jakarta.servlet.http.*;
import java.io.IOException;

public class SimpleStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.getWriter().write("Digital Credential Verification Engine is running");
    }
}
