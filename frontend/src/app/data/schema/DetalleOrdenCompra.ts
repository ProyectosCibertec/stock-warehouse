export class DetalleOrdenCompra{
    producto:any;
    cantidad:number;
    precio_unitario:number;
    costo_detalleorden:number;
    estado:number;

    constructor(){
        this.producto = {};
        this.cantidad = 0;
        this.precio_unitario = 0;
        this.costo_detalleorden=0;
        this.estado=0;

    }
}