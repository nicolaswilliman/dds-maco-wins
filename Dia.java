class Dia {

  private List<Venta> ventas;

  public Dia() {
    this.ventas = [];
  }

  public void agregarVenta(Venta venta) {
    ventas.push(venta);
  }

  public Float calcularGanancia() {
    return ventas
            .map(venta -> venta.ganancia())
            .reduce(0, (subtotal, ganancia) -> subtotal + ganancia);
  }
}
