class Prenda {

  private Estado estado;

  private String tipo;

  private Float precioBase;

  public Prenda(String tipo, Estado estado, Float precioBase) {
    const List<String> tiposDePrenda = ["saco", "pantalon", "camisa"];

    if (!tiposDePrenda.contains(tipo)) {
      throw new Error('Tipo de prenda invalido');
    }

    this.tipo = tipo;
    this.estado = estado;
    this.precioBase = precioBase;
  }

  // asumo que el porcentaje se aplica sobre el precio final, no el base
  public Float interesAgregado() {
    const Float interes = 0.01;
    return interes * this.precio();
  }

  public Float precio() {
    return this.estado.calcularPrecio(this.precioBase);
  }
}
