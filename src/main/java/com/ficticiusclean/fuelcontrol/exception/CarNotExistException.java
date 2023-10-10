package com.ficticiusclean.fuelcontrol.exception;

import java.util.UUID;

public class CarNotExistException extends RuntimeException {
    public CarNotExistException(UUID uuid){
        super("Não localizado na frota um carro com o uuid: " + uuid.toString());
    }
}