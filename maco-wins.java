class GananciasDia {

}

class Venta {

  public Venta(String metodoDePago,  List<Prenda> prendas, Date fecha) {
    this.metodoDePago = metodoDePago;
    this.prendas = prendas;
    this.fecha = fecha;
  }

  private List<Prenda> prendas;
  
  private String metodoDePago;

  private Date fecha;

  // coeficiente fijo
  private Int coeficienteInteres = 2;

  public Int ganancia() {
    Int ganancia = prendas
                    .map(prenda -> prenda.precio()) // obtengo listado de precios
                    .reduce(0, (subtotal, precio) -> subtotal + precio); // sumo todos los precios
    return ganancia + calcularRecargo();

  }

  public Int calcularRecargo() {
    if (this.metodoDePago.getMetodoDePago() == "efectivo") return 0;
    Int agregadoPrendas = prendas
                          .map(prenda -> prenda.precio()) // obtengo listado de precios
                          .reduce(0, (subtotal, precio) -> subtotal + precio * 0.01);

    return this.metodoDePago.cantCuotas * this.coeficienteInteres + agregadoPrendas;
  }

  public Int cantPrendas() {
    return prendas.count();
  }
}


// si no uso un metodo de pago en clase, le tengo que pasar metodo de pago y cantCuotas al constructor de Venta
// y me podria dar un caso como efectivo y 2 cuotas.
// la hago abstracta porque no deberias poder instanciar un metodo de pago per se
abstract class MetodoDePago {
  private Int cantCuotas;

  public Int getCantCuotas() {
    return this.cantCuotas;
  }

  public abstract  String getMetodoDePago();
}

class Efectivo extends MetodoDePago {
  public Efectivo() {
    this.cantCuotas = 1;
  }

  public String getMetodoDePago() {
    return "efectivo";
  }
}

class Tarjeta extends MetodoDePago {
  public Efectivo(cantCuotas) {
    this.cantCuotas = cantCuotas;
  }

  public String getMetodoDePago() {
    return "tarjeta";
  }
}

class Prenda {

  private Estado estado;

  private Int precioBase;
  
  public Int precio() {
    return this.estado.calcularPrecio(this.precioBase);
  }
}

abstract class Estado {
  public abstract calcularPrecio();
}

class Nueva extends Estado {
  public Int calcularPrecio(Int precioBase) {
    return precioBase;
  }
}

class Promocion extends Estado {

  private Int descuento;

  public Promocion(Int descuento) {
    this.descuento = descuento;
  }

  public Int calcularPrecio(Int precioBase) {
    return precioBase - this.descuento;
  }
}

class Liquidacion extends Estado {
  public Int calcularPrecio(Int precioBase) {
    return precioBase * 0.5; //50% off 
  }
}