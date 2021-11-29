
import java.rmi.*;
import java.rmi.server.*;
import java.lang.*;

public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf {
	public AddServerImpl() throws RemoteException {
	}

	public double rectangle(double d1, double d2) throws RemoteException {
		return d1 * d2;
	}// rectangle

	public double circle(double radius) throws RemoteException {
		return (Math.PI * radius * radius);
	}// circle

	public double trapezoid(double b1, double b2, double h) throws RemoteException {
		return (.5 * (b1 + b2) * h);
	}

	public double cube(double height, double length, double width) throws RemoteException{
		return (height * length * width);
	}

  public double cylinder(double radius, double height) throws RemoteException{
		return (radius * 2 * Math.PI * height);
	}

  public double triangle(double height, double width) throws RemoteException{
		return (height * witdth) / 2;
	}
}
