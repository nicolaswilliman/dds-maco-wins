
class Venta {

  public Venta(String metodoDePago,  List<Prenda> prendas, Date fecha) {
    this.metodoDePago = metodoDePago;
    this.prendas = prendas;
    this.fecha = fecha;
  }

  private List<Prenda> prendas;
  
  private String metodoDePago;

  private Date fecha;

  public Float ganancia() {
    Float ganancia = prendas
                    .map(prenda -> prenda.precio()) // obtengo listado de precios
                    .reduce(0, (subtotal, precio) -> subtotal + precio); // sumo todos los precios
    return ganancia + calcularRecargo();
  }

  public Float calcularRecargo() {
    if (this.metodoDePago.getMetodoDePago() == "efectivo") return 0;
    
    Float coeficienteInteres = 2;
    Float agregadoPrendas = prendas
                          .map(prenda -> prenda.interesAgregado()) // obtengo listado de precios
                          .reduce(0, (subtotal, valor) -> subtotal + valor);

    return this.metodoDePago.cantCuotas * coeficienteInteres + agregadoPrendas;
  }

  public Int cantPrendas() {
    return prendas.count();
  }
}
