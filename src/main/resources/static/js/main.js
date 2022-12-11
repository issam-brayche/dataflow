/**
 * Created by z00382545 on 10/20/16.
 */
 /*function fire_ajax_change() {

    var search = {}
    search["username"] = $("#username").val();

    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/search",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + JSON.stringify(data, null, 4) + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}


$(document).ready(function() {

	$("#produitChoisi").change(function(event) {

		//stop submit the form, we will post it manually.
		event.preventDefault();

		fire_ajax_change();

	});

});*/




(function($) {

	$.toggleShowPassword = function(options) {
		var settings = $.extend({
			field: "#password",
			control: "#toggle_show_password",
		}, options);

		var control = $(settings.control);
		var field = $(settings.field)

		control.bind('click', function() {
			if (control.is(':checked')) {
				field.attr('type', 'text');
			} else {
				field.attr('type', 'password');
			}
		})
	};

	$.transferDisplay = function() {
		$("#transferFrom").change(function() {
			if ($("#transferFrom").val() == 'Primary') {
				$('#transferTo').val('Savings');
			} else if ($("#transferFrom").val() == 'Savings') {
				$('#transferTo').val('Primary');
			}
		});

		$("#transferTo").change(function() {
			if ($("#transferTo").val() == 'Primary') {
				$('#transferFrom').val('Savings');
			} else if ($("#transferTo").val() == 'Savings') {
				$('#transferFrom').val('Primary');
			}
		});
	};



}(jQuery));

$(document).ready(function() {
	var confirm = function() {
		bootbox.confirm({
			title: "Appointment Confirmation",
			message: "Do you really want to schedule this appointment?",
			buttons: {
				cancel: {
					label: '<i class="fa fa-times"></i> Cancel'
				},
				confirm: {
					label: '<i class="fa fa-check"></i> Confirm'
				}
			},
			callback: function(result) {
				if (result == true) {
					$('#appointmentForm').submit();
				} else {
					console.log("Scheduling cancelled.");
				}
			}
		});
	};

	$.toggleShowPassword({
		field: '#password',
		control: "#showPassword"
	});

	$.transferDisplay();

	$(".form_datetime").datetimepicker({
		format: "yyyy-mm-dd hh:mm",
		autoclose: true,
		todayBtn: true,
		startDate: "2013-02-14 10:00",
		minuteStep: 10
	});

	$('#submitAppointment').click(function() {
		confirm();
	});

});




