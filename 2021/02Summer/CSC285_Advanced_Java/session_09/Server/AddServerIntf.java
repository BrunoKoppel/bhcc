
import java.rmi.*;

public interface AddServerIntf extends Remote {
  double rectangle (double d1, double d2) throws RemoteException;
  double circle (double radius) throws RemoteException;
  double trapezoid (double b1, double b2, double h) throws RemoteException;
  }
  