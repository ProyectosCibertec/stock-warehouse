import { Categoria } from "./categoria";

export class Producto{
    id: number;
    categoria: Categoria;
    codigobarra: string;
    descripcion: string;
    marca: string;
    stock:number;
    estado: number;

    constructor(){
        this.id=0;
        this.categoria= new Categoria;
        this.codigobarra="";
        this.descripcion="";
        this.marca="";
	    this.stock=0;
        this.estado=0;
    }
}