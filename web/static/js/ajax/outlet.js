function outletAjax(id) {
    $.ajax({
        url: getUrl(id)
    });
}
function getUrl(id) {
    var ctx = window.location.pathname,
        path = '/' !== ctx ? ctx.substring(0, ctx.indexOf('/', 1) + 1) : ctx;
    var toReturn = path + (/\/$/.test(path) ? '' : '/') + "outlet/" + id;
    var button = document.getElementById("button_" + id);
    if (button.className == "btn btn-block btn-danger btn-flat") {
        button.className = "btn btn-block btn-success btn-flat";
    } else {
        button.className = "btn btn-block btn-danger btn-flat";
    }
    return toReturn;
}