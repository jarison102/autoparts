$(document).ready(function () {
    $("tr #deleteItem").click(function (e) {
        e.preventDefault();
        var idp = $(this).parent().find('#item2').val();        
        swal({
            title: "Esta Seguro de Eliminar?",
            text: "Una una Vez Eliminado, Debera Agregar de Nuevo!",
            icon: "warning",
            buttons: true,
            dangerMode: true
        }).then((willDelete) => {
            if (willDelete) {
                eliminar(idp);
                swal(" ¡Oh! ¡Registro Borrado! ", {
                    icon: "success",
                }).then((willDelete) => {
                    if (willDelete) {
                        parent.location.href = "ControladorProductos?accion=carrito";
                    }
                });
            }
        });
    });
    function eliminar(idp) {
        var url = "ControladorProductos?accion=deleteProducto&id=" + idp;
        console.log("hol");
        $.ajax({
            type: 'POST',
            url: url,
            async: true,
            success: function (r) {
            }
        });
    }

    $("tr #Cantidad").click(function () {
        var idp = $(this).parent().find("#idpro").val();
        var cantidad = $(this).parent().find("#Cantidad").val();
        var url = "ControladorProductos?accion=updateCantidad";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp=" + idp + "&Cantidad=" + cantidad,
            success: function (data, textStatus, jqXHR) {
                location.href = "ControladorProductos?accion=carrito";
            }
        });
    });    
   
});



