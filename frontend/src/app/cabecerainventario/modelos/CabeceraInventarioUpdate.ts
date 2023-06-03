export class CabeceraInventarioUpdate {

    id_cab_inventario:number ;
    tipo_inventario:number;
    fecha_cab_inventario: Date ;
    estado:number;
    id_empleado:number;

   constructor(){
    this.id_cab_inventario = 0;
    this.tipo_inventario = 0;
    this.fecha_cab_inventario = new Date();
    this.estado = 0;
    this.id_empleado = 0;
        
    }
}