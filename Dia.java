class Dia {

  private List<Venta> ventas;

  public Dia() {
    this.ventas = [];
  }

  public void agregarVenta(Venta venta) {
    this.ventas.push(venta);
  }

  public Float calcularGanancia() {
    return this.ventas
            .map(venta -> venta.ganancia())
            .reduce(0, (subtotal, ganancia) -> subtotal + ganancia);
  }
}
