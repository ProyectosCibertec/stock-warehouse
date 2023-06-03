import { DateAdapter, MatDateFormats } from "@angular/material/core";
import { MatDatepicker } from "@angular/material/datepicker";

export class CabeceraInventario {

    id_cab_inventario:number ;
    tipo_inventario:number;
    fecha_cab_inventario: Date ;
    estado:number;
    nomempleado:string;


   constructor(){
    this.id_cab_inventario = 0;
    this.tipo_inventario = 0;
    this.fecha_cab_inventario = new Date();
    this.estado = 0;
    this.nomempleado = "";
        
    }
}