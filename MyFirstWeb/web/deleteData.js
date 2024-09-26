
        $(document).on('click', '.deleteBtn', function (e) {

            productDelete(this);
        });

        function productDelete(ctl) {
            var newId = $(ctl).parents("tr").find("#tableId").text();

            console.log(newId);
            var data = {
                "id": newId
            };

            $.ajax({
                url: 'http://localhost:8080/MyFirstWeb/DeleteServlet',
                type: 'post',
                data: data,
                success: function (response) {
                    console.log(response);
                    alert("Record successfully Deleted.........");
                },
                error: function (e) {
                    console.log(e);
                    console.log("Record Failed.........");
                }
            });

        }