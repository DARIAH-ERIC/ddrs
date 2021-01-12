var xhr = null;

function bindIndexPage(searchUrl, ddrsOrPsp, searchObject, clearUrl) {
    checkOldSelectedRepositories(searchObject);

    if($(".question-select option:selected").length) {
        ajaxSearch(searchUrl, ddrsOrPsp);
    }

    $("#search_form").find("[id^='select_']").each(function() {
        $(this).on("change", function(e) {
            ajaxSearch(searchUrl, ddrsOrPsp);
        });
    });
    $("#search_form").submit(function(event) {
        event.preventDefault();
        ajaxSearch(searchUrl, ddrsOrPsp);
    });
    $('[data-toggle="tooltip"]').tooltip({
        placement : 'top'
    });
    $(".clear").click(function(e) {
        e.preventDefault();
        clearSession(clearUrl);
    });
}

function checkOldSelectedRepositories(searchObject) {
    $("#search_form").find("[id^='select_']").each(function() {
        if(searchObject.internSearchParameters.hasOwnProperty($(this).attr("name"))) {
            $(this).val(searchObject.internSearchParameters[$(this).attr("name")][0]);
        }
    });
}

function bindQuestionsPage() {
    $(".question-select").change(function() {
        changeButtons($(this));
    });
}

function isObjectEmpty(obj) {
    for(var key in obj) {
        if(obj.hasOwnProperty(key))
            return false;
    }
    return true;
}

function ajaxSearch(searchUrl, ddrsOrPsp) {
    if(xhr !== null) {
        xhr.abort();
        xhr = null;
    }
    var data = {};
    var list = {};
    $("#search_form").find("[id^='select_']").each(function() {
        if($(this).val() !== "")
            list[$(this).attr('name')] = $(this).val();
    });

    if(! isObjectEmpty(list)) {
        list['ddrsOrPsp'] = ddrsOrPsp;
        data["searchParameters"] = list;

        $.ajaxPrefilter(function (options, originalOptions, jqXHR) {
            jqXHR.setRequestHeader('X-CSRF-Token', $("input[name='_csrf']").val());
        });
        xhr = $.ajax({
            type: "POST",
            contentType: "application/json",
            url: searchUrl,
            data: JSON.stringify(data),
            timeout: 100000,
            success: function (data) {
                $("#results").html(data);
            },
            error: function (e) {
                console.log("ERROR: ", e);
                $("#results").text("There was an error, please try again later...");
            },
            complete: function (e) {
                $("#loader").addClass("hidden");
            },
            beforeSend: function (e) {
                $("#results").empty();
                $("#loader").removeClass("hidden");
            }
        });
    }
}

function clearSession(clearUrl, homeUrl) {
    if(xhr !== null) {
        xhr.abort();
        xhr = null;
    }
    $.ajaxPrefilter(function (options, originalOptions, jqXHR) {
        jqXHR.setRequestHeader('X-CSRF-Token', $("input[name='_csrf']").val());
    });
    xhr = $.ajax({
        type: "POST",
        contentType: "application/json",
        url: clearUrl,
        timeout: 10000,
        success: function (data) {
            location.reload();
        },
        error: function (e) {
            console.log("ERROR: ", e);
            location.reload();
        }
    });
}

function changeButtons(selectElement) {
    var $ident = $(selectElement).attr('id').replace("select_", "");
    changeAttr([], ["#btn_delete_" + $ident, "#btn_edit_" + $ident]);
    if($(selectElement).children('option:first-child').is(':selected')) {
        changeAttr(["#btn_top_" + $ident, "#btn_up_" + $ident], ["#btn_down_" + $ident, "#btn_bottom_" + $ident]);
    } else if($(selectElement).children('option:last-child').is(':selected')) {
        changeAttr(["#btn_down_" + $ident, "#btn_bottom_" + $ident], ["#btn_top_" + $ident, "#btn_up_" + $ident]);
    } else if($(selectElement).children('option').is(':selected')) {
        changeAttr([], ["#btn_top_" + $ident, "#btn_up_" + $ident, "#btn_down_" + $ident, "#btn_bottom_" + $ident]);
    }
}

function changeAttr(toDisable, toEnable) {
    $.each(toDisable, function(index, value) {
        $(value).attr("disabled", "disabled");
    });
    $.each(toEnable, function(index, value) {
        $(value).removeAttr("disabled");
    });
}

function linkToModal(questionId) {
    $("#modal").modal('show');
    event.preventDefault();

    $("#modal_code").val("");
    $("#modal_english").val("");
    $("#question_identifier").val(questionId);
}