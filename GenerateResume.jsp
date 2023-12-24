<%@ page import="java.sql.*, javax.servlet.*, java.io.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
    <title>Generated Resume</title>
    <style>
    body{
        background-color: #8052ec;
    }
    div {
        background-color: white;
        width: 800px;
        height: 800px;
        border: 15px solid Black;
        padding: 50px;
        margin: 20px;
        }
        h1 {
            text-decoration: underline black 5px
        }
        h2 {
            text-align: left;
            text-decoration: underline black 5px
        }
        p {
            font-size: 20px;
            text-align: left;
        }
    </style>    
</head>
<body>
    <center>
    <div id="resume">
        <h1>Resume</h1>
        <h1><%= request.getParameter("fullName") %></h1><br>
        <h2>Address</h2>
        <p><%= request.getParameter("address") %></p>
        <p><%= request.getParameter("phoneNumber") %></p>
        <h2>About</h2>
        <p><%= request.getParameter("aboutYourself") %></p><br>
        <h2>Education</h2>
        <p><%= request.getParameter("studySection") %></p><br>
        <h2>Experience</h2>
        <p><%= request.getParameter("experienceSection") %></p></br>
        <h2>Languages</h2>
        <p><%= request.getParameter("languages") %></p>
    </div>

    <% 
    // Store resume data in the database using JDBC
    String fullName = request.getParameter("fullName");
    String address = request.getParameter("address");
    String phoneNumber = request.getParameter("phoneNumber");
    String studySection = request.getParameter("studySection");
    String experienceSection = request.getParameter("experienceSection");
    String aboutYourself = request.getParameter("aboutYourself");
    String languages = request.getParameter("languages");

    try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/resumebuilderdata", "root", "abc123");
        String sql = "INSERT INTO resumes (fullName, address, phoneNumber, studySection, experienceSection, aboutYourself, languages) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, fullName);
        preparedStatement.setString(2, address);
        preparedStatement.setString(3, phoneNumber);
        preparedStatement.setString(4, studySection);
        preparedStatement.setString(5, experienceSection);
        preparedStatement.setString(6, aboutYourself);
        preparedStatement.setString(7, languages);
        preparedStatement.executeUpdate();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    %>

    <%-- <button onclick="sendEmail('<%= request.getParameter("fullName") %>')">Send Email</button> --%>
    <%-- <button onclick="downloadResume()">Download PDF</button> --%>

    <%-- <script>
        function sendEmail(fullName) {
            // Implement sending email using JavaMail API
            // You can use an AJAX request to a servlet for sending emails
            alert("Email sent to " + fullName);
        }
         function downloadResume() {
        var pdf = new jsPDF();
        var resumeContent = document.getElementById('resume').innerHTML;

        // Add the resume content to the PDF
        pdf.text(20, 20, resumeContent);

        // Save the PDF with a filename "resume.pdf"
        pdf.save("resume.pdf");
    } 
    </script> --%>
    <center>
</body>
</html>



