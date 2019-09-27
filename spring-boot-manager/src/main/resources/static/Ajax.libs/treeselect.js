$(function () {
    $(".研发部").onClick(function () {
        $.post("${pageContext.requtext.contextpath}/main/tree",function (data) {
            var html="";
            for (var i=0;i<data.length;i++){
                html +="<tr>"+
                    "<td>"+data[i].id+"</td>"+
                    "<td>"+data[i].userid+"</td>"+
                    "<td>"+data[i].account+"</td>"+
                    "<td>"+data[i].password+"</td>"+
                    "<td>"+data[i].sex+"</td>"+
                    "<td>"+data[i].age+"</td>"+
                    "<td>"+data[i].deparmentname+"</td>"+
                    "<td>"+data[i].staffname+"</td>"+
                    "<td>"+data[i].address+"</td>"+
                    "<td>"+data[i].phone+"</td>"

            }
            $("#tree").html(html);
        })
    })
})