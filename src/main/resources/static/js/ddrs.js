var xhr = null;

function bindIndexPage(searchUrl, selectRepositoryUrl, selectRepositoryText) {
    if($(".question-select option:selected").length) {
        ajaxSearch(searchUrl, selectRepositoryUrl, selectRepositoryText);
    }

    $("#search_form").find("[id^='select_']").each(function() {
        $(this).on("change", function(e) {
            ajaxSearch(searchUrl, selectRepositoryUrl, selectRepositoryText);
        });
    });
    $("#search_form").submit(function(event) {
        event.preventDefault();
        ajaxSearch(searchUrl, selectRepositoryUrl, selectRepositoryText);
    });
    $('[data-toggle="tooltip"]').tooltip({
        placement : 'top'
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

function ajaxSearch(searchUrl, selectRepositoryUrl, selectRepositoryText) {
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
        data["searchParameters"] = list;

        $.ajaxPrefilter(function (options, originalOptions, jqXHR) {
            jqXHR.setRequestHeader('X-CSRF-Token', $("input[name='_csrf']").val());
        });
        xhr = $.ajax({
            type: "POST",
            contentType: "application/json",
            url: searchUrl,
            data: JSON.stringify(data),
            dataType: 'json',
            timeout: 100000,
            success: function (data) {
                display(data, selectRepositoryUrl, selectRepositoryText);
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

function display(data, selectRepositoryUrl, selectRepositoryText) {
    if(data.repositories !== null) {
        $("<h3></h3>").text("There are " + data.repositories.length + " results. Make a selection to continue.").appendTo("#results");
    }
    $(data.repositories).each(function(index) {
        var $clone = createEmptyDivContainer();
        $clone.find(".repository_id_name").text(this.id + " -> " + this.name);
        $clone.find(".repository_id_name_url").attr("href", selectRepositoryUrl);
        $clone.find(".repository_id_name_url").attr("href", $clone.find(".repository_id_name_url").attr("href") + "?id=" + this.id);
        $clone.find(".repository_id_name_url").text(selectRepositoryText);
        $clone.find(".repository_url").attr("href", this.link.href);
        $clone.find(".repository_url").text(this.link.href);
        if(this.repositoryDetail !== null) {
            $clone.find(".repository_description").text(this.repositoryDetail.description);
            $clone.find(".repository_lastUpdate").text(this.repositoryDetail.lastUpdate);
            $clone.find(".repository_contact").text(this.repositoryDetail.contact);
        }
        $clone.appendTo("#results");
    });

    if(data.code === "204") {
        $("#results").text(data.msg);
    }
}

function createEmptyDivContainer() {
    var $div = $("<div/>");
    var $divContainer = $("<div/>", {"class": "container-fluid"});
    var $divRow = $("<div/>", {"class": "row"});
    var $divCol = $("<div/>", {"class": "col-md-12"});
    var $repositoryIdName = $("<p/>", {"class": "repository_id_name"});
    var $repositoryIdNameUrl = $("<a/>", {"class": "repository_id_name_url", "href": "#"});
    var $repositoryDesc = $("<p/>", {"class": "repository_description"});
    var $repositoryLastUpdate = $("<p/>", {"class": "repository_lastUpdate"});
    var $repositoryContact = $("<p/>", {"class": "repository_contact"});
    var $repositoryUrl = $("<a/>", {"class": "repository_url", "href": "#", "target": "_blank"});
    var $divider = $("<div/>", {"class": "spacer divider-horizontal"});

    return $div.append(
        $divContainer
            .append($divRow.clone().append($divCol.clone().append($repositoryIdName).append($repositoryIdNameUrl)))
            .append($divRow.clone().append($divCol.clone().append($repositoryDesc)))
            .append($divRow.clone().append($divCol.clone().append($repositoryLastUpdate)))
            .append($divRow.clone().append($divCol.clone().append($repositoryContact)))
            .append($divCol.clone().append($repositoryUrl)))
        .append($divider);
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