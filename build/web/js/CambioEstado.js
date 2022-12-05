function alertaInactivarC(id, estado_compra) {
    swal.fire({
        icon: 'success',
        title: '&iquest;¿Quiere Finalizar La Compra?',
        text: "Una vez de por finalizada la compra, se acabara el proceso",
        padding: '2em 0',
          color: '#252121',
        backdrop: `rgba(78 ,120, 252,0.3)`,
        confirmButtonColor: '#0059FF',
       
        confirmButtonText: 'Finalizar!'
    }).then((result) => {
        if (result.isConfirmed) {

            window.location = ("ControladorCambioC?id=" + id + "&action=" + estado_compra);
        }
    });
}

function alertaActivarC(id, estado_compra) {
    swal.fire({
        icon: 'error',
        title: '&iquest;¿Pendiente?',
        text: "Una vez confirme, la Compra estarà en pendiente",
        padding: '2em 0',
        color: '#252121',
        backdrop: `rgba(78 ,120, 252,0.3)`,
        confirmButtonColor: '#FF4B4B',
        confirmButtonText: 'Pendiente!'
    }).then((result) => {
        if (result.isConfirmed) {

            window.location = ("ControladorCambioC?id=" + id + "&action=" + estado_compra);
        }
    });
}

function alertaInactivarV(id, estado_venta) {
    swal.fire({
        icon: 'success',
        title: '&iquest;¿Quiere Finalizar La venta?',
        text: "Una vez de por finalizada la venta, se acabara el proceso",
        padding: '2em 0',
          color: '#252121',
        backdrop: `rgba(78 ,120, 252,0.3)`,
        confirmButtonColor: '#0059FF',
       
        confirmButtonText: 'Finalizar!'
    }).then((result) => {
        if (result.isConfirmed) {

            window.location = ("ControladorCambioV?id=" + id + "&action=" + estado_venta);
        }
    });
}

function alertaActivarV(id, estado) {
    swal.fire({
        icon: 'error',
        title: '&iquest;¿Pendiente?',
        text: "Una vez confirme, la Compra estarà en pendiente",
        padding: '2em 0',
        color: '#252121',
        backdrop: `rgba(78 ,120, 252,0.3)`,
        confirmButtonColor: '#FF4B4B',
        confirmButtonText: 'Confirmar!'
    }).then((result) => {
        if (result.isConfirmed) {

            window.location = ("ControladorCambioV?id=" + id + "&action=" + estado);
        }
    });
}     

function alertaActivarP(id, estado) {
    swal.fire({
        icon: 'error',
        title: '&iquest;¿Agotado ?',
        text: "Una vez de En proceso la venta, se iniciara el proceso",
        padding: '2em 0',
        color: '#252121',
        backdrop: `rgba(78 ,120, 252,0.3)`,
        confirmButtonColor: '#FF4B4B',
        confirmButtonText: 'Agotado!'
    }).then((result) => {
        if (result.isConfirmed) {

            window.location = ("ControladorCambioP?id=" + id + "&action=" + estado);
        }
    });
}     

function alertaInactivarP(id, estado) {
    swal.fire({
        icon: 'error',
        title: '&iquest;¿Disponible ?',
        text: "NOSE",
        padding: '2em 0',
        color: '#252121',
        backdrop: `rgba(78 ,120, 252,0.3)`,
        confirmButtonColor: '#FF4B4B',
        confirmButtonText: 'Disponible!'
    }).then((result) => {
        if (result.isConfirmed) {

            window.location = ("ControladorCambioP?id=" + id + "&action=" + estado);
        }
    });
}     

function alertaActivarU(id_usuario, estado_usuario) {
    swal.fire({
        icon: 'error',
        title: '&iquest;¿Desea Activar el usuario ?',
        text: "Una vez confirme , se Activara el Usuario",
        padding: '2em 0',
        color: '#252121',
        backdrop: `rgba(78 ,120, 252,0.3)`,
        confirmButtonColor: '#FF4B4B',
        confirmButtonText: 'Confirmar!'
    }).then((result) => {
        if (result.isConfirmed) {

            window.location = ("ControladorCambioUsu?id_usuario=" + id_usuario + "&action=" + estado_usuario);
        }
    }); 
}     

function alertaInactivarU(id_usuario, estado_usuario) {
    swal.fire({
        icon: 'error',
        title: '&iquest;¿Desea Inactivar el usuario?',
        text: "Una vez confirme , se Inactivara el Usuario",
        padding: '2em 0',
        color: '#252121',
        backdrop: `rgba(78 ,120, 252,0.3)`,
        confirmButtonColor: '#FF4B4B',
        confirmButtonText: 'Confirmar!'
    }).then((result) => {
        if (result.isConfirmed) {

            window.location = ("ControladorCambioUsu?id_usuario=" + id_usuario + "&action=" + estado_usuario);
        }
    });
}    

function alertaInactivarQ(id_queja, estado_queja) {
    swal.fire({
        icon: 'success',
        title: '&iquest;¿Quiere Finalizar la Queja?',
        text: "Una vez de por finalizada la Queja, se acabara el proceso",
        padding: '2em 0',
          color: '#252121',
        backdrop: `rgba(78 ,120, 252,0.3)`,
        confirmButtonColor: '#0059FF',
       
        confirmButtonText: 'Finalizar!'
    }).then((result) => {
        if (result.isConfirmed) {

            window.location = ("ControladorCambioQ?id_queja=" + id_queja + "&action=" + estado_queja);
        }
    });
}

function alertaActivarQ(id_queja, estado_queja) {
    swal.fire({
        icon: 'error',
        title: '&iquest;¿Pendiente ?',
        text: "Una vez confirme, la Queja estarà en pendiente",
        padding: '2em 0',
        color: '#252121',
        backdrop: `rgba(78 ,120, 252,0.3)`,
        confirmButtonColor: '#FF4B4B',
        confirmButtonText: 'Confirmar!'
    }).then((result) => {
        if (result.isConfirmed) {

            window.location = ("ControladorCambioQ?id_queja=" + id_queja + "&action=" + estado_queja);
        }
    });
}







