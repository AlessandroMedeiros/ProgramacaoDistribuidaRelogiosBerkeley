package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ServerClock extends UnicastRemoteObject implements IServerClock {

    private LocalTime currentTime;
    public final DateTimeFormatter fTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    protected ServerClock(LocalTime currentTime) throws RemoteException {
        super();
        this.currentTime = currentTime;
    }

    @Override
    public LocalTime getClock() throws RemoteException {
        return currentTime;
    }

    @Override
    public void setClock(LocalTime clockClientTime, long nano) throws RemoteException {
        long localTimeNano = clockClientTime.toNanoOfDay();
        long currentNano = this.getClock().toNanoOfDay();
        var newTimeNano = currentNano - localTimeNano;
        newTimeNano = newTimeNano * (-1) + nano + localTimeNano;
        LocalTime newLocalTime = LocalTime.ofNanoOfDay(newTimeNano);
        System.out.println("Horario atualizado: " + fTimeFormatter.format(newLocalTime));
        this.currentTime = newLocalTime;
    }
}