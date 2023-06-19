import { Cargo } from "./cargo";

export class Empleado{
    id: number;
    nombre: string;
    apellido: string;
    correo: string;
    telefono: string;
    fechaIngreso: Date;
    fechaCese: Date;
    cargo: Cargo;
    estado: number;

    constructor(){
        this.id=0;
        this.nombre="";
        this.apellido="";
        this.correo="";
        this.telefono="";
        this.fechaIngreso=new Date();
        this.fechaCese=new Date();
        this.cargo=new Cargo;
        this.estado=0;
    }
}