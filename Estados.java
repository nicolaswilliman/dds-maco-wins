interface Estado {
  public Float calcularPrecio();
}

class Nueva implements Estado {
  public Int calcularPrecio(Int precioBase) {
    return precioBase;
  }
}

class Promocion implements Estado {

  private Float descuento;

  public Promocion(Int descuento) {
    this.descuento = descuento;
  }

  public Float calcularPrecio(Int precioBase) {
    return precioBase - this.descuento;
  }
}

class Liquidacion extends Estado {
  public Float calcularPrecio(Int precioBase) {
    return precioBase * 0.5; // 50% off 
  }
}