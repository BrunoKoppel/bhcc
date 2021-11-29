import java.rmi.*;

public interface AddServerIntf extends Remote {
  double add(double d1, double d2) throws RemoteException;
  double subtract(double d1, double d2) throws RemoteException;
  double multiply(double d1, double d2) throws RemoteException;
  double divide (double d1, double d2) throws RemoteException;
  double mod (double d1, double d2) throws RemoteException;
  double mortgage(double y0,double interest,int years) throws RemoteException;
  double futureValue(double y0, double i, int n) throws RemoteException;
}