abstract class Estado {
  public abstract calcularPrecio();
}

class Nueva extends Estado {
  public Int calcularPrecio(Int precioBase) {
    return precioBase;
  }
}

class Promocion extends Estado {

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
    return precioBase * 0.5; //50% off 
  }
}