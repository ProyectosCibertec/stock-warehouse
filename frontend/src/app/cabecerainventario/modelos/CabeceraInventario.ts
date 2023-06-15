

export class CabeceraInventario {

    id_cab_inventario:number ;
    tipo_inventario:number;
    fecha_cab_inventario: Date ;
    estado:number;
    empleado:any;


   constructor(){
    this.id_cab_inventario = 0;
    this.tipo_inventario = 0;
    this.fecha_cab_inventario = new Date();
    this.estado = 0;
    this.empleado = {};
        
    }

    //metodo para asignar nombre a los tipos de inventario

    NombreInventario(tipo_inventario:number):string {

        let nombreInventario:string = "";

        switch(tipo_inventario){
            case 0:
                nombreInventario = "Entrada";
                break;
            case 1:
                nombreInventario = "Salida";
                break;
        }
        return nombreInventario;
    }

    // método para asignar nombre a los estados
 NombreEstado(estado:number):string {

    let nombreEstado:string = "";

   switch (estado) {
       case 0:
           nombreEstado = "Realizado";
           break;
       case 1:
           nombreEstado = "Pendiente";
           break;
       case 2:
           nombreEstado = "Anulado";
           break;
   }

   return nombreEstado;

}
}