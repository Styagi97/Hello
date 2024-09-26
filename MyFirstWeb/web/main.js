function callAjax() {
    $(document).ready(function () {
        $('#loginForm').click(function () {
            let data = {
                "FirstName": $("#fname").val(),
                "LastName": $("#lname").val(),
                "EmailID": $("#eid").val(),
                "Password": $("#psd").val(),
                "MobileNo": $("#mno").val(),
                "PanCard": $("#PanNo").val(),
                "DOB": $("#DOB").val(),
                "address": $("#addr").val(),
                "PinCode": $("#Pincode").val()
            };
            const insertMap = new Map(Object.entries(data));

            $.ajax({
                url: 'AnuragSinghal',
                type: 'post',
                data: insertMap,
                contentType: 'application/json',
                dataType: 'json',
                encode: true,
                success: function (data) {
                    console.log(data);
                      alert("Record successfully inserted");
                    console.log("success.........");
                },
                error: function (e) {
                    console.log(e);
                      alert("Record not successfully inserted");
                    console.log("Failed.........");
                }
            });
        });
    });
}

function validateDOB() {

    var dateofbirth = document.getElementById("DOB").value;
    var dob = new Date(dateofbirth);
    var month_diff = Date.now() - dob.getTime();
    var age_dt = new Date(month_diff);
    var year = age_dt.getUTCFullYear();
    var age = Math.abs(year - 1990);
    console.log(age);
    if ((age < 18) || (age > 60))
    {
        $("DOB").text("Age should be between 18 to 60 years");
        document.getElementById("DOB").value === "";
        return false;
    } else {
        $("DOB").text("");
        document.getElementById("DOB").value === "";
        return true;
    }
}
function validation()
{
    var valid = true;
    var fname = document.getElementById('fname').value;
    var lname = document.getElementById('lname').value;
    var eid = document.getElementById('eid').value;
    var psd = document.getElementById('psd').value;
    var mno = document.getElementById('mno').value;
    var PanNo = document.getElementById('PanNo').value;
    // var addr = document.getElementById('addr').value;
    var Pin = document.getElementById('Pincode').value;
    if (fname === "") {
        document.getElementById('fnamee').innerHTML = "**Please Enter the firstname**";
        return false;
        valid = false;
    }


    if ((fname.length <= 2) || (fname.length > 20)) {
        document.getElementById('fnamee').innerHTML = "**name length must be between 2 and 20";
        return false;
    }
    if (!isNaN(fname)) {
        document.getElementById('fnamee').innerHTML = "**Only character are allowed";
        return false;
    }
    if (lname === "") {
        document.getElementById('lnamee').innerHTML = "**Please enter the valid lastname";
        return false;
    }
    if (eid === "") {
        document.getElementById('emaill').innerHTML = "**Please enter the valid email id";
        return false;
    }
    if (eid.indexOf('@') <= 0) {
        document.getElementById('emaill').innerHTML = "**Invalid Position of @";
        return false;
    }
    if ((eid.charAt(eid.length - 4) !== ".") && (eid.charAt(eid.length - 3) !== ".")) {
        document.getElementById('emaill').innerHTML = "**Invalid Position of .";
        return false;
    }
    if (psd === "") {
        document.getElementById('pswd').innerHTML = "**Please enter the valid password";
        return false;
    }
    if ((psd.length <= 5) || (psd.length > 20)) {
        document.getElementById('pswd').innerHTML = "**Password length must be between 5 &20";
        return false;
    }
    if (psd.search(/[!\@\#\$\%\^\&\*\<\>\?\-\_\+\=\(\)]/) === -1) {
        document.getElementById('pswd').innerHTML = "**Password  must  Contain 1 special character";
        return false;
    }
    if (psd.search(/[A-Z]/) === -1) {
        document.getElementById('pswd').innerHTML = "**Password  must  Contain 1 Upper case  character";
        return false;
    }
    if (mno === "") {
        document.getElementById('MobileNo').innerHTML = "**Please enter the valid Mobile No";
        return false;
    }
    if (isNaN(mno)) {
        document.getElementById('MobileNo').innerHTML = "**Only digits are allowed";
        return false;
    }

    if (PanNo === "") {
        document.getElementById('PanNum').innerHTML = "**Please enter the valid PanCardNo";
        return true;
    }
    if (Pin === "") {
        document.getElementById('Pin').innerHTML = "**Please enter the valid PinCodeNo";
        return true;
    }
    if (isNaN(Pin)) {
        document.getElementById('Pin').innerHTML = "**Only digits are allowed";
        return false;
    }

    if ((Pin.length) !== 6) {
        document.getElementById('Pin').innerHTML = "**Only 6 digits are allowed";
        return false;
    }

}

