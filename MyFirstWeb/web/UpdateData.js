//
// $(document).on('click', '.Update', function (e) {
//          let newMap = newdata.entries();
//            console.log(newMap);
//            debugger;
//            $.ajax({
//                url: 'UpdateStudentData',
//                type: 'post',
//
//                data: newMap,
//
//                success: function (data) {
//                    console.log(data);
//
//                }
//            });   
//        });
//Update
//
//        $(document).on('click', '.Update', function (e) {
//
//            getAjax(this);
//        });
//
//        function getAjax(ct) {
//
//            let StudentValue = {
//                "id": $("#Id").val(),
//                "FirstName": $("#fname").val(),
//                "LastName": $("#lname").val(),
//                "EmailID": $("#eid").val(),
//                "Password": $("#psd").val(),
//                "MobileNo": $("#mno").val(),
//                "PanCard": $("#PanNo").val(),
//                "DOB": $("#DOB").val(),
//                "address": $("#addr").val(),
//                "PinCode": $("#Pincode").val()
//            };
//
//            const myMap = new Map(Object.entries(StudentValue));
//
//            $.ajax({
//                url: 'UpdateStudentData',
//                type: 'post',
//
//                data: myMap,
//                success: function (response) {
//                    console.log(response);
//                    alert("Record  Updated");
//                    console.log("success.........");
//                },
//                error: function (e) {
//                    console.log(e);
//                    alert("Record Failed");
//                    console.log("Failed.........");
//                }
//            });
//        }        ;
