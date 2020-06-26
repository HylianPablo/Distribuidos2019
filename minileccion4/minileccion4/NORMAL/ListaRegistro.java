package rmi.pruebas;

public class ListaRegistro implements java.io.Serializable {
  public static void main(String [] args) {
    try {
      System.out.println("Registro: ");
      for (String n : java.rmi.Naming.list("rmi://localhost:1099/"))
        System.out.println("> " + n);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
