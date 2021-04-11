class Prenda {

  private Estado estado;

  private Float precioBase;
  
  public Float precio() {
    return this.estado.calcularPrecio(this.precioBase);
  }
}
