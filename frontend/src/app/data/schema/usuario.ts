export class Usuario{
    id_usuario: number;
    idTipoUsuario: number;
    idEmpleado: number;
    nombreTipoUsuario: string;
    nombreCompletoEmpleado: string;
    login_usuario: string;
    contrasena_usuario: string;
    estado: number;
    empleado:any;
    tipoUsuario:any;

    constructor(){
        this.id_usuario=0;
        this.idTipoUsuario=0;
        this.idEmpleado=0;
        this.nombreTipoUsuario="";
        this.nombreCompletoEmpleado="";
        this.login_usuario="";
        this.contrasena_usuario="";
        this.estado=0;
    }
    



}