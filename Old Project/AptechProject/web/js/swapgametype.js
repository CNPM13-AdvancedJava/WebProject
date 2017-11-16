$(function () {

    $('#box1').click(function (e) {
        if ($('#box1').val() == 1)
        {
            $('#box2').css('display', 'block');
            $('#box3').css('display', 'none');
            $('#box4').css('display', 'none');
            $('#box5').css('display', 'none');
            $('#box6').css('display', 'none');
        }
        if ($('#box1').val() == 2)
        {
            $('#box3').css('display', 'block');
            $('#box2').css('display', 'none');
            $('#box4').css('display', 'none');
            $('#box5').css('display', 'none');
            $('#box6').css('display', 'none');
        }
        if ($('#box1').val() == 3)
        {
            $('#box4').css('display', 'block');
            $('#box2').css('display', 'none');
            $('#box3').css('display', 'none');
            $('#box5').css('display', 'none');
            $('#box6').css('display', 'none');
        }
        if ($('#box1').val() == 4)
        {
            $('#box5').css('display', 'block');
            $('#box2').css('display', 'none');
            $('#box4').css('display', 'none');
            $('#box3').css('display', 'none');
            $('#box6').css('display', 'none');
        }
         if ($('#box1').val() == 5)
        {
            $('#box6').css('display', 'block');
            $('#box2').css('display', 'none');
            $('#box4').css('display', 'none');
            $('#box3').css('display', 'none');
            $('#box5').css('display', 'none');
        }      
    });
});


