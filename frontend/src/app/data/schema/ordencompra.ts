export class OrdenCompra {

    id_orden_compra:number ;
    nro_orden_compra:string;
    fechaorden_compra:Date;
    fechaentrega: Date ;
   condicionespago:string;
    valortotal_orden:number;
    estado:number;
    proveedor:any;


   constructor(){
    this.id_orden_compra = 0;
    this.nro_orden_compra = "";
    this.fechaorden_compra = new Date();
    this.fechaentrega = new Date();
    this.condicionespago = "";
    this.valortotal_orden = 0;
    this.estado = 0;
    this.proveedor = {};
        
    }

    // método para asignar nombre a los estados
 NombreEstado(estado:number):string {

         let nombreEstado:string = "";

        switch (estado) {
            case 0:
                nombreEstado = "Generado";
                break;
            case 1:
                nombreEstado = "Recepcionado";
                break;
            case 2:
                nombreEstado = "Anulado";
                break;
            default:
                nombreEstado = "Otros";
        }

        return nombreEstado;

    }
}