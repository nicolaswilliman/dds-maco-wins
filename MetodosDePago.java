// si no uso un metodo de pago en clase, le tengo que pasar metodo de pago como string y cantCuotas al constructor de Venta
// y me podria dar el siguiente caso: "efectivo" y 2 cuotas, el cual no tiene sentido
// la hago abstracta porque no deberias poder instanciar un metodo de pago
abstract class MetodoDePago {
  private Int cantCuotas;

  public Int getCantCuotas() {
    return this.cantCuotas;
  }

  public abstract String getMetodoDePago();
}

class Efectivo extends MetodoDePago {
  public Efectivo() {
    this.cantCuotas = 1;
  }

  public String getMetodoDePago() {
    return "efectivo";
  }
}

class Tarjeta extends MetodoDePago {
  public Efectivo(cantCuotas) {
    this.cantCuotas = cantCuotas;
  }

  public String getMetodoDePago() {
    return "tarjeta";
  }
}
