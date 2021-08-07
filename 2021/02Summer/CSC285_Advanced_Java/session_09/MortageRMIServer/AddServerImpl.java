import java.rmi.*;
import java.rmi.server.*;
import java.lang.*;
import java.text.*;

public class AddServerImpl extends UnicastRemoteObject
  implements AddServerIntf {

  public AddServerImpl() throws RemoteException {}

  public double add(double d1, double d2) throws RemoteException {
    return d1 + d2;
	}
	public double subtract(double d1, double d2) throws RemoteException {
    return d1 - d2;
	}
	public double multiply(double d1, double d2) throws RemoteException {
    return d1 * d2;
	}
	
	public double divide (double d1, double d2) throws RemoteException {
    return d1/d2;
	}
	
	public double mod (double d1, double d2) throws RemoteException {
    return d1%d2;
	}
	
	public double mortgage(double y0,double interest,int years) throws RemoteException {
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		double R;
		R = (y0 * interest/1200.0 * Math.pow((1.0 +interest/1200.0),(years * 12)) ) / ( Math.pow((1+interest/1200.0),(years * 12d)) -1.0 );
		
		System.out.println("Your monthly mortgage payment is " + fmt.format(R));
		return R;
	}

	public double futureValue(double y0, double i , int n) throws RemoteException {
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		Double R;
		R = (y0 * i * Math.pow((1.0 + i),(n)));
		System.out.println("Your monthly mortgage payment is " + fmt.format(R));
		return R;
	}
}
