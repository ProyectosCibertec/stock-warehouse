import { Producto } from "./producto";

export class DetalleOrdenCompra {
    id_detalle_orden: number;
    producto: Producto;
    cantidad: number;
    precio_unitario: number;
    costo_detalleorden: number;
    estado: number;

    constructor() {
        this.id_detalle_orden = 0;
        this.producto = new Producto;
        this.cantidad = 0;
        this.precio_unitario = 0;
        this.costo_detalleorden = 0;
        this.estado = 0;
    }
}