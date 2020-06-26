package fileserver;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Implementación de FileServidor
 * @author cllamas
 */
public class FileServidorImpl extends java.rmi.server.UnicastRemoteObject implements FileServidor, Serializable {

    public FileServidorImpl() throws RemoteException {
        super();
    }

    @Override
    public FileLector abre(String nombre) throws RemoteException , FileNotFoundException {
        return new FileLectorImpl(nombre);
    }

}
