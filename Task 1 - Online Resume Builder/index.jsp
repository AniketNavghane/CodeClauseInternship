<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <title>Resume Builder</title>
    <style>
    body{
        background-color: #8052ec;
    }
    h1 {
        text-align: center;
    }
    #app{
        background-color: white;
    }
    div {
        width: 500px;
        height: 600px;
        border: 15px solid Black;
        padding: 50px;
        text-align: left;
        }
    input[type="text"] {
        width: 350px;
        }
    textarea {
        width: 300px;
        height: 50px;
        }
    label {
        font-size: 20px;
        text-align: left;
    }    
    button{
        font-size: 23px;
        background-color: #8052ec;
        text-align: center;
    }
    </style>    
</head>
<body>
    <center>
    <div id="app">
        <h1>Resume Builder</h1>
        <form action="GenerateResume.jsp" method="post">
            <label for="fullName">Full Name:</label>
            <input type="text" id="fullName" name="fullName" required>
            <br><br>
            <label for="address">Address:</label>
            <textarea id="address" name="address" rows="4" required></textarea>
            <br><br>            
            <label for="phoneNumber">Phone Number:</label>
            <input type="tel" id="phoneNumber" name="phoneNumber" pattern="[0-9]{10}" required>
            <br><br>
            <label for="studySection">Study Section:</label>
            <textarea id="studySection" name="studySection" rows="4" required></textarea>
            <br><br>
            <label for="experienceSection">Experience Section:</label>
            <textarea id="experienceSection" name="experienceSection" rows="4" required></textarea>
            <br><br>
            <label for="aboutYourself">About Yourself:</label>
            <textarea id="aboutYourself" name="aboutYourself" rows="4" required></textarea>
            <br><br>
            <label for="languages">Languages:</label>
            <input type="text" id="languages" name="languages" required>
            <br><br>
            <button type="submit">Generate Resume</button>
        </form>
    </div>
    </center>
</body>
</html>
