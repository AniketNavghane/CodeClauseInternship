function generateResume() {
    var resumeContent = "";
    resumeContent += "<h2>Full Name: " + document.getElementById('fullName').value + "</h2>";
    resumeContent += "<p>Address: " + document.getElementById('address').value + "</p>";
    resumeContent += "<p>Phone Number: " + document.getElementById('phoneNumber').value + "</p>";
    resumeContent += "<p>Education: " + document.getElementById('studySection').value + "</p>";
    resumeContent += "<p>Experience: " + document.getElementById('experienceSection').value + "</p>";
    resumeContent += "<p>About Yourself: " + document.getElementById('aboutYourself').value + "</p>";
    resumeContent += "<p>Languages: " + document.getElementById('languages').value + "</p>";

    document.getElementById('resumeContent').innerHTML = resumeContent;
    document.getElementById('resumeContent').style.display = 'block';
}

function downloadResume() {
    var pdf = new jsPDF();
    var resumeContent = document.getElementById('resumeContent').innerHTML;

    pdf.text(20, 20, resumeContent);
    pdf.save("resume.pdf");
}