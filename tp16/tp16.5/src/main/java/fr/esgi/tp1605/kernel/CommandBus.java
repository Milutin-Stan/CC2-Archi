package fr.esgi.tp1605.kernel;

public interface CommandBus {
    <C extends Command, R> R send(C command);
}
