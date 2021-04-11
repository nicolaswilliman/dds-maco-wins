
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
    const Float ganancia = prendas
                    .map(prenda -> prenda.precio()) // obtengo listado de precios
                    .reduce(0, (subtotal, precio) -> subtotal + precio); // sumo todos los precios
    return ganancia + calcularRecargo();
  }

  public Float calcularRecargo() {
    const Float totalAgregadoPrendas = prendas
                          .map(prenda -> prenda.interesAgregado()) // obtengo listado de precios
                          .reduce(0, (subtotal, valor) -> subtotal + valor);

    return this.metodoDePago.calcularRecargo(totalAgregadoPrendas);
  }

  public Int cantPrendas() {
    return prendas.count();
  }
}
