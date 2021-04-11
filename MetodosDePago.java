// si no uso un metodo de pago en clase, le tengo que pasar metodo de pago como string y cantCuotas al constructor de Venta
// y me podria dar el siguiente caso: "efectivo" y 2 cuotas, el cual no tiene sentido
// la hago abstracta porque no deberias poder instanciar un metodo de pago
interface MetodoDePago {
  public abstract Float calcularInteres(Float precio);
}

class Efectivo implements MetodoDePago {
  public Float calcularInteres(Float precio) {
    return 0;
  }
}

class Tarjeta implements MetodoDePago {
  private Int cantCuotas;

  public Tarjeta(Int cantCuotas) {
    this.cantCuotas = cantCuotas;
  }

  public Float calcularInteres(Float precio) {

    const Int coeficienteFijo = 5; // estaria bueno obtenerlo de una archivo .config

    return this.cantCuotas * coeficienteFijo + precio;
  }
}
