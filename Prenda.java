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

  public Float precio() {
    return this.estado.calcularPrecio(this.precioBase);
  }
}
