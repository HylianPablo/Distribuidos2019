package holaServer;

//LANZADOR

public class RunHola {

   public static void main(String [ ] args) {
      try {
         HolaImpl oRemoto = new HolaImpl();
         java.rmi.registry.Registry registro = java.rmi.registry.LocateRegistry.getRegistry("localhost");
         registro.rebind("ObjetoHola", oRemoto);

         System.err.println("Servidor preparado");
      } catch (Exception e) {
         System.err.println("Excepción del servidor: "+e.toString());
         e.printStackTrace();
      }
   }
}
