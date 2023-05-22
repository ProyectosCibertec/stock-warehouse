export class Proveedor{
    id: number;
    razonSocial: string;
    ruc: string;
    email: string;
    direccion: string;
    telefono: string;
    estado: number;

    constructor(){
        this.id=0;
        this.razonSocial="";
        this.ruc="";
        this.email="";
        this.direccion="";
        this.telefono="";
        this.estado=0;
    }
}