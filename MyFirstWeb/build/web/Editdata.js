
            $(document).on('click', '.Editdata', function (e) {
                debugger;
                edit($(this));
            });

            function edit(element) {

                var tbb = element.closest("tr");
                var id = tbb.find("#tableId").text();
                var sendData = {
                    "id": id
                };
                console.log(sendData);
                $.ajax({
                    type: "post",
                    url: "http://localhost:8080/MyFirstWeb/EditStudent",
                    dataType: "json",
                    data: sendData,
                    success: function (response) {
            console.log(response);
                        $.each(response, function (keys, value) {
                            for (var data in value) {
                                $(".form-row").find("[name]").each(function (field) {
                                    var name = $(this).attr("name");
                        console.log(name);
                                    if (name == data) {
                                        $(this).val(value[data]);
                                    }
                                });
                            }
                        });
                    }
                });
            }
            const newdata = new Map();
            $(document).ready(function () {

                $(".form-row").find("input").focusout(function () {
                    $(this).addClass("isChanged");
                });
                callFocusAjax(this);
            });

            function callFocusAjax() {
                let StudentValue;
                $(document).on('click', '.Update', function () {
                    $(".isChanged").each(function ()
                    {
                        let updatekeys = $(this).attr("name");
                        let updatevalue = $(this).val();
                        StudentValue = {
                            updatekeys: updatevalue
                        };
                    });
                    console.log(StudentValue);

//                            let newMap = Object.entries();
//                            console.log(newMap);
                    debugger;
                    $.ajax({
                        url: 'UpdateStudentData',
                        type: 'post',
                        dataType: 'json',

                        data: StudentValue,
                        success: function (response) {
                            console.log(response);
                        }
                    });
                });
            } 