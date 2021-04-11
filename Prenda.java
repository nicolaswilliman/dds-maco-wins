class Prenda {

  private Estado estado;

  private String tipo;

  private Float precioBase;

  public Prenda(String tipo) {
    List<String> tiposDePrenda = ["saco", "pantalon", "camisa"];

    if (!tiposDePrenda.contains(tipo)) {
      throw new Error('Tipo de prenda invalido');
    }

    this.tipo = tipo;
  }

  // asumo que el porcentaje se aplica sobre el precio final, no el base
  public Float interesAgregado() {
    Float interes = 0.01;
    return interes * this.precio();
  }

  public Float precio() {
    return this.estado.calcularPrecio(this.precioBase);
  }
}
