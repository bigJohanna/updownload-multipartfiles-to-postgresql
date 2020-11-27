$(document).ready(function () {
    /* Upload single File   */
    $("#uploadfile").submit(function(event) {
        $.ajax({
            type: 'POST',
            enctype: 'multipart/form-data',
            url: '/upload',
            data: new FormData(this),
            contentType: false,
            cache: false,
            processData:false,
            success: function(response){
                console.log("RESPONSE: "+response.message);
                $("#uploadresult").html("<li><p>"+response.message+"</p></li>");
            },
            error: function (error) {
                console.log(error);
            }
        });
        event.preventDefault();
    });

    /* Upload multiple Files   */
    $("#uploadmultiple").submit(function(event) {
        $.ajax({
            type: 'POST',
            enctype: 'multipart/form-data',
            url: '/api/uploadfiles',
            data: new FormData(this),
            contentType: false,
            cache: false,
            processData:false,
            success: function(response){
                let content  = '';
                $.each(response, function( i, v ) {
                    content += "<li><p>"+v.fileName+"<i><a href='"+v.fileUrl+"'>"+v.fileUrl+"</a></i></p><span></span></li>";
                });
                $("#uploadresult").html(content);
            },
            error: function (error) {
                console.log(error);
            }
        });
        event.preventDefault();
    });
});