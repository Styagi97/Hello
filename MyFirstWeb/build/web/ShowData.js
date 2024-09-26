(function () {
//Table
    $(document).ready(function () {
        debugger;

        $.getJSON("http://localhost:8080/MyFirstWeb/ShowData", function (data) {


            $.each(data, function (key, value) {

                $("#country").append("<tr id='columnId'><td  id='tableId'>" + value.Id + "</td><td>" + value.FirstName + "</td>"
                        + "<td>" + value.LastName + "</td><td>" + value.EmailID + "</td>" + "</td><td>" + value.Password + "</td>"
                        + "<td>" + value.MobileNumber + "</td><td>" + value.PanCard + "</td>"
                        + "<td>" + value.DOB + "</td><td>" + value.addr + "</td>"
                        + "<td>" + value.PinCode + "</td><td><button type='button' class='Editdata'  >Edit</button>\n\
                <button type='submit' class='deleteBtn'>Delete</button></td>"
                        );
            });
        });
    });
})();
const button = document.getElementById("download-button");

function generatePDF() {
    // Choose the element that your content will be rendered to.
    const element = document.getElementById("invoice");
    // Choose the element and save the PDF for your user.
    html2pdf().from(element).save();
}

button.addEventListener("click", generatePDF);

        