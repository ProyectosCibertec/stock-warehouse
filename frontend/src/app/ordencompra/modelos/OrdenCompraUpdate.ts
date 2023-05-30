export class OrdenCompraUpdate {

    id_orden_compra:number;
    nro_orden_compra:string;
    fechaorden_compra:Date;
    fechaentrega: Date ;
    condicionespago:string;
    valortotal_orden:number;
    estado:number;
    proveedorId:number;

   constructor(){
    this.id_orden_compra = 0 ;
    this.nro_orden_compra = "";
    this.fechaorden_compra = new Date();
    this.fechaentrega = new Date();
    this.condicionespago = "";
    this.valortotal_orden = 0;
    this.estado = 0;
    this.proveedorId = 0;
        
    }
}