package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalTime;

public interface IServerClock extends Remote {

	LocalTime getClock() throws RemoteException;

	void setClock(LocalTime clockClientTime, long nano) throws RemoteException;
}