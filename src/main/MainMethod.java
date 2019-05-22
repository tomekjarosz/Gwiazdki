package main;

import InOut.Info;
import logic.StorageApp;

public class MainMethod {

    public static void main(String[] args) {

        Info.welcome();

        StorageApp storageApp = new StorageApp();

        storageApp.controlLoop();
    }
}
