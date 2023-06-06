export class Usuario{
    id: number;
    login_usuario: string;
    contrasena_usuario: string;
    estado: number;

    constructor(){
        this.id=0;
        this.login_usuario="";
        this.contrasena_usuario="";
        this.estado=0;
    }
}